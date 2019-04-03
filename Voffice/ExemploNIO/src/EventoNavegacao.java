import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class EventoNavegacao implements FileVisitor<Path> {

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println("=> vai entrar no diretorio " + dir.toAbsolutePath());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println("=> encontrei o arquivo " + file.toAbsolutePath());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		System.out.println("=> saiu do diretorio " + dir.toAbsolutePath());
		return FileVisitResult.CONTINUE;
	}

	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("/Volumes/Arquivos/workspace/aj4lab02_02/");
		Files.walkFileTree(path, new EventoNavegacao());
		
		
	}
	
}
