package rd.com.migraciondb;


class QueryInsert extends Query {

	@Override
	void genera(StringBuilder queryBuilder, Configuracion configuracion) {
		queryBuilder.append("INSERT INTO ").append(configuracion.getTabla()).append(" (")
		.append(Tabla.PK_ARCHIVO).append(" , ")
		.append(Tabla.EJECUCION_EXITOSA).append(" , ")
		.append(Tabla.FECHA_REGISTRO).append(" ) VALUES (?, ? , ?)  ");
	}

}