package rd.com.migraciondb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

class DataSourceDB {

	private final DataSource dataSource;

	private Configuracion configuracion;

	private Connection connectionActiva;

	private Query queryScriptHaSidoEjecutado;

	private Query queryExisteDB;

	private Query queryCreaTabla;

	public DataSourceDB(String nombreJNDI) {
		try {
			 dataSource = (DataSource) new InitialContext().lookup(nombreJNDI);
		} catch (NamingException e) {
			throw new MigracionDBException(e);
		}
	}

	public DataSourceDB(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public Connection activarConexion(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new MigracionDBException(e);
		}
	}

	public Connection getConnectionActiva() {
		return connectionActiva;
	}

	public PreparedStatement nuevoPrepareStatement(String sql){
		try {
			return connectionActiva.prepareStatement(sql);
		} catch (SQLException e) {
			throw new MigracionDBException(e);
		}
	}

	public void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

	public Configuracion getConfiguracion() {
		return configuracion;
	}

	public Query getQueryScriptHaSidoEjecutado(){
		if (queryScriptHaSidoEjecutado == null){
			this.queryScriptHaSidoEjecutado = new QueryScriptHaSidoEjecutado().genera(configuracion);
		}
		return queryScriptHaSidoEjecutado;
	}

	public Query getQueryExisteTablaDB(){
		if (queryExisteDB == null){
			this.queryExisteDB = new QueryExisteTabla().genera(configuracion);
		}
		return queryExisteDB;
	}

	public Query getQueryCreaTablaDB(){
		if (queryCreaTabla == null){
			this.queryCreaTabla = new QueryExisteTabla().genera(configuracion);
		}
		return queryCreaTabla;
	}
}