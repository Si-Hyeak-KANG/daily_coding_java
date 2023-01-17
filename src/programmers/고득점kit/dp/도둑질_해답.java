package programmers.고득점kit.dp;

// dp[i] = 도둑이 i 번째 집에 왔을 때 훔진 돈의 값
// dp[i] = max(dp[i-2]+현재 m, dp[i-1]);
// 집이 원형이기 때문에 first idx 와 last idx 둘 중 하나만 선택
public class 도둑질_해답 {

    public int solution(int[] money) {
        int answer = 0;

        // 집이 3개만 있을 경우는 한 곳만 훔칠 수 있음.
        int len = money.length;
        if (len == 3) {
            for(int i = 0; i < 3; i++) answer = Math.max(answer, money[i]);
        }

        int[] dpForGetFirst = new int[len];
        int[] dpForIgnoreFirst = new int[len];

        // 1. 첫 집을 무조건 훔쳤을 때
        dpForGetFirst[0] = money[0];
        dpForGetFirst[1] = Math.max(money[0],money[1]);

        // 2. 첫 집을 훔치지 않고, 마지막 집을 훔쳤을 때
        dpForIgnoreFirst[0] = 0;
        dpForIgnoreFirst[1] = money[1];

        for (int i = 2; i < len; i++) {
            dpForIgnoreFirst[i] = Math.max(dpForIgnoreFirst[i-2] + money[i], dpForIgnoreFirst[i-1]);
            answer = Math.max(answer, dpForIgnoreFirst[i]);

            if(i == len-1) break; // 첫 집을 훔친 경우는 마지막 집을 훔치지 않기 때문에
            dpForGetFirst[i] = Math.max(dpForGetFirst[i-2] + money[i], dpForGetFirst[i-1]);
            answer = Math.max(answer, dpForGetFirst[i]);
        }

        return answer;
    }
}
