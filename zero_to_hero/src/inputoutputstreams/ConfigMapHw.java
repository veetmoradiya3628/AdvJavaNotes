package inputoutputstreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ConfigMapHw {
    public String getValueFromConfigMap(Path configMapFilePath, String keyName) throws IOException {
        if (configMapFilePath == null || keyName == null || keyName.isBlank()) return null;
        if (!Files.exists(configMapFilePath) || !Files.isRegularFile(configMapFilePath)) return null;
        List<String> lines = Files.readAllLines(configMapFilePath);
        for(String line : lines){
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) continue;
            int idx = line.indexOf("=");
            if (idx == -1) continue;
            String key = line.substring(0, idx).trim();
            String value = line.substring(idx + 1).trim();
            if (key.equals(keyName)) return value;
        }
        return null;
    }
}
