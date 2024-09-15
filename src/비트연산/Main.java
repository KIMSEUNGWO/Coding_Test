package 비트연산;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        Deque<Stone> dq = new ArrayDeque<>();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];

            while (!dq.isEmpty() && i - dq.peekFirst().index >= k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && stone > dq.peekLast().value) {
                dq.removeLast();
            }

            dq.addLast(new Stone(i, stone));
            System.out.println("dq = " + dq);
            if (dq.size() == k) {
                answer = Math.min(answer, dq.peekFirst().value);
            }
        }

        System.out.println("answer = " + answer);
    }


    public static class Stone {
        int index;
        int value;

        public Stone(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

}
