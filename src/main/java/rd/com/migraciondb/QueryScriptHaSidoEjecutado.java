package rd.com.migraciondb;

public class QueryScriptHaSidoEjecutado extends Query {

	@Override
	public void genera(StringBuilder queryBuilder,Configuracion configuracion) {
		queryBuilder.append("SELECT COUNT(*) from ")
					.append(configuracion.getTabla())
					.append(" WHERE ")
					.append(Tabla.PK_ARCHIVO)
					.append(" = ?");
	}

}