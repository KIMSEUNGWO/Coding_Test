package json;

import java.util.Map;

public class JsonMapper extends JsonFileUtil {

    private final JsonConverter converter = new JsonConverter();
    private final JsonParser parser = new JsonParser();

    public Map<String, Object> parse(String json) throws JsonParseException {
        return parser.parse(json);
    }

    public <T> T parseToObject(String json, Class<T> clazz) throws JsonParseException {
        return converter.parseToObject(parse(json), clazz);
    }

}
