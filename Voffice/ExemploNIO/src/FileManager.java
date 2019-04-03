import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class FileManager {

	public static void printProperties(String filename) throws IOException{
		
		Path p = Paths.get(filename);
		
		if(Files.exists(p)){
			printCommonsProperties(p);
			if(Files.isDirectory(p)){
				printDirectoryProperties(p);
			}else{
				printFileProperties(p);
			}
			
		}
		
	}

	private static void printFileProperties(Path p) throws IOException {
		System.out.println("===================================");
		FileTime data = Files.getLastModifiedTime(p);
		System.out.println("Ultima modificacao do arquivo: " + data);
		System.out.println("Tamanho do arquivo: " + Files.size(p));
		System.out.println("===================================");
	}

	private static void printDirectoryProperties(Path p) throws IOException {
		System.out.println("===================================");
		System.out.println("Conteudo do diretorio: ");
		//for(Path path : Files.newDirectoryStream(p)){//pega todos os arquivos e diretorios
		for(Path path : Files.newDirectoryStream(p,"*.png")){//pega os arquivos e diretorios segundo os parametros
			System.out.println("===> " + path.getFileName());
		}
		System.out.println("===================================");
	}

	private static void printCommonsProperties(Path p) {
		System.out.println("===================================");
		System.out.println("path: " + p.toAbsolutePath());
		System.out.println("Leitura: " + Files.isReadable(p));
		System.out.println("Escrita: " + Files.isWritable(p));
		System.out.println("===================================");
	}

	public static void main(String[] args) throws IOException {
		String caminho = "/Volumes/Arquivos/Google Drive/";
		FileManager.printProperties(caminho);
	}
	
}
