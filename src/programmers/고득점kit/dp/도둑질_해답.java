package programmers.고득점kit.dp;

import java.util.Arrays;

import static java.lang.Math.max;

public class 도둑질_해답 {

    public int solution(int[] money) {
        int answer = 0;
        int houseNum = money.length;

        // 집이 3개만 있을 경우는 한 곳만 훔칠 수 있음.
        if (houseNum == 3) return Arrays.stream(money).max().getAsInt();

        int[] dpForGetFirst = new int[houseNum];
        int[] dpForIgnoreFirst = new int[houseNum];

        // 1. 첫 집을 무조건 훔쳤을 때
        dpForGetFirst[0] = money[0];
        dpForGetFirst[1] = max(money[0], money[1]);

        // 2. 첫 집을 훔치지 않았을 때
        dpForIgnoreFirst[0] = 0;
        dpForIgnoreFirst[1] = money[1];

        int i = 2;
        for (; i < houseNum; i++) {
            dpForIgnoreFirst[i] = max(dpForIgnoreFirst[i - 2] + money[i], dpForIgnoreFirst[i - 1]);

            // 첫 집을 훔친 경우는 마지막 집을 훔치지 않기 때문에 마지막 집에서 break;
            if (i == houseNum - 1) break;
            dpForGetFirst[i] = max(dpForGetFirst[i - 2] + money[i], dpForGetFirst[i - 1]);
        }

        return max(dpForIgnoreFirst[i], dpForGetFirst[i]);
    }
}
