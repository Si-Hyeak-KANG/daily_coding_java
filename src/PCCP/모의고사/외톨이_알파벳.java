package PCCP.모의고사;

public class 외톨이_알파벳 {

    public String solution(String input_string) {
        String answer = "";
        boolean[] result = new boolean[26];
        boolean[] isVisit = new boolean[26];

        isVisit[input_string.charAt(0)-97] = true;
        int count = 0;

        for (int i = 1; i < input_string.length(); i++) {

            char curr = input_string.charAt(i);
            char past = input_string.charAt(i-1);
            int currIndex = curr - 97;

            if(isVisit[currIndex]) {
                if(curr!=past) {
                    result[currIndex] = true;
                    count++;
                }
            }
            isVisit[currIndex] = true;
        }

        if(count==0) return "N";

        for(int i = 0; i < 26; i++) {
            if(result[i]) {
                answer += String.valueOf((char)(i+97));
            }
        }
        return answer;
    }
}
