package programmers.level2;

import java.util.*;

public class 숫자_변환하기 {

    // 완전탐색은 시간초과
// 중복을 제거하고, 원하는 결과에 도달했을 때 종료.

    public int solution(int x, int y, int n) {
        int answer = 1;
        Set<Integer> currentSet = new HashSet<>();

        if (x == y) return 0;
        // 1. 기본 연산에 대한 결과 저장
        int val1 = firstOper(x, n);
        if (val1 < y) currentSet.add(val1);

        int val2 = secOper(x);
        if (val2 < y) currentSet.add(val2);

        int val3 = thirdOper(x);
        if (val3 < y) currentSet.add(val3);

        if (currentSet.isEmpty()) return -1;
        if (isRight(val1, val2, val3, y)) return answer;

        while (true) {

            Set<Integer> nextSet = new HashSet<>();
            answer++;
            for (int value : currentSet) {

                val1 = firstOper(value, n);
                if (!currentSet.contains(val1) && val1 < y) nextSet.add(val1);
                val2 = secOper(value);
                if (!currentSet.contains(val2) && val2 < y) nextSet.add(val2);
                val3 = thirdOper(value);
                if (!currentSet.contains(val3) && val3 < y) nextSet.add(val3);

                if (isRight(val1, val2, val3, y)) return answer;
            }

            if (nextSet.isEmpty()) return -1;
            currentSet = nextSet;
        }
    }

    int firstOper(int x, int n) {
        return x + n;
    }

    int secOper(int x) {
        return x * 2;
    }

    int thirdOper(int x) {
        return x * 3;
    }

    boolean isRight(int val1, int val2, int val3, int y) {
        return val1 == y || val2 == y || val3 == y;
    }
}
