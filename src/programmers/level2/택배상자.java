package programmers.level2;

import java.util.*;
public class 택배상자 {
    public static void main(String[] args) {
        택배상자_sol test = new 택배상자_sol();
        int result = test.solution(new int[]{4, 3, 1, 2, 5});
        System.out.println(result);

        result = test.solution(new int[]{5, 4, 3, 2, 1});
        System.out.println(result);
    }

    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        Queue<Integer> mc= new LinkedList<>();
        Stack<Integer> sc = new Stack<>();

        for(int i = 1; i <= n; i++) mc.offer(i);

        for(int i = 0; i < n; i++) {
            int target = order[i];
            boolean find = false;

            // main 컨테이너 체크
            while(!mc.isEmpty() && mc.peek() <= target) {
                int num = mc.poll();
                if(num != target) {
                    sc.push(num);
                }
                else {
                    answer++;
                    find = true;
                    break;
                }
            }

            // 보조 컨테이너 체크
            if(!find && !sc.isEmpty()) {
                int top = sc.pop();
                if(target != top) return answer;
                answer++;
            }
        }

        return answer;
    }
}
