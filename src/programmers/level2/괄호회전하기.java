package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 괄호회전하기 {

    public static void main(String[] args) {
        괄호회전하기_재풀이 test = new 괄호회전하기_재풀이();
        int result = test.solution("[)(]");
        System.out.println(result);
    }

    final int[] data = new int[]{1, 2, 3}; // (, {, [

    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        String[] toArr = s.split("");

        Queue<String> queue = new LinkedList<>();
        for (String bracket : toArr) queue.offer(bracket);

        for (int i = 0; i < len; i++) {

            if (i != 0) queue.offer(queue.poll());

            boolean isContinue = false;
            Stack<Integer> temp = new Stack<>();

            for (String currBracket : queue) {

                if (temp.isEmpty() && isPopBracket(currBracket)) {
                    isContinue = true;
                    break;
                }

                if (isPopBracket(currBracket) && !isExistStartBracket(currBracket, temp)) {
                   isContinue = true;
                   break;
                }

                if (isPushBracket(currBracket)) {
                    dataPush(currBracket, temp);
                }
            }

            if (isContinue) continue;
            answer++;
        }

        return answer;
    }

    private boolean isPopBracket(String s) {
        return s.equals("}") || s.equals(")") || s.equals("]");
    }

    private boolean isPushBracket(String s) {
        return s.equals("{") || s.equals("(") || s.equals("[");
    }

    private boolean isExistStartBracket(String s, Stack<Integer> stack) {

        int data = 0;

        switch (s) {
            case ")":
                data = 1;
                break;
            case "}":
                data = 2;
                break;
            case "]":
                data = 3;
                break;
        }

        return stack.contains(data);
    }

    private void dataPush(String s, Stack<Integer> stack) {
        switch (s) {
            case "(":
                stack.push(data[0]);
                break;
            case "{":
                stack.push(data[1]);
                break;
            case "[":
                stack.push(data[2]);
                break;
        }
    }
}
