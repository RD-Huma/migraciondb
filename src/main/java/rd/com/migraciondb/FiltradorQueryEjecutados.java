package rd.com.migraciondb;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

class FiltradorQueryEjecutados {

	private final Set<Path> archivosRestantes = new HashSet<>();
	private final Set<Path> archivosOrigen;
	private Configuracion configuracion;

	public FiltradorQueryEjecutados(Set<Path> archivosOrigen, Configuracion configuracion) {
		this.archivosOrigen = archivosOrigen;
		this.configuracion = configuracion;
	}

	public Set<Path> filtrar(){
		for (Path path : archivosOrigen) {
			if (new DebeEjecutarEscript(path.getFileName().toString(),configuracion.getDataSourceDB()).debe()){
				archivosRestantes.add(path);
			}

		}

		return archivosRestantes;
	}

}