package 그래프.유니온파인드;

import java.util.stream.IntStream;

public class 연습 {

    private static int[] parent;

    public static void main(String[] args) {
        int[][] graphs = {
            {0, 1},
            {2, 3},
            {2, 4},
            {1, 3}
        };
        int nodeCount = 5;
        parent = new int[nodeCount];
        IntStream.range(0, nodeCount).forEach(x -> parent[x] = x);

        for (int[] graph : graphs) {
            union(graph[0], graph[1]);
        }

        for (int i : parent) {
            System.out.print(i + " ");
        }
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        if (x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
}
