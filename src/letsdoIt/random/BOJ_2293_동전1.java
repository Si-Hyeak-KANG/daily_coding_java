package letsdoIt.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1 <= n <= 100, 1 <= k <= 10,000, v <= 100,000
// 경우의 수가 2^31보다 작다고 하니 int 로 가자
// 만약 이 문제를 또 접했을 경우, 아래와 같은 점화식을 다시 떠올리지 못할 것 같다.
// Q. n개의 코인으로 총 가치 10 만들 수 있는 경우의 수
public class BOJ_2293_동전1 {

    //  제한 용량이 4MB 이기 때문에 너무 큰 배열을 사용하지 말것
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1]; // 목표는 dp[k]일 때
        for (int i = 0; i < n; i++) {

            int coin = Integer.parseInt(br.readLine());

            for (int j = 1; j <= k; j++) {
                if(coin == j) dp[j] += 1;
                else if (coin > j) continue;
                dp[j] += dp[j-coin];
            }
        }

        System.out.println(dp[k]);
    }
}
