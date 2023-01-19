package programmers.고득점kit.dp;

import java.util.*;

public class N으로_표현 {
    public static void main(String[] args) {

        N으로_표현 test = new N으로_표현();
        System.out.println(test.solution(5, 12)); // 4
        System.out.println(test.solution(2, 11)); // 3
    }

    public int solution(int N, int number) {
        Set<Integer>[] dp = new Set[9];
        int n = N;
        for (int i = 1; i < 9; i++) {
            dp[i] = new HashSet<>();
            dp[i].add(n);
            n = n * 10 + N;
        }

        for (int i = 1; i < 9; i++) {

            for (int j = 1; j < i; j++) {

                for (Integer a : dp[j]) {
                    for(Integer b : dp[i-j]) {
                        dp[i].add(a+b);
                        dp[i].add(a-b);
                        dp[i].add(a*b);
                        if(a!=0) dp[i].add(b/a);
                    }
                }
            }

            if (dp[i].contains(number)) return i;
        }
        return -1;
    }
}
