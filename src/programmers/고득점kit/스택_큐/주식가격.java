package programmers.고득점kit.스택_큐;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 주식가격 {
    public static void main(String[] args) {
        주식가격 test = new 주식가격();
        int[] result = test.solution(new int[]{1, 2, 3, 2, 3});
        System.out.println(Arrays.toString(result));
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {
            queue.add(prices[i]);
        }

        int currIdx = 0;
        while(queue.size()>1) {
            Integer currVal = queue.poll();

            for (Integer val : queue) {
                answer[currIdx]++;
                if(currVal > val) {
                    break;
                }
            }
            currIdx++;
        }

        return answer;
    }
}
