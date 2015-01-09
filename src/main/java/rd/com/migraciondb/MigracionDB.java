package rd.com.migraciondb;


public class MigracionDB {

	private final Configuracion configuracion;

	private MigracionDB() {
		this(new Configuracion());
	}

	private MigracionDB(Configuracion configuracion) {
		this.configuracion = configuracion;
	}


	public void migrar(){
		new Migrador().migrar(configuracion);
	}
}