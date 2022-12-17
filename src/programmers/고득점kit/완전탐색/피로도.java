package programmers.고득점kit.완전탐색;

public class 피로도 {

    public static void main(String[] args) {
        피로도 test = new 피로도();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int result = test.solution(k, dungeons);
        System.out.println(result); // 3
    }

    int count = 0;
    boolean[] visit;

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return count;
    }

    void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if(!visit[i] && dungeons[i][0] <= k) {
                visit[i] = true;
                dfs(depth+1, k-dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
        count = Math.max(count, depth);
    }
}
