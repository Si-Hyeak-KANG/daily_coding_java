package letsdoIt.dp;

import java.io.*;
import java.util.StringTokenizer;

// S5
public class BOJ_다리놓기_1010 {

    static int[][] dp;

    /**
     * N * M 이중 배열 [크기 30]
     * 열 N , 행 M
     * N과 M 모두 사이트 수와 동일할 때 결과 반환
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCount = Integer.parseInt(br.readLine());
        dp = new int[30][30];

        for (int t = 0; t < testCount; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int result = dp[N][M];
            if (result == 0) {
                result = checkCase(N,M);
            }
            sb.append(result).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
    }

    /* N과 M이 같으면 1
     N이 M보다 크면 0 (Pass)
     N < M 지점은 (N-1, M-1) + (N, M-1)
    */
    static int checkCase(int N, int M) {

        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= M; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                    continue;
                }
                if (i == j) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
            }
        }
        
        return dp[N][M];
    }
}
