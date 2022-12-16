package programmers.고득점kit.이분탐색;

import java.util.Arrays;

public class 입국심사_재풀이 {

    public static void main(String[] args) {

        입국심사 test = new 입국심사();
        long result = test.solution(6, new int[]{7, 10});
        System.out.println(result); // 28
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return binarySearch(times, n, times[times.length - 1]);
    }

    private long binarySearch(int[] times, int n, int max) {
        long left = 1, right = max * n;
        long mid = 0;
        long ans = Long.MAX_VALUE;

        while (left <= right) {
            mid = (left + right) / 2;

            if (isOverNum(times, mid, n)) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean isOverNum(int[] times, long mid, int n) {
        long num = 0;

        for (int i = 0; i < times.length; i++) {
            num += mid / times[i];
        }

        if (num >= n) return true;
        else return false;
    }
}
