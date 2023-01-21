package programmers.고득점kit.완전탐색;

public class 모음사전 {
    public static void main(String[] args) {
        모음사전 test = new 모음사전();
        String word = "AAAAE";
        int result = test.solution(word);
        System.out.println(result);

        word = "AAAE";
        result = test.solution(word);
        System.out.println(result);

        word = "I";
        result = test.solution(word);
        System.out.println(result);

        word = "EIO";
        result = test.solution(word);
        System.out.println(result);
    }

    String[] dic = {"A","E","I","O","U"};

    int answer;
    public int solution(String word) {
        dfs("",word);
        return answer;
    }

    boolean find;
    void dfs(String curr, String target) {
        if(curr.equals(target)) {
            find = true;
            return;
        };

        if(curr.length() == 5) return;

        for(int i = 0; i < 5; i++) {
            curr += dic[i];
            answer++;
            dfs(curr, target);
            if(find) return;
            curr = curr.substring(0, curr.length()-1);
        }
    }
}
