package rd.com.migraciondb;

import java.sql.SQLException;
import java.sql.Statement;

class CreadorTabla {

	private Configuracion configuracion;

	public CreadorTabla(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

	public void crearTabla() {
		try (Statement st = configuracion.getDataSourceDB().getConnectionActiva().createStatement()){

		} catch (SQLException e) {
			throw new MigracionDBException(e);
		}

	}



}
