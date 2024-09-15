import java.util.*;
import java.util.stream.IntStream;

public class WordData {

    private final Map<Character, WordData> data = new HashMap<>();

    public void addWord(String word) {
        push(word, 0);
    }

    private void push(String word, int idx) {
        if (word.length() <= idx) return;

        char c = word.charAt(idx);

        if (!data.containsKey(c)) data.put(c, new WordData());
        WordData wordData = data.get(c);
        wordData.push(word, idx + 1);

    }

    public void print() {
        if (data.isEmpty()) {
            System.out.println();
        }
        for (char c : data.keySet()) {
            System.out.print(c + " ");
            data.get(c).print();
        }
    }

    public boolean has(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (find(str, i)) return true;
        }
        return false;
    }

    private boolean find(String str, int idx) {
        if (data.isEmpty()) return true;
        if (str.length() < idx || !data.containsKey(str.charAt(idx))) return false;
        return data.get(str.charAt(idx)).find(str, idx + 1);
    }

    public Set<String> hass(String str) {
        Set<String> words = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            String txt = finds(str, i);
            System.out.println("txt = " + txt + " i = " + i);
            if (txt != null) words.add(txt);
        }
        return words;
    }

    private String finds(String str, int idx) {
        if (data.isEmpty()) return "";
        if (str.length() <= idx || !data.containsKey(str.charAt(idx))) return null;
        String next = data.get(str.charAt(idx)).finds(str, idx + 1);
        if (next == null) return null;
        return str.charAt(idx) + next;
    }

}