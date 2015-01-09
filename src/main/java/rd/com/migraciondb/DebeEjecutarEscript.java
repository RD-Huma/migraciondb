package rd.com.migraciondb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


class DebeEjecutarEscript {

	private final DataSourceDB dataSourceDB;

	private final String script;

	public DebeEjecutarEscript(String script, DataSourceDB dataSourceDB){
		this.script = script;
		this.dataSourceDB = dataSourceDB;
	}

	public boolean debe(){
		try(PreparedStatement ps = dataSourceDB.nuevoPrepareStatement(dataSourceDB.getQueryScriptHaSidoEjecutado().getQuery())) {

			ps.setString(1, script);
			try (ResultSet rs = ps.executeQuery()){
				if (rs.next()){
					return rs.getInt(1)==0;
				}
			}

		} catch (SQLException e) {
			throw new MigracionDBException(e);
		}



		return true;
	}
}