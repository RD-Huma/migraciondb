package rd.com.migraciondb;

public abstract class Query {

	private String query;

	@SuppressWarnings("unchecked")
	public <T extends Query>  T genera(Configuracion configuracion){
		StringBuilder sb = new StringBuilder(150);
		genera(sb, configuracion);
		query = sb.toString();
		return (T) this;
	}

	abstract void genera(StringBuilder queryBuilder, Configuracion configuracion);

	public String getQuery() {
		return query;
	}
}