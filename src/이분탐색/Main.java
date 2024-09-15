package 이분탐색;

public class Main {

    public static void main(String[] args) {
        int[] stones = {4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 0;

        int left = 1;
        int right = stones.length;
        int max = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;

            System.out.println("left : " + left + " right : " + right + " mid : " + mid);

            for (int i : stones) {
                cnt = (i - mid) < 0 ? cnt + 1: 0;
                System.out.println("(i - mid) : " + (i - mid) + " : i : " + i + " cnt : " + cnt);
                if (cnt == k) {
                    break;
                }
            }
            if (cnt < k) {
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }

            System.out.println();
        }

        System.out.println("정답 max = " + max);

    }
}
