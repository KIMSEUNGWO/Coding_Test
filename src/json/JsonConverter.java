package json;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonConverter {

    public <T> T parseToObject(Map<String, Object> parse, Class<T> clazz) throws JsonParseException {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();

            // 클래스의 필드 목록을 가져옴
            Field[] fields = clazz.getDeclaredFields();

            // 필드에 값을 매핑
            for (Field field : fields) {
                field.setAccessible(true); // private 필드 접근 허용

                // 필드 이름을 키로 하여 Map에서 값을 가져옴
                Object value = parse.get(field.getName());

                // Map에 해당 필드에 대한 값이 존재하는 경우
                if (value != null) {
                    // 필드 타입에 맞는 값으로 변환하여 필드에 할당
                    field.set(instance, classConvert(field.getType(), value));
                }
            }

            return instance;
        } catch (Exception e) {
            throw new JsonParseException("Error parsing JSON to object: " + e.getMessage());
        }
    }


    private Object classConvert(Class<?> clazz, Object value) {
        if (clazz == String.class) {
            return value.toString();
        } else if (clazz == int.class || clazz == Integer.class) {
            return Integer.parseInt(value.toString());
        } else if (clazz == long.class || clazz == Long.class) {
            return Long.parseLong(value.toString());
        } else if (clazz == float.class || clazz == Float.class) {
            return Float.parseFloat(value.toString());
        } else if (clazz == double.class || clazz == Double.class) {
            return Double.parseDouble(value.toString());
        } else if (clazz == boolean.class || clazz == Boolean.class) {
            return Boolean.parseBoolean(value.toString());
        } else if (List.class.isAssignableFrom(clazz)) {
            if (value instanceof List) {
                return new ArrayList<Object>((List<?>) value);
            }
        } else if (Map.class.isAssignableFrom(clazz)) {
            if (value instanceof Map) {
                return new HashMap<Object, Object>((Map<?, ?>) value);
            }
        }
        return value;
    }
}
