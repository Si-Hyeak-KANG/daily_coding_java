package PCCP.모의고사;

public class 체육대회_재풀이 {
    boolean[] isAttend;
    int answer, sum, studentNum, sportNum;

    public int solution(int[][] ability) {
        studentNum = ability.length;
        sportNum = ability[0].length;

        isAttend = new boolean[studentNum];

        dfs(0, ability);
        return answer;
    }

    void dfs(int curr, int[][] ability) {
        if (curr == sportNum) {
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0 ; i < studentNum; i++) {

            if(isAttend[i]) continue;

            int point = ability[i][curr];
            sum += point;
            isAttend[i] = true;
            dfs(curr+1, ability);
            sum -= point;
            isAttend[i] = false;
        }
    }
}
