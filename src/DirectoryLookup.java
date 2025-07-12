import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class DirectoryLookup {
    public static void main(String[] args) {
        List<String> filenames;
        Path directoryPath = Paths.get("C:/Users/cubec/OneDrive/Documents");
        if(!Files.exists(directoryPath) || !Files.isDirectory(directoryPath)) {
            System.out.println("Error Path/Directory is not correct");
            System.exit(0);
        }
        //non-recursive, printing only files present in path
        try (Stream<Path> paths  = Files.list(directoryPath)) {
            filenames  = paths.filter(Files::isRegularFile)
                    .map(path -> path.getFileName().toString()).toList();
            System.out.println("File Names: "+filenames);

            //filter files with specific extension
            filenames = filenames.stream().filter(filename -> filename.endsWith(".pdf")).toList();
            System.out.println("Filtered File Names: "+filenames);

        } catch (IOException e) {
            System.out.println("Error occurred: "+e);
        }



        //recursive, printing all file names in sub-directories too
        try (Stream<Path> paths  = Files.walk(directoryPath)) {
            filenames  = paths.filter(Files::isRegularFile)
                    .map(path -> directoryPath.relativize(path).toString()).toList();
            System.out.println("File Names: "+filenames);
        } catch (IOException e) {
            System.out.println("Error occurred: "+e);
        }
    }
}
