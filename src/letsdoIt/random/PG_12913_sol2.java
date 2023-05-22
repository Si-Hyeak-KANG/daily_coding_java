package letsdoIt.random;

import java.util.Arrays;

// 다른 풀이 참고
// dp 활용 동일 -> O(N)
// 이렇게 풀 수도 있구나... 배우자
public class PG_12913_sol2 {

    // 배열 자체를 dp로 활용 -> 약간 누적합 느낌
    int solution(int[][] land) {

        int n = land.length; // 행의 개수

        // 현재 행을 제외한 이전 행중 가장 큰 수를 이전 행에 저장하면서 누적
        for (int i = 1; i < n; i++) {
            land[i][0] += max(land[i-1][1], land[i-1][2], land[i-1][3]);
            land[i][1] += max(land[i-1][0], land[i-1][2], land[i-1][3]);
            land[i][2] += max(land[i-1][0], land[i-1][1], land[i-1][3]);
            land[i][3] += max(land[i-1][0], land[i-1][1], land[i-1][2]);
        }

        return Arrays.stream(land[n-1]).max().getAsInt();
    }

    int max(int v1, int v2, int v3) {

        return Math.max(Math.max(v1,v2), v3);
    }
}
