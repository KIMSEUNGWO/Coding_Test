package effective_java.hashcode;

import java.util.HashMap;
import java.util.Map;

public class 동치성무결성테스트 {

    public static void main(String[] args) {

        HashCodeTest test1 = new HashCodeTest(1, "김승우");
        HashCodeTest test2 = new HashCodeTest(1, "김승우");

        System.out.println("test1.hashCode() = " + test1.hashCode());
        System.out.println("test2.hashCode() = " + test2.hashCode());
        System.out.println(test1 == test2);
    }
}

