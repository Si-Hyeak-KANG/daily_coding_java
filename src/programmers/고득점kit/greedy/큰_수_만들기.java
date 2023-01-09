package programmers.고득점kit.greedy;

public class 큰_수_만들기 {
    public static void main(String[] args) {
        큰_수_만들기 test = new 큰_수_만들기();
        String result = test.solution("1924", 2);
        System.out.println(result); // 94

        result = test.solution("1231234", 3);
        System.out.println(result); // 3234

        result = test.solution("4177252841", 4);
        System.out.println(result); // 775841
    }

    public String solution(String number, int k) {
        String answer = "";
        int len = number.length();
        int target = len - k;
        int next = 0;

        while (target > 0) {
            target--;
            int end = len - target;
            int max = 0;
            for (int j = next; j < end; j++) {
                int curr = number.charAt(j) - 48;
                if(max < curr) {
                    max = curr;
                    next = j+1;
                }
            }

            answer += String.valueOf(max);
        }
        return answer;
    }
}
