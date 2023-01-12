package PCCP.모의고사;

import java.util.LinkedList;
import java.util.Queue;

public class 카페_확장 {
    public static void main(String[] args) {
        카페_확장 test = new 카페_확장();
        int[] menu = {5, 12, 30};
        int[] order = {1, 2, 0, 1};
        int k = 10;
        int result = test.solution(menu, order, k);
        System.out.println(result);

        menu = new int[]{5, 6, 7, 11};
        order = new int[]{1, 2, 3, 3, 2, 1, 1};
        k = 10;
        result = test.solution(menu, order, k);
        System.out.println(result);
    }

    // 1) 아무도 머무르지 않은 시간을 고려
    // 2) 커피를 받고 나갈 때 고객은 체크 x
    public int solution(int[] menu, int[] order, int k) {

        int num = order.length;
        int[] guest = new int[num];
        int visit = 0;
        for (int i = 0; i < num; i++) {
            guest[i] = visit;
            visit += k;
        }

        int answer = 0;
        int time = 0, count = 0, idx = 1;
        Queue<Integer> waiting = new LinkedList<>();
        waiting.add(0);

        while (count < num) {
            if (!waiting.isEmpty()) {
                int curr = waiting.peek();
                int od = order[curr];
                time += menu[od];
            } else {
                time = guest[idx] + menu[order[idx]];
            }

            for (int i = idx; i < num; i++) {
                if (guest[i] > time) break;
                waiting.add(i);
                idx = i + 1;
            }

            if (!waiting.isEmpty()) {

                int inCafe = waiting.size();
                waiting.poll();
                if (time == guest[idx - 1]) {
                    inCafe = waiting.size();
                }

                answer = Math.max(inCafe, answer);
                count++;
            }
        }
        return answer;
    }
}
