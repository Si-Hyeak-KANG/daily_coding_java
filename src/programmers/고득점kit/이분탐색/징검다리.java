package programmers.고득점kit.이분탐색;

import java.util.Arrays;

public class 징검다리 {
    public static void main(String[] args) {
        징검다리 test = new 징검다리();
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        System.out.println(test.solution(distance, rocks, n)); // 4
    }

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        return bs(distance, rocks, n);
    }

    private int bs(int distance, int[] rocks, int n) {
        int left = 1, right = distance, mid = 0;
        int ans = Integer.MIN_VALUE;

        while (left <= right) {
            mid = (left + right) / 2;

            if (isPass(rocks, mid, rocks.length-n)) {
                right = mid - 1;
            } else {
                ans = ans > mid? ans : mid;
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPass(int[] rocks, int mid, int n) {
        int start = 0;
        int count = 0;
        for (int i = 0; i < rocks.length; i++) {
            int dist = rocks[i] - start;
            if (dist >= mid) {
                start = rocks[i];
                count++;
            }
        }

        if (count < n) return true;
        else return false;
    }

}
