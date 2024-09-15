package 비트연산;

public class CountingBits {

    // 2진수에서 1개 개수를 세는 알고리즘
    public static void main(String[] args) {

    }

    private static int getBitCount(int bit) {
        int count = 0;
        while (bit > 0) {
            // num과 (num-1)의 AND 연산을 수행하면 가장 오른쪽의 1 비트가 0으로 변환된다.
            bit = bit & (bit - 1);
            count++;
        }
        return count;
    }
}
