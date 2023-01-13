package programmers.고득점kit.그래프;

public class 순위 {
    public static void main(String[] args) {
        순위 test =  new 순위();
        int n = 5;
        int[][] results = {{4,3}, {4,2}, {3,2}, {1,2}, {2,5}};
        int result = test.solution(n, results);
        System.out.println(result); // 2
    }

    // n 명의 선수가 있을 때, 각 선수는 n-1번의 승패를 알 수 있어야 순위를 확정 지을 수 있다.
    // 플로이드 와샬 알고리즘
    int[][] graph;
    boolean[] isVisit;
    int answer;

    public int solution(int n, int[][] results) {

        graph = new int[n+1][n+1];
        setGraph(results);

        for(int i = 1; i <= n; i++) {
            isVisit = new boolean[n+1];
            dfs(n,i);

            for (int j = 1; j <= n; j++) {
                if(i==j) continue;
                if(isVisit[j] && graph[i][j] == 0) {
                    graph[i][j] = 1;
                    graph[j][i] = -1;
                }
            }
        }

        checkCount(n);
        return answer;
    }

    void setGraph(int[][] results) {
        for (int[] result : results) {
            int win = result[0];
            int lose = result[1];
            graph[win][lose] = 1;
            graph[lose][win] = -1;
        }
    }


    void dfs(int n, int curr) {

        isVisit[curr] = true;

        for (int next = 1; next <= n; next++) {
            if(curr==next) continue;
            if(1== graph[curr][next] && !isVisit[next]) {
                dfs(n,next);
            }
        }
    }

    void checkCount(int n) {

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if(i==j) continue;
                if(graph[i][j] != 0) count++;
            }

            if(count == n-1) answer++;
        }
    }
}
