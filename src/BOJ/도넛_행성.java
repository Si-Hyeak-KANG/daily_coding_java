package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 도넛_행성 {

    // 7 8
    //0 0 1 1 0 0 0 0
    //0 1 1 1 1 0 1 0
    //1 1 1 1 1 1 1 1
    //0 1 1 1 1 1 0 0
    //1 1 0 0 0 1 0 0
    //0 1 0 0 0 1 0 1
    //0 0 1 1 1 1 0 0 -> 2

    // 5 6
    //1 1 1 1 1 1
    //1 0 0 0 1 1
    //1 1 1 1 0 0
    //1 1 1 1 0 0
    //1 1 1 1 1 1 -> 2
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}}; // R, L, U, D
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int endRow = N-1;
        int endCol = M-1;

        // 1. 그래프 세팅
        int[][] graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] isVisit = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        int answer = 0;
        // 2. bfs 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if(graph[i][j]==1) continue;
                if(isVisit[i][j]) continue;

                int[] curr = {i,j};
                q.add(curr);
                isVisit[i][j] = true;
                while(!q.isEmpty()) {
                    curr = q.poll();
                    for (int[] next : move) {
                        int row = next[0] + curr[0];
                        int col = next[1] + curr[1];
                        if (row < 0) row = endRow;
                        if (row > endRow) row = 0;
                        if (col < 0) col = endCol;
                        if (col > endCol) col = 0;
                        if (isVisit[row][col]) continue;
                        if (graph[row][col] == 0) {
                            q.add(new int[]{row,col});
                            isVisit[row][col] = true;
                        }
                    }
                }

                answer++;
            }
        }

        System.out.println(answer);
    }
}
