package 경로탐색.다익스트라;

/**
 * 가장 단순한 선형탐색방법임
 * 시간복잡도는 O(N^2) 이기 때문에
 * 정점의 개수가 많지만 간선이 적은경우 아주 비효율적이다.
 */
public class 선형탐색 {

    /**
     * 1번 노드에서 시작
     * number 노드까지의 최단거리를 구하라
     * @param graph  [0], [1] : 노드의 번호, [2] : 노드간의 길이
     * @param number 종료되는 노드번호
     * @return 최단거리
     */
    public int solution(int[][] graph, int number) {
        int[][] nodes = createNode(graph);          // 주어진 값을 이중배열형식으로 변환
        boolean[] flag = new boolean[nodes.length]; // 방문한 노드를 표시할 flag
        int[] len = new int[nodes.length];           // 각 노드간의 최소거리를 표시할 배열
        dijkstra(nodes, flag, len, 0);

        for (int[] node : nodes) {
            for (int i : node) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i : len) {
            System.out.print(i + " ");
        }
        return len[number-1];
    }

    /**
     * 다익스트라 알고리즘
     */
    private void dijkstra(int[][] nodes, boolean[] flag, int[] len, int start) {
        // 시작 노드로부터 작성된 거리를 len 배열에 먼저 담는다.
        for (int i = 0; i < len.length; i++) {
            // 방문할 수 없는 노드간의 길이는 0 이므로 이를 높은 수로 치환해 아래 알고리즘상에서 갱신시켜야하기 때문에
            // 0 -> 1000000 으로 변경시킴
            if (nodes[start][i] == 0) {
                nodes[start][i] = 1000000;
            }
            len[i] = nodes[start][i];
        }

        // 시작노드를 방문처리한다.
        flag[start] = true;

        for (int i = 0; i < len.length; i++) {
            // 방문하지않는 노드중 가장 거리가 짧은 인덱스를 가져온다.
            int current = getSmallIndex(len, flag);
            // 방문처리
            flag[current] = true;

            for (int j = 0; j < len.length; j++) {
                // 방문한 노드는 제외
                if (flag[j]) continue;

                // 0 인경우 최대값으로 반환하여 0을 갱신시킨다.
                // 0인상태로 갱신시킨다면 최단거리가 갱신되지 않기 때문임
                if (nodes[current][j] == 0) {
                    nodes[current][j] = 1000000;
                }

                // 최단거리를 비교해 낮은 값을 len에 갱신시킨다.
                if (len[current] + nodes[current][j] < len[j]) {
                    len[j] = len[current] + nodes[current][j];
                }
            }


        }

    }

    /**
     * 현재 방문하지않은 노드중 최단거리가 가장 짧은 인덱스를 반환
     */
    private int getSmallIndex(int[] len, boolean[] flag) {
        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < len.length; i++) {
            // 0은 자기 자신과의 노드간의 길이이기때문에 제외
            // 아직 방문하지않는 노드는 0이기때문에 제외

            // 이미 방문되어있는 노드는 제외
            if (flag[i]) continue;

            if (len[i] < min) {
                min = len[i];
                index = i;
            }
        }
        return index;
    }

    private int[][] createNode(int[][] graph) {
        int nodeCount = getNodeCount(graph);
        int[][] nodes = new int[nodeCount][nodeCount];

        for (int[] t : graph) {
            nodes[t[0] - 1][t[1] - 1] = nodes[t[1] - 1][t[0] - 1] = t[2];
        }
        return nodes;
    }
    private int getNodeCount(int[][] graph) {
        int max = 0;
        for (int[] ints : graph) {
            for (int anInt : ints) {
                if (max < anInt) max = anInt;
            }
        }
        return max;
    }
}
