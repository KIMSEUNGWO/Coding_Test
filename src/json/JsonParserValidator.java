package json;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class JsonParserValidator {

    public boolean isString(String json) {
        return isWrap(json, '"', '"');
    }

    public boolean isNumber(String json) {
        try {
            Integer.parseInt(json);
            return true;
        } catch (NumberFormatException e) {
            try {
                Long.parseLong(json);
                return true;
            } catch (NumberFormatException e2) {
                try {
                    Double.parseDouble(json);
                    return true;
                } catch (NumberFormatException e3) {
                    return false;
                }
            }
        }
    }

    public boolean isBoolean(String json) {
        return json.equalsIgnoreCase("true") || json.equalsIgnoreCase("false");
    }

    public boolean isList(String json) {
        return isWrap(json, '[', ']');
    }

    public boolean isMap(String json) {
        return isWrap(json, '{', '}');
    }

    public boolean isDate(String json) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        try {
            LocalDateTime.parse(json, formatter);
            return true;  // 성공하면 시간 데이터로 인식
        } catch (DateTimeParseException e) {
            return false; // 실패하면 시간 데이터가 아님
        }
    }

    private boolean isWrap(String json, char left, char right) {
        int i = json.indexOf(left);
        int j = json.lastIndexOf(right);
        return i != -1 && j != -1 && i != j;
    }
}
