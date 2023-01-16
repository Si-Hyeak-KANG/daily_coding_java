package programmers.고득점kit.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 효율성 테스트 실패
 */
public class 게임_맵_최단거리 {
    public static void main(String[] args) {
        게임_맵_최단거리 test = new 게임_맵_최단거리();
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int result = test.solution(maps);
        System.out.println(result); // 11

        maps = new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };
        result = test.solution(maps);
        System.out.println(result); // -1
    }

    /**
     * 1. 1=길, 0=벽
     * 2. 캐릭터는 (상,하,좌,우) 이동 가능
     * 3. Queue 를 활용한 BFS 탐색
     */
    int[] moveRow = {-1, 1, 0, 0};
    int[] moveCol = {0, 0, -1, 1};

    boolean[][] isVisit;
    int answer, endRow, endCol;

    public int solution(int[][] maps) {

        int rowLen = maps.length;
        int colLen = maps[0].length;
        endRow = rowLen - 1;
        endCol = colLen - 1;
        isVisit = new boolean[rowLen][colLen];

        Queue<int[]> waiting = new LinkedList<>();
        int[] start = {0, 0};
        waiting.add(start);

        boolean find = bfs(waiting, maps);

        if (find) return answer;
        else return -1;
    }

    boolean bfs(Queue<int[]> nextQ, int[][] maps) {

        Queue<int[]> currQ = new LinkedList<>();

        while (!nextQ.isEmpty()) {

            answer++;
            while(!nextQ.isEmpty()) {
                int[] next = nextQ.poll();
                currQ.add(next);
            }

            while(!currQ.isEmpty()) {

                int[] curr = currQ.poll();
                int row = curr[0];
                int col = curr[1];
                isVisit[row][col] = true;
                if (row == endRow && col == endCol) return true;

                for (int i = 0; i < 4; i++) {
                    int nextRow = row + moveRow[i];
                    int nextCol = col + moveCol[i];
                    if (nextRow < 0 || nextRow > endRow) continue;
                    if (nextCol < 0 || nextCol > endCol) continue;
                    if (maps[nextRow][nextCol] == 0) continue;
                    if (isVisit[nextRow][nextCol]) continue;
                    int[] next = {nextRow, nextCol};
                    nextQ.add(next);
                }
            }
        }
        return false;
    }
}
