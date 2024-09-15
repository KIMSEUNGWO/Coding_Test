package 경로탐색.크루스칼;

import java.util.Arrays;

import static java.nio.file.Files.find;

public class 메인 {

    private static int final_cost = 0;
    private static int[] parent;

    public static void main(String[] args) {
        int[][] graph = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int n = 4;

        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for (int i = 0; i < graph.length; i++) {
            int node1 = graph[i][0];
            int node2 = graph[i][1];
            int cost = graph[i][2];

            if (find(node1) != find(node2)) {
                union(node1, node2);
                final_cost += cost;
            }

        }

        System.out.println("final_cost = " + final_cost);

    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
}
