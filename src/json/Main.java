package json;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    private static final JsonParserOld parser = new JsonParserOld();
    private static final JsonParserValidator a = new JsonParserValidator();
    private static final JsonMapper mapper = new JsonMapper();

    private static final String jsonPath = "/Users/tmd8635/Desktop/project/Coding_Test/src/json/test.json";
    public static void main(String[] args) throws IOException, JsonParseException {
        String read = mapper.read(jsonPath);
        Map<String, Object> parse = mapper.parse(read);
        System.out.println("parse = " + parse);

    }
}
