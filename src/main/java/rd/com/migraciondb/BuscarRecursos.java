package rd.com.migraciondb;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

class BuscarRecursos {


	private Set<Path> archivosEncontrados = new HashSet<>();

	private final String prefijoCarpeta;

	public BuscarRecursos(String prefijoCarpeta){
		this.prefijoCarpeta = prefijoCarpeta;
	}

	public Set<Path> buscar(){
		try {
			Enumeration<URL> enumaracion = ClassLoader.getSystemResources(prefijoCarpeta);
			while(enumaracion.hasMoreElements()){
				URL urlRecurso = enumaracion.nextElement();
				Path path = Paths.get(urlRecurso.getFile());
				if (Files.isDirectory(path)){
					Files.walkFileTree(path, new VisitadorSQLFiles(archivosEncontrados));
				}
			}

		} catch (IOException e) {
			throw new MigracionDBException(e);
		}
		return Collections.unmodifiableSet(archivosEncontrados);
	}
}