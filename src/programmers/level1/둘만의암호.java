package programmers.level1;

import java.util.HashSet;
import java.util.Set;

// String 에도 contains() 메서드가 있어서 굳이 Set 을 사용할 필요가 없었음.
// String.toCharArray() -> 문자로 쪼개서 배열로 저장하는 메서드 -> Foreach 사용했으면 깔
public class 둘만의암호 {

    public static void main(String[] args) {
        둘만의암호 test = new 둘만의암호();
        String result = test.solution("aukks", "wbqd", 5);
        System.out.println(result);
    }

    static Set<Integer> skipSet;

    public String solution(String s, String skip, int index) {
        String answer = "";
        insertSkipToSet(skip);

        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i);
            int cnt = 0;
            while(cnt < index) {
                curr+=1;
                if (curr > 122) curr = (curr / 122) + 96;
                if(isSkip(curr)) continue;
                cnt++;
            }
            sb.append((char)curr);
        }

        answer = String.valueOf(sb);
        return answer;
    }

    // skip에 해당하는 문자들의 아스키코드를 저장하는 Set
    void insertSkipToSet(String skip) {
        skipSet = new HashSet<>();

        for (int i = 0; i < skip.length(); i++) {
            int ch = skip.charAt(i);
            skipSet.add(ch);
        }
    }

    boolean isSkip(int c) {
        return skipSet.contains(c);
    }
}
