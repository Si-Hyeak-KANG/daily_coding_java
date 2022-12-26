package PCCP.모의고사;

import java.util.Arrays;
import java.util.Stack;

public class 유전법칙_해답 {

    public static void main(String[] args) {

        유전법칙_해답 test = new 유전법칙_해답();
        int[][] queries = new int[][]{{3, 5}};
        String[] result = test.solution(queries);
        System.out.println(Arrays.toString(result));

        queries = new int[][]{{3, 8}, {2, 2}};
        result = test.solution(queries);
        System.out.println(Arrays.toString(result));

        queries = new int[][]{{3, 1}, {2, 3}, {3, 9}};
        result = test.solution(queries);
        System.out.println(Arrays.toString(result));

        queries = new int[][]{{4, 26}};
        result = test.solution(queries);
        System.out.println(Arrays.toString(result));
    }

    static String[] arr = {"RR", "Rr", "Rr", "rr"};

    public String[] solution(int[][] queries) {

        int len = queries.length;

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
