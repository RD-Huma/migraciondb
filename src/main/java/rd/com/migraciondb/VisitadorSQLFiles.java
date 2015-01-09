package rd.com.migraciondb;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Set;

class VisitadorSQLFiles extends SimpleFileVisitor<Path>{

	private Set<Path> archivosEncontrados;

	public VisitadorSQLFiles(Set<Path> archivosEncontrados) {
		this.archivosEncontrados = archivosEncontrados;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)	 {
		if (dir.startsWith(".")){
			return FileVisitResult.SKIP_SUBTREE;
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)	 {
		if (file.toString().toLowerCase().endsWith(".sql")){
			archivosEncontrados.add(file);
		}

		return FileVisitResult.CONTINUE;
	}


}