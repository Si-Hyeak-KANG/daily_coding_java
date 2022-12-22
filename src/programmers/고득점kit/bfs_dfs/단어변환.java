package programmers.고득점kit.bfs_dfs;

public class 단어변환 {
    public static void main(String[] args) {
        단어변환 test = new 단어변환();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int result = test.solution(begin, target, words);
        System.out.println(result); //4

        begin = "hit";
        target = "cog";
        words = new String[]{"hot", "dot", "dog", "lot", "log"};
        result = test.solution(begin, target, words);
        System.out.println(result);
    }

    int ans;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        ans = 0;
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return ans;
    }

    void dfs(String curr, String target, String[] words, int count) {

        if (curr.equals(target)) {
            ans = count;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            String next = words[i];
            if (visited[i]) continue;
            if (!isValid(curr, next)) continue;

            visited[i] = true;
            dfs(next, target, words, count+1);
            visited[i] = false;
        }
    }

    private boolean isValid(String curr, String next) {
        int count = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) != next.charAt(i)) count++;
        }
        if (count == 1) return true;
        else return false;
    }
}
