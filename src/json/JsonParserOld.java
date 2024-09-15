package json;

import java.util.*;
import java.util.function.Predicate;

public class JsonParserOld {

    public final Map<Class<?>, Predicate<?>> predicateMap = new HashMap<>();

    public JsonParserOld() {
        predicateMap.put(String.class, (Predicate<String>) this::isString);
        predicateMap.put(Number.class, (Predicate<String>) this::isNumber);
        predicateMap.put(Boolean.class, (Predicate<String>) this::isBoolean);
        predicateMap.put(List.class, (Predicate<String>) this::isArray);
        predicateMap.put(Map.class, (Predicate<String>) this::isMap);
    }

    public Map<String, Object> parse(String json) {
        Map<String, Object> result = new HashMap<>();
        List<String> seperatedKeyAndValue = seperatedKeyAndValue(json);
        return result;
    }


    private String jsonToString(String json) {
        return getInside(json);
    }

    private Number jsonToNumber(String json) {
        try {
            return Integer.parseInt(json);
        } catch (NumberFormatException e) {
            try {
                return Long.parseLong(json);
            } catch (NumberFormatException ee) {
                try {
                    return Double.parseDouble(json);
                } catch (NumberFormatException eee) {
                    return null;
                }
            }
        }
    }

    private Boolean jsonToBoolean(String json) {
        return json.equalsIgnoreCase("true") || json.equalsIgnoreCase("false");
    }

    private <T> List<T> jsonToList(String json, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        json = getInside(json);


        return list;
    }

    private String getInside(String json) {
        return json.substring(1, json.length() - 1);
    }

    public List<String> seperatedKeyAndValue(String json) {
        List<String> result = new ArrayList<>();
        json = getInside(json);

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



    private boolean isString(String json) {
        return json.startsWith("\"") && json.endsWith("\"");
    }
    private boolean isNumber(String json) {
        try {
            Integer.parseInt(json);
            return true;
        } catch (NumberFormatException e) {
            try {
                Long.parseLong(json);
                return true;
            } catch (NumberFormatException ee) {
                try {
                    Double.parseDouble(json);
                    return true;
                } catch (NumberFormatException eee) {
                    return false;
                }
            }
        }
    }
    private boolean isBoolean(String json) {
        return json.equalsIgnoreCase("true") || json.equalsIgnoreCase("false");
    }
    private boolean isArray(String json) {
        return json.startsWith("[") && json.endsWith("]");
    }
    private boolean isMap(String json) {
        return json.startsWith("{") && json.endsWith("}");
    }
}
