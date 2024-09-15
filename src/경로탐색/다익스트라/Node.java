package 경로탐색.다익스트라;

public class Node {

    public int index;
    public int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", index, cost);
    }
}
