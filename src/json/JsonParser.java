package json;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParser {

    private final JsonParserValidator validator = new JsonParserValidator();


    public Map<String, Object> parse(String json) throws JsonParseException {
        Map<String, Object> result = new HashMap<>();
        List<String> strings = seperatedKeyAndValue(json);

        for (String keyAndValue : strings) {
            String[] strings1 = splitKeyAndValue(keyAndValue);
            String key = strings1[0];
            String value = strings1[1];

            String mapKey = jsonToString(key);
            Object mapValue = getValue(value, getClazz(value));
            result.put(mapKey, mapValue);
        }
        return result;
    }

    private Class<?> getClazz(String json) throws JsonParseException {
        if (validator.isList(json)) return List.class;
        if (validator.isMap(json)) return Map.class;
        if (validator.isBoolean(json)) return Boolean.class;
        if (validator.isString(json)) return String.class;
        if (validator.isDate(json)) return LocalDateTime.class;
        if (validator.isNumber(json)) return jsonToNumber(json).getClass();
        throw new JsonParseException("데이터 형식이 잘못됨");
    }
    private Object getValue(String json, Class<?> clazz) throws JsonParseException {
        System.out.println("json : " + json + " clazz = " + clazz);
        if (clazz == String.class) return jsonToString(json);

        if (Number.class.isAssignableFrom(clazz)) return jsonToNumber(json);

        if (clazz == Boolean.class) return Boolean.parseBoolean(json);
        if (clazz == LocalDateTime.class) return LocalDateTime.parse(json);
        if (clazz == LocalDate.class) return LocalDate.parse(json);

        if (clazz == List.class) return jsonToList(json);
        if (clazz == Map.class) return parse(json);

        throw new JsonParseException("Value 형식이 잘못됨");
    }


    private List<String> seperatedKeyAndValue(String json) {
        List<String> result = new ArrayList<>();
        json = json.substring(json.indexOf('{') + 1, json.lastIndexOf('}'));

        StringBuilder sb = new StringBuilder();

        boolean isString = false;
        int level = 0;
        int arrayLevel = 0;

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            if (!isString && c == ' ') continue;
            else if (c == '"') isString = !isString;
            else if (c == '{') level++;
            else if (c == '}') level--;
            else if (c == '[') arrayLevel++;
            else if (c == ']') arrayLevel--;

            if (!isString && level == 0 && arrayLevel == 0 && c == ',') {
                result.add(sb.toString());
                sb.setLength(0);
            } else if (i == json.length() - 1) {
                sb.append(c);
                result.add(sb.toString());
            } else {
                sb.append(c);
            }

        }

        return result;
    }
    private String[] splitKeyAndValue(String json) throws JsonParseException {
        String[] result = new String[2];

        boolean isString = false;

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '"') isString = !isString;
            if (!isString && c == ':') {
                result[0] = json.substring(0, i);
                result[1] = json.substring(i + 1);
                return result;
            }

        }

        throw new JsonParseException("잘못된 형식임");
    }

    private String jsonToString(String json) {
        int i = json.indexOf('"');
        int j = json.lastIndexOf('"');
        if (i + 1 == j) return "";
        else return json.substring(i + 1, j);
    }
    private Number jsonToNumber(String json) throws JsonParseException {
        try {
            return Integer.parseInt(json);
        } catch (NumberFormatException e) {
            try {
                return Long.parseLong(json);
            } catch (NumberFormatException e2) {
                try {
                    return Double.parseDouble(json);
                } catch (NumberFormatException e3) {
                    throw new JsonParseException("Number 형식이 잘못됨");
                }
            }
        }
    }
    private List<Object> jsonToList(String json) throws JsonParseException {
        List<Object> result = new ArrayList<>();

        int start = json.indexOf('['); int end = json.lastIndexOf(']');
        if (start + 1 == end) return new ArrayList<>();

        json = json.substring(start + 1, end);


        List<String> split = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        boolean isString = false;
        int level = 0;

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            if (!isString && c == ' ') continue;
            else if (c == '"') isString = !isString;
            else if (c == '{') level++;
            else if (c == '}') level--;

            if (!isString && level == 0 && c == ',') {
                split.add(sb.toString());
                sb.setLength(0);
            } else if (i == json.length() - 1) {
                sb.append(c);
                split.add(sb.toString());
            } else {
                sb.append(c);
            }

        }

        for (String data : split) {
            result.add(getValue(data, getClazz(data)));
        }

        return result;
    }



}
