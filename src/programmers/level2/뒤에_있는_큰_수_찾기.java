package programmers.level2;

import java.util.*;

public class 뒤에_있는_큰_수_찾기 {
    public static void main(String[] args) {
        뒤에_있는_큰_수_찾기 test = new 뒤에_있는_큰_수_찾기();
        int[] result = test.solution(new int[]{9, 1, 5, 3});
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Arrays.fill(answer,-1);

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < len; i++) {

            while (!st.isEmpty()) {
                int idx = st.pop();
                if (numbers[idx] >= numbers[i]) {
                    st.push(idx);
                    break;
                } else {
                    answer[idx] = numbers[i];
                }
            }

            st.push(i);
        }

        return answer;
    }
}
