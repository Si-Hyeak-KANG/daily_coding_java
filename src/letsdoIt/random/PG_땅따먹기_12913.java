package letsdoIt.random;

import java.util.HashSet;
import java.util.Set;

// Level 2
// 행의 개수 N : 100,000 이하 자연수
// 열의 개수 : 4
// 점수 : 100 이하
// 아래 코드는 시간 복잡도 (4^N), 최대 5분 이상 및 큰 메모리 소요 발생
public class PG_땅따먹기_12913 {
    public static void main(String[] args) {
        PG_땅따먹기_12913 test = new PG_땅따먹기_12913();
        int result = test.solution(new int[][]{
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        });
        System.out.println(result);

        PG_12913_sol test2 = new PG_12913_sol();
        int result2 = test2.solution(new int[][]{
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        });
        System.out.println(result2);

        PG_12913_sol2 test3 = new PG_12913_sol2();
        int result3 = test3.solution(new int[][]{
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        });
        System.out.println(result3);
    }
    int answer = Integer.MIN_VALUE;
    int solution(int[][] land) {
        search(land, 0, -1, 0);
        return answer;
    }

    void search(int[][] land, int currRow, int pastColumn, int total) {

        if(currRow == land.length) {
            answer = Math.max(answer, total);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(i == pastColumn) continue;
            search(land, currRow+1, i, total+land[currRow][i]);
        }
    }
}
