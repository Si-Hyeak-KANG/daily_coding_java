package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class 평범한배낭 {

    public static void main(String[] args) throws IOException {

        setInOutStream();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalCnt = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        // [0] : 무게, [1] : 가치
        int[][] arr = new int[totalCnt+1][2];
        for(int i = 1; i <= totalCnt; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[totalCnt+1][limit+1];
        int td_result = knapsack_td(totalCnt, limit, arr);

        bw.write(String.valueOf(td_result));
        bw.flush();
        br.close();
    }

    static int[][] dp;
    // TOP DOWN
    static int knapsack_td(int idx, int limit, int[][] stuff) {

        if(idx < 1) return 0;

        int weight = stuff[idx][0];
        int value = stuff[idx][1];


        if(dp[idx][limit]==0) {
            // 현재 물건의 무게가 남은 무게보다 큰 경우
            if (weight > limit) dp[idx][limit] = knapsack_td(idx - 1, limit, stuff);
                // 현재 물건을 포함했을 때와 포함하지 않았을 때 큰 값 비교
            else dp[idx][limit] = Math.max(
                    knapsack_td(idx - 1, limit, stuff),
                    knapsack_td(idx - 1, limit - weight, stuff) + value);
        }
        return dp[idx][limit];
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static void setInOutStream() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
}
