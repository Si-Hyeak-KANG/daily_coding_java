package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 택배상자_sol {

    public int solution(int[] order) {
        int answer = 0;
        int cnt = 0;
        int n = order.length;
        Stack<Integer> sub = new Stack<>();
        Queue<Integer> main = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            sub.add(i);

            while (!sub.isEmpty()) {
                if (sub.peek() != order[cnt]) break;
                main.offer(sub.pop());
                cnt++;
            }
        }

        answer = main.size();
        return answer;
    }
}
