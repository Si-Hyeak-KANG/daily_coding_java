package PCCP.모의고사;

import java.util.LinkedList;
import java.util.Queue;

public class 보물지도_해답 {
    public static void main(String[] args) {

        보물지도_해답 test = new 보물지도_해답();

        int result = test.solution(5, 4
                , new int[][]{
                        {1, 4}, {2, 1}, {2, 2}, {2, 3},
                        {2, 4}, {3, 3}, {4, 1}, {4, 3},
                        {5, 3}
                });
        System.out.println(result);

        result = test.solution(4, 4
                , new int[][]{
                        {2, 3}, {3, 3}});
        System.out.println(result);
    }

    static int oneJumpX[] = {1, -1, 0, 0};
    static int oneJumpY[] = {0, 0, -1, 1};
    static int twoJumpX[] = {2, -2, 0, 0};
    static int twoJumpY[] = {0, 0, -2, 2};

    public int solution(int n, int m, int[][] hole) {

        int startX = m;
        int startY = 1;

        int endX = 1;
        int endY = n;
        int k = 1;
        boolean visited[][][] = new boolean[m+1][n+1][k+1];
        boolean MAP[][] = new boolean[m+1][n+1];
        int holeLen = hole.length;
        for (int i = 0; i < holeLen; i++) {
            int x = startX - hole[i][1] + 1;
            int y = hole[i][0];
            MAP[x][y] = true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 0, k));

        visited[startX][startY][k] = true;
        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {

        }
        return min;
    }

    static class Node {

        int x;
        int y;
        int time;
        int cnt;

        public Node(int x, int y, int time, int cnt) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.cnt = cnt;
        }
    }
}
