package 프로그래머스.L3.가장먼노드;

import 프로그래머스.component.Confirm;

public class Main {

    private static Logic logic = new Logic();

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {2, 3}, {3, 4}, {1, 3}, {1, 4}, {2, 4}, {5, 4}};
        int result = logic.solution(n, vertex);
        Confirm.confirm(3, result);
    }
}
