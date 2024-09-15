package 해시코드재정의;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Member member1 = new Member(1L, "첫번째");
        Member member2 = new Member(1L, "두번째");

        System.out.println("member1 = " + member1);
        System.out.println("member2 = " + member2);
        System.out.println("member1.hashCode() = " + member1.hashCode());
        System.out.println("member2.hashCode() = " + member2.hashCode());
        System.out.println(member1.equals(member2));

        List<Member> list = Stream.of(member1, member2).distinct().toList();
        System.out.println("list = " + list);
    }
}
