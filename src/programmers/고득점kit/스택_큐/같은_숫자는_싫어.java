package programmers.고득점kit.스택_큐;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Collectors;

public class 같은_숫자는_싫어 {

    public static void main(String[] args) {
        같은_숫자는_싫어 test = new 같은_숫자는_싫어();
        int[] arr = {1,1,3,3,0,1,1};
        int[] result = test.solution(arr);
        System.out.println(Arrays.toString(result)); // 1,3,0,1

        arr = new int[]{4,4,4,3,3};
        result = test.solution(arr);
        System.out.println(Arrays.toString(result)); // 4,3
    }

    public int[] solution(int []arr) {
        ArrayList<Integer> answerList = new ArrayList<>();
        answerList.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]) {
                answerList.add(arr[i]);
            }
        }

        int[] ans = new int[answerList.size()];
        int index = 0;
        for (Integer val : answerList) {
            ans[index] = val;
            index++;
        }
        return ans;
    }
}
