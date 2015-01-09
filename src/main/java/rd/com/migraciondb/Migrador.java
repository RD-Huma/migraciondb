package rd.com.migraciondb;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

class Migrador {


	public void migrar(Configuracion configuracion){
		try (Connection conexion = configuracion.getDataSourceDB().activarConexion()){
			if (!new VerificadorExisteTabla(configuracion).existe()){
				new CreadorTabla(configuracion).crearTabla();
			}
		} catch (SQLException e) {
			throw new MigracionDBException(e);
		}


		BuscarRecursos buscarRecursos =  new BuscarRecursos(configuracion.getPrefijoCarpeta());
		Set<Path> recursosEncontrados =  buscarRecursos.buscar();
		Set<Path> recursosFiltrados;
		try (Connection conexion = configuracion.getDataSourceDB().activarConexion()){

			FiltradorQueryEjecutados filtrado = new FiltradorQueryEjecutados(recursosEncontrados, configuracion) ;
			recursosFiltrados = filtrado.filtrar();
		} catch (SQLException e) {
			throw new MigracionDBException(e);
		}

		try (Connection conexion = configuracion.getDataSourceDB().activarConexion()){
			for (Path path : recursosFiltrados) {

				 SqlRunner runner = new SqlRunner(conexion);
				 runner.runScript(Files.newBufferedReader(path,Charset.defaultCharset()));

			}
		} catch (SQLException | IOException e) {
			throw new MigracionDBException(e);
		}
	}

}