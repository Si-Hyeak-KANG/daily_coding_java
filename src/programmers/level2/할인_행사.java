package programmers.level2;

import java.util.HashMap;

public class 할인_행사 {
    public static void main(String[] args) {
        할인_행사 test = new 할인_행사();
        String[] want = new String[]{"banana", "apple", "rice", "pork", "pot"};
        int[] number = new int[]{3,2,2,2,1};
        String[] discount = new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana" , "pork", "rice", "pot", "banana", "apple", "banana"};
        int res = test.solution(want, number, discount);
        System.out.println(res); // 3

        want = new String[]{"apple"};
        number = new int[]{10};
        discount = new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        res = test.solution(want, number, discount);
        System.out.println(res); // 0
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();
        return answer;
    }

}
