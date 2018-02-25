import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class EventoNavegacaoComFiltro extends SimpleFileVisitor<Path> {
	
	private PathMatcher matcher;
	
	public EventoNavegacaoComFiltro(PathMatcher matcher) {
		this.matcher = matcher;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if(matcher.matches(file)){
			System.out.println("Arquivo " + file.toAbsolutePath());
		}
		return FileVisitResult.CONTINUE;
	}

	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("/Volumes/Arquivos/workspace/aj4lab02_02/");
		
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.java");
		Files.walkFileTree(path, new EventoNavegacaoComFiltro(matcher));
		
		
	}
	
}
