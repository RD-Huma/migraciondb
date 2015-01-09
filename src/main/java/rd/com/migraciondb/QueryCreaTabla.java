package rd.com.migraciondb;


public class QueryCreaTabla extends Query {

	@Override
	void genera(StringBuilder queryBuilder, Configuracion configuracion) {
		queryBuilder.append("CREATE TABLE ").append(configuracion.getTabla()).append(" ( ");
		queryBuilder.append(Tabla.PK_ARCHIVO).append(' ').append(" varchar2(250) , ");
		queryBuilder.append(Tabla.EJECUCION_EXITOSA).append(' ').append(" varchar2(1) , ");
		queryBuilder.append(Tabla.FECHA_REGISTRO).append(' ').append(" varchar2(1) , ");

		queryBuilder.append("CONSTRAINT ").append(configuracion.getTabla()).append("_PK PRIMARY KEY (").append(Tabla.EJECUCION_EXITOSA).append(")");
		queryBuilder.append(");");

	}

}
