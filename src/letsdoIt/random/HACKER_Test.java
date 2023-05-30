package letsdoIt.random;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
6
5
2
1 6
1 3
2 5
1 5
3 4
1
5
 */

public class HACKER_Test {

    public static void main(String[] args) {
        HACKER_Test test = new HACKER_Test();
        int result = test.minimumTreePath(3, List.of(List.of(1, 2), List.of(1, 3)), List.of(2));
        System.out.println(result);
    }


    /*
     * 1 --- n
     * 인접노드
     * 재방문 가능
     * visitNodes 는 최소한 한번은 지나야함
     * DFS 탐색
     * boolean 배열을 통해 visit Nodes 방문 여부 체크
     */
    static int answer = Integer.MAX_VALUE;
    static Map<Integer, Boolean> essentialVisit;

    public static int minimumTreePath(int n, List<List<Integer>> edges, List<Integer> visitNodes) {

        // 2차원 테이블 생성 n x n
        boolean[][] graph = new boolean[n][n];
        for (int i = 0; i < n-1; i++) {
            List<Integer> list = edges.get(i);
            int n1 = list.get(0)-1;
            int n2 = list.get(1)-1;
            graph[n1][n2] = true;
            graph[n2][n1] = true;
        }

        // 필수 방문 배열 초기화
        essentialVisit = new HashMap<>();
        for (int i = 0; i < visitNodes.size(); i++) {
            essentialVisit.put(visitNodes.get(i)-1, false);
        }

        // 경로 탐색
        search(n-1, 0, graph, 0);

        return answer;
    }

    /*
     * DFS 탐색 메서드
     * return void;
     * func : int goal, int start, boolean[][] graph, int count
     * start가 goal에 도달했을 때 최소 count를 answer 에 저장
     */
    private static void search(int goal, int start, boolean[][] graph, int count) {

        if (start == goal) {
            if (essentialVisit.containsValue(false)) return;
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i <= goal; i++) {
            if (!graph[start][i]) continue;
            if (essentialVisit.containsKey(i)) essentialVisit.put(i, true);
            graph[start][i] = false;
            search(goal, i, graph, count+1);
            graph[start][i] = true;
            essentialVisit.put(i, false);
        }
    }
}
