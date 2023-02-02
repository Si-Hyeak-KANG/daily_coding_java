package programmers.고득점kit.greedy;

public class 큰수만들기 {

    public static void main(String[] args) {
        큰수만들기 test = new 큰수만들기();
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
        int lastIdx = len-1;
        int resultLen = len - k;

        // 목표 길이만큼 1개씩 수를 찾는다.
        // number에 남은 수와 목표 길이가 같아지면 종료
        // 남은 number는 모두 answer에 포함
        int start = 0;
        int end = 0;

        while(len-start != resultLen) {
            if(resultLen == 0) break;
            resultLen--;
            end = lastIdx - resultLen;
            String temp = number.substring(start, end+1);
            int max = 0;
            int maxIdx = 0;

            for(int i = 0; i < temp.length(); i++) {
                int num = temp.charAt(i);
                if(max >= num) continue;
                max = num;
                maxIdx = i;
            }
            answer += String.valueOf(max-'0');
            start = maxIdx+1;
        }

        return answer;
    }
}
