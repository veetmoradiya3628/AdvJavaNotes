package inputoutputstreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SearchFilesByExtension {
    public long getNumberOfFilesWithExtension(Path pathToStartSearch, String extension) throws IOException {
        if (pathToStartSearch == null || extension == null) return 0;
        return Files.walk(pathToStartSearch)
                .filter(Files::isRegularFile)
                .filter(file -> file.getFileName().toString().toLowerCase().endsWith(extension.toLowerCase()))
                .count();
    }
}
