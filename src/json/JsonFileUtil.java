package json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class JsonFileUtil {


    public String read(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public void write(String path, String json) throws IOException {
        Files.write(Paths.get(path), json.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

}
