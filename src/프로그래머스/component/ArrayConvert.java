package 프로그래머스.component;

public class ArrayConvert {

    public static void convert(String arrayText) {
        String replace = arrayText.replace("[", "{").replace("]", "}");
        System.out.println(replace);
    }
}
