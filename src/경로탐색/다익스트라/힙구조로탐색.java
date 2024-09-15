package 경로탐색.다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 힙구조로탐색 {

    private final int MAX = 10000000;
    private List<List<Node>> nodeList = new ArrayList<>();

    /**
     * 힘 구조를 활용해서 O(NlogN) 을 만들 수 있다
     *
     * 1. 노드를 카운트한다.
     * 2. 최단거리를 저장할 int[] 를 최대값으로 모두 채워 생성한다.
     * 3. List<List<Node>> 를 생성한다. 이때 가장 위에있는
     * List<T>는 연결될 노드의 인덱스로 활용한다.
     * 그 안에 List<Node>는 인덱스에 해당하는 노드가 연결되어있는 노드번호와 경로값이 들어가있다.
     * 즉 {1, 3, 5} (1번노드와 3번노드의 거리는 5인 값) 이 들어오면
     * nodeList.get(1).add(new Node(3, 5)) 로 작성할 수 있다.
     * 무방향, 양방향인경우 nodeList.get(3).add(new Node(1, 5)) 를 추가하여 양쪽으로 연결한다.
     * 4.PriorityQueue<Node>를 생성하고 시작노드를 add한다 pq.add(new Node(1, 0))
     * @return
     */
    public int solution(int[][] graph, int number) {
        int count = getNodeCount(graph);
        int[] len = new int[count+1];
        Arrays.fill(len, MAX);

        // nodeList 초기화
        initPairList(count);
        inputPairList(graph);

        dijkstra(len);

        return len[number];
    }

    private void dijkstra(int[] len) {
        // 우선순위는 cost 오름차순
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(1, 0));
        len[1] = 0;

        // 비용이 낮은 순서대로 처리한다.
        while (!pq.isEmpty()) {
            Node pqNode = pq.poll();

            // 애초에 최단거리에 저장되어있는 거리보다 비용이 높은 Node 는 스킵한다.
            if (len[pqNode.index] < pqNode.cost) {
                continue;
            }

            // pq에서 꺼내온 node의 index를 활용해 List<List<Node>>에서 해당 노드와 연결되어있는 노드리스트를 불러온다
            List<Node> nodes = nodeList.get(pqNode.index);

            // pq에서 꺼낸 노드의 최단거리와 리스트내에 있던 노드의 거리를 더한것이 현재 저장되어있는 거리보다 짧다면 갱신한다.
            // 그리고 새롭게 갱신된 노드를 pq에 새로 넣어준다.
            for (Node adjNode : nodes) {
                if (len[pqNode.index] + adjNode.cost < len[adjNode.index]) {
                    len[adjNode.index] = len[pqNode.index] + adjNode.cost;
                    pq.add(new Node(adjNode.index, len[adjNode.index]));
                }
            }
        }
    }

    private void inputPairList(int[][] graph) {
        for (int[] ints : graph) {
            int node1 = ints[0];
            int node2 = ints[1];
            int cost = ints[2];
            nodeList.get(node1).add(new Node(node2, cost));
            // 무방향이거나, 양방향일경우 추가
            nodeList.get(node2).add(new Node(node1, cost));
        }
    }

    private void initPairList(int count) {
        for (int i = 0; i < count+1; i++) {
             nodeList.add(new ArrayList<>());
        }
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
