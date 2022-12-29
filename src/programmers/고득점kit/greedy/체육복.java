package programmers.고득점kit.greedy;

import java.util.Arrays;

public class 체육복 {
    public static void main(String[] args) {
        체육복 test = new 체육복();
        int n = 5;
        int[] lost = new int[]{2, 4};
        int[] reserve = new int[]{1, 3, 5};
        int result = test.solution(n, lost, reserve);
        System.out.println(result); // 5

        n = 5;
        lost = new int[]{2, 4};
        reserve = new int[]{3};
        result = test.solution(n, lost, reserve);
        System.out.println(result); // 4

        n = 3;
        lost = new int[]{3};
        reserve = new int[]{1};
        result = test.solution(n, lost, reserve);
        System.out.println(result); // 2
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[i] = -1;
                    break;
                }
            }
        }

        for (int lo : lost) {

            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] == lo - 1 || reserve[i] == lo + 1) {
                    reserve[i] = -1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
