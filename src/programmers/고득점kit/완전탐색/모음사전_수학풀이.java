package programmers.고득점kit.완전탐색;

public class 모음사전_수학풀이 {

    public static void main(String[] args) {
        모음사전_수학풀이 test = new 모음사전_수학풀이();
        int result = test.solution("AAAAA");
        System.out.println(result);

    }

    public int solution(String word) {
        int answer = 0, per = 3905;
        for (String s : word.split("")) {
            answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        }
        return answer;
    }
}
