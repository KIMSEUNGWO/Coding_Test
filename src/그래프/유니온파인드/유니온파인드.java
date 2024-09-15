package 그래프.유니온파인드;

/**
 * 자세한 내용
 * https://velog.io/@suk13574/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Java-%EC%9C%A0%EB%8B%88%EC%98%A8-%ED%8C%8C%EC%9D%B8%EB%93%9CUnion-Find-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 */
public class 유니온파인드 {

    /**
     * 그래프/트리의 대표적인 알고리즘임
     * 서로소인 부분집합의 표현
     * 여러 노드가 있을때 두 노드가 같은 그래프에 속해있는지 알 수 있음
     * union(x, y) : x와 y그래프를 합친다
     * find(x) : x가 어느 그래프에 속하는지 연산한다.
     * @param args
     */
    private static int[] parent;

    public static void main(String[] args) {

        int nodeCount = 5;
        parent = new int[nodeCount];
        // 부모노드를 가리키는 배열 초기화 (각 인덱스는 자기 자신의 부모가 본인이기때문에 초기화해주어야함)
        // result[0] 의 값은 0번 인덱스의 부모 인덱스번호를 가지고있다
        // result[0] = 1 이라면 0번 노드의 부모는 1번 노드이다.
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        System.out.println("parent = " + parent.length);

        int[][] graphs = {
            {0, 1},
            {2, 3},
            {2, 4},
            {1, 3}
        }; // graph[i[0] 과 graph[i][1] 이 서로 연결되어있다는 내용

        for (int[] graph : graphs) {
            parentPrint();
            union(graph[0], graph[1]);
        }
        parentPrint();

        // 자신의 부모노드를 알고싶다면 현재 parent 에 작성된 번호를 반환하면된다.
        System.out.println("부모노드");
        for (int i : parent) {
            System.out.print(i + " ");
        }
        // 만약 하나로 연결되어있는 그룹을 찾고싶다면 find(x)로 찾으면 된다
        System.out.println("최상위노드");
        for (int i : parent) {
            System.out.print(find(i) + " ");
        }
    }

    public static void parentPrint() {
        System.out.print("[ ");
        for (int i : parent) {
            System.out.print(i+ " ");
        }
        System.out.println("]");
    }

    private static boolean union(int x, int y) {

        x = find(x); // x의 부모노드 찾기
        y = find(y); // y의 무보노드 찾기

        // 이미 같은 그래프에 속해 있다면 더 이상 연산하지 않는다.
        if (x == y) return false;

        // 항상 번호가 작은쪽이 부모가 된다
        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
        // 그래프가 결정되었다면 true를 반환한다.
        return true;

    }

    private static int find(int x) {
        // x 인덱스에 담겨있는 번호가 자기 자신과 같은지 확인
        if (parent[x] == x) {
            return x; // 즉 최상위 그래프
        } else {
            // 상위 그래프가 아니라면 해당 인덱스로 재귀해서 상위 그래프가 나올때까지 반복한다.
            return find(parent[x]);
        }
    }
}
