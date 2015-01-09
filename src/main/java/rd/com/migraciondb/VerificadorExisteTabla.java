package rd.com.migraciondb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class VerificadorExisteTabla {

	private Configuracion configuracion;

	VerificadorExisteTabla(Configuracion configuracion){
		this.configuracion = configuracion;
	}

	public boolean existe(){
		try (Statement statement = configuracion.getDataSourceDB().getConnectionActiva().createStatement();
			ResultSet rs = statement.executeQuery(configuracion.getDataSourceDB().getQueryExisteTablaDB().getQuery())){
			  if (rs.next()){
				return rs.getInt(1)>0;
			  }
		} catch (SQLException e) {
			throw new MigracionDBException(e);
		}
		return false;
	}
}