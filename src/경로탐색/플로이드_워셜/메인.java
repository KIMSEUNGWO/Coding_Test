package 경로탐색.플로이드_워셜;

public class 메인 {

    private static final int NODE_COUNT = 5;

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 5},
            {0, 2, 7},
            {0, 4, 1},
            {0, 3, 2},
            {4, 3, 4},
            {1, 2, 3},
            {1, 3, 6},
            {2, 3, 10},
        };

        int[][] node = createNode(graph);

        floyd_warshall(node);

        for (int[] ints : node) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void floyd_warshall(int[][] node) {
        for (int i = 0; i < NODE_COUNT; i++) {
            for (int j = 0; j < NODE_COUNT; j++) {
                for (int k = 0; k < NODE_COUNT; k++) {
                     node[j][k] = Math.min(node[j][k], node[j][i] + node[i][k]);
                }
            }
        }
    }

    private static int[][] createNode(int[][] graph) {
        int[][] nodes = new int[NODE_COUNT][NODE_COUNT];
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                if (i == j) continue;
                if (nodes[i][j] == 0) nodes[i][j] = 10000000;
            }
        }
        for (int[] t : graph) {
            nodes[t[0]][t[1]] = nodes[t[1]][t[0]] = Math.min(t[2], nodes[t[0]][t[1]]);
        }


        return nodes;
    }
    private static int getNodeCount(int[][] graph) {
        int max = 0;
        for (int[] ints : graph) {

            for (int anInt : ints) {
                if (max < anInt) max = anInt;
            }
        }
        return max;
    }
}
