package PCCP.모의고사;

import java.util.Stack;

public class 유전법칙_해답 {

    static String[] arr = {"RR", "Rr", "Rr", "rr"};

    public String[] solution(int[][] queries) {
        // 부모가 RR 이면, 자신 RR
        // 부모가 rr 이면, 자신 rr
        // 부모가 Rr 이면, 자신 %4 의 값

        // 4로 계속 나누어 몫이 0일 때까지 나누면 0, 1, 2, 3의 나머지
        int len = queries.length;
        ;

        String ans[] = new String[len];
        for (int i = 0; i < len; i++) {
            int depth = queries[i][0];
            int num = queries[i][1] - 1;
            Stack<Integer> stk = new Stack<>();

            if (depth == 1) {
                ans[i] = "Rr";
            } else {
                while (depth-- > 1) {
                    stk.push(num % 4);
                    num /= 4;
                }
                boolean flag = false;

                while (!stk.isEmpty()) {
                    int pop = stk.pop();
                    if (pop == 0 || pop == 3) {
                        ans[i] = arr[pop];
                        flag = true;
                        break;
                    }
                }

                if(!flag) {
                    ans[i] = "Rr";
                }
            }
        }

        return ans;
    }
}
