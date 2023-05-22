package letsdoIt.random;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 이 문제는 동적 계획법으로 최적화해야함.
 * 각 행에서 4개의 열 중 1개를 선택하므로, 전체 경우의 수는 4^N이 아니라 N4 가 됨.
 * 따라서 시간 복잡도 O(N)
 */
public class PG_12913_sol {

    int solution(int[][] land) {

        // 행의 개수
        int n = land.length;
        int[][] dp = new int[n][4];

        // land 에서 첫 번째 행의 값은 그대로 dp에 저장
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        // 두 번째 행부터는 이전 행에서 선택한 열과 겹치지 않는 열을 선택하여 최대값 구함
        for (int i = 1; i < n; i++) {
            // 현재 선택한 열
            for (int j = 0; j < 4; j++) {
                int max = 0;
                // 현재 선택한 행과 겹치지 않는 이전까지 행중 가장 큰 값 구하기
                for (int k = 0; k < 4; k++) {
                    if (j==k) continue;
                    max = Math.max(max, dp[i-1][k]);
                }
                // 현재 선택한 열의 값과 이전까지의 최대값 더하기
                dp[i][j] = max + land[i][j];
            }
        }

        return Arrays.stream(dp[n-1]).max().getAsInt();
    }

}
