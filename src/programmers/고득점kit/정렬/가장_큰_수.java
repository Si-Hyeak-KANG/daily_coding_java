package programmers.고득점kit.정렬;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 가장_큰_수 {
    public static void main(String[] args) {
        가장_큰_수 test = new 가장_큰_수();
        int[] numbers = {6,10,2};
        String result = test.solution(numbers);
        System.out.println(result); // 6210

        numbers = new int[]{3,30,34,5,9};
        result = test.solution(numbers);
        System.out.println(result); //9534330
    }

    public String solution(int[] numbers) {
        String answer = "";
        String[] temp = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }

        // 정렬
        Arrays.sort(temp,(st1,st2) -> (st2 + st1).compareTo(st1 + st2));

        // 0만 여러개 있는 배열의 경우 하나의 0만 리턴
        if (temp[0].equals("0")) {
            return "0";
        }

        String ans = "";
        for (String s : temp) {
            ans += s;
        }
        return ans;
    }
}
