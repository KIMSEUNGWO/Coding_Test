package 경로탐색.다익스트라;

public abstract class 메인 {

    private static 선형탐색 선형탐색 = new 선형탐색();
    private static 힙구조로탐색 힙구조로탐색 = new 힙구조로탐색();

    /**
     * 시작노드는 1번
     * graph 는 노드간의 연결상태와 그 사이의 길이를 나타냄
     * 최단거리를 return해야함
     *
     * 주의사항!!
     * 음수 가중치가 있다면 다익스트라를 사용할 수 없다.
     */
    public static void main(String[] args) {
        int[][] graph = {
            {1, 2, 2},
            {1, 4, 1},
            {1, 3, 5},
            {2, 4, 2},
            {2, 3, 3},
            {4, 3, 3},
            {4, 5, 1},
            {3, 5, 1},
            {3, 6, 5},
            {5, 6, 2},
        }; // [0], [1] : 노드의 번호, [2] : 노드간의 길이
        int number = 6;
        int result = 힙구조로탐색.solution(graph, number);
        System.out.println("result = " + result);
    }
}
