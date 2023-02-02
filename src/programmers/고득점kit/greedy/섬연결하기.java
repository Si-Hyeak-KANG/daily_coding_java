package programmers.고득점kit.greedy;

import java.util.*;

// Minimum Spanning Tree(최소 신장 트리) : 가중치 무방향 그래프에서 모든 정점을 최소 비용으로 연결할 수 있는 방법
// MST 를 찾는 알고리즘 중 유명한 두 방법 : 크루스칼(Kruskal) 알고리즘, Prim Algorithm
// 크루스칼 알고리즘 : 간선을 기준으로 트리 형성 - 가중치가 작은 간선부터 선택하겠다.
// 프림 알고리즘 : 점점을 기준으로 트리 형성
public class 섬연결하기 {
    public static void main(String[] args) {

        섬연결하기 test = new 섬연결하기();
        int result = test.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});
        System.out.println(result);
    }
    static int[] parent;

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2[2]);

        parent = new int[n];

        for(int i = 0; i < n; i++) parent[i] = i;

        int total = 0;
        for(int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            int fromParent = findParent(from);
            int toParent = findParent(to);

            if(fromParent == toParent) continue;

            total += cost;
            parent[toParent] = fromParent;
        }
        return total;
    }

    private int findParent(int node) {
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }
}
