package 프로그래머스.L3.가장먼노드;

import java.util.Arrays;
import java.util.Comparator;

public class Logic {

    private int[] parent;
    private int[] count;
    public int solution(int n, int[][] vertex) {
        init(n);
        Arrays.sort(vertex, Comparator.comparingInt(o -> o[0]));
        for (int[] ints : vertex) {
            System.out.println(ints[0] + " : " + ints[1]);
        }
        for (int[] ints : vertex) {
            union(ints[0], ints[1]);
            for (int i=1;i<count.length;i++) {
                System.out.print(parent[i] + " ");
            }
            System.out.println();
        }

        int max = 0;
        for (int i : count) {
            if (max < i) max = i;
        }
        int result = 0;
        for (int i : count) {
            if (i == max) result++;
        }
        return result;
    }


    private void union(int x, int y) { // 2, 3
        int xx = find(x); // 2
        int yy = find(y); // 1

        if (xx == yy) return;

        if (xx < yy) { // 2 < 1
            parent[y] = x;
            count[y] = count[x] + 1;
        } else {
            parent[x] = y;
            count[x] = count[y] + 1;
        }
    }

    private int find(int x) {
        return (parent[x] == x) ? x : find(parent[x]);
    }

    private void init(int n) {
        parent = new int[n+1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        count = new int[n+1];
        Arrays.fill(count, 1);
    }


}
