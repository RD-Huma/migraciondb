package rd.com.migraciondb;

import javax.sql.DataSource;

public class Configuracion {

	private static final String TABLA = "MIGRACIONES";
	private static final String PREFIJO_CARPETA = "META-INF/migracion";


	private String tabla = TABLA;

	private DataSourceDB dataSourceDB;

	private String prefijoCarpeta = PREFIJO_CARPETA;


	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getTabla() {
		return tabla;
	}

	public void setDatasource(String datasource) {
		dataSourceDB = new DataSourceDB(datasource);
		dataSourceDB.setConfiguracion(this);
	}

	public void setDatasource(DataSource datasource) {
		dataSourceDB = new DataSourceDB(datasource);
		dataSourceDB.setConfiguracion(this);
	}

	DataSourceDB getDataSourceDB() {
		return dataSourceDB;
	}

	public void setPrefijoCarpeta(String prefijoCarpeta) {
		this.prefijoCarpeta = prefijoCarpeta;
	}

	public String getPrefijoCarpeta() {
		return prefijoCarpeta;
	}
}