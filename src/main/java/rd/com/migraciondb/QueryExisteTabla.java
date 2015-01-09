package rd.com.migraciondb;

public class QueryExisteTabla extends Query {

	@Override
	void genera(StringBuilder queryBuilder, Configuracion configuracion) {
		queryBuilder.append("SELECT COUNT(*) from dba_tables where table_name = '").append(configuracion.getTabla()).append("'");
	}
}
