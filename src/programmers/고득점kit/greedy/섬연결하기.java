package programmers.고득점kit.greedy;

import java.util.ArrayList;
import java.util.List;

public class 섬연결하기 {
    public static void main(String[] args) {

        섬연결하기 test = new 섬연결하기();
        int result = test.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});
        System.out.println(result);
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<int[]> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new int[2]);
        }

        for(int i = 0; i <costs.length; i++) {
            int i1 = costs[i][0];
            int i2 = costs[i][1];
            int cost = costs[i][2];


        }

        return answer;
    }
}
