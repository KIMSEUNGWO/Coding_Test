import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        WordData wordData = new WordData();
        wordData.addWord("몇 년");
        wordData.addWord("내후년");
        wordData.addWord("이번년");

        String txt = "년";
        long start = System.nanoTime();
//        boolean exists = wordData.has(txt);
        Collection<String> hass = wordData.hass(txt);
        long end = System.nanoTime();
        System.out.println("hass = " + hass);
//        System.out.println("exists = " + exists);
        System.out.println("걸린시간 : " + ((end - start) / 1000000.0) + " /ms");

    }

}