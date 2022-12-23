package PCCP.모의고사;

public class 체육대회 {

    public static void main(String[] args) {
        체육대회 test = new 체육대회();

        int[][] ability = new int[][]{{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
        int result = test.solution(ability);
        System.out.println(result); // 210
    }

    int answer, studentNum, sportNum;
    int[][] chart;

    public int solution(int[][] ability) {
        answer = Integer.MIN_VALUE;
        studentNum = ability.length;
        sportNum = ability[0].length;

        chart = new int[sportNum][studentNum];

        for (int i = 0; i < sportNum; i++) {
            for (int j = 0; j < studentNum; j++) {
                chart[i][j] = ability[j][i];
            }
        }

        dfs(0,0, new boolean[studentNum]);

        return answer;
    }

    void dfs(int currSport, int total, boolean[] visit) {

        if (currSport >= sportNum) {
            answer = Math.max(answer, total);
            return;
        }

        for (int i = 0; i < studentNum; i++) {

            if(visit[i]) continue;
            total += chart[currSport][i];
            visit[i] = true;
            dfs(currSport + 1, total, visit);
            total -= chart[currSport][i];
            visit[i] = false;
        }
    }
}

