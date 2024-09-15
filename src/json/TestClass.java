package json;

import java.util.List;

public class TestClass {

    private int id;
    private String title;
    private boolean has;
    private List<Integer> array;

    @Override
    public String toString() {
        return "TestClass{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", has=" + has +
            ", array=" + array +
            '}';
    }
}
