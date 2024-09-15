package effective_java.hashcode;

import java.util.Objects;

public class HashCodeTest {

    private final int id;
    private final String name;

    public HashCodeTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 31 을 곱하는 이유
    // 1. 31은 홀수이면서 소수이다.
    //  만약 숫자가 짝수이고 오버플로우가 발생한다면 정보를 잃는다.
    //  2를 곱하는 것은 시프트연산과 같은 결과를 내기 때문이다.
    // 2. 소수를 곱하는 이유는 명확하지는 않지만 전통적으로 해왔다.
    // 따라서 31을 이용하면 곱셈을 시프트 연산과 뺄셈으로 대체해 최적화 할 수 있다 (31 * i는 (i << 5) - i 와 같다.)

    // 최신 방식은 아니지만 충분히 훌륭한 해싱방법이다.
    // 해시 충돌이 더욱 적은 방법을 꼭 사용해야 한다면,
    // 구아바(Guava)의 com.google.common.hash.Hasing을 참고해보자
    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result + name.hashCode();
        return result;
        // 이런 방법도 있는데 성능이 아쉽다.
//        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HashCodeTest)) return false;
        HashCodeTest other = (HashCodeTest) obj;
        return other.id == id && Objects.equals(name, other.name);
    }
}
