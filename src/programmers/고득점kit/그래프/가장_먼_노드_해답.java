package programmers.고득점kit.그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장_먼_노드_해답 {
    public static void main(String[] args) {
        가장_먼_노드_해답 test = new 가장_먼_노드_해답();
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}, {1, 7}};
        int result = test.solution(7, vertex);
        System.out.println(result); // 3
    }

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited;

    public int solution(int n, int[][] edge) {
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) graph.add(i, new ArrayList<>());

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        int answer = bfs();
        return answer;
    }

    public int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int cnt = 0;
        while (true) {
            Queue<Integer> temp = new LinkedList<>();

            while(!queue.isEmpty()) {
                int currNode = queue.poll();
                for (int nextNode: graph.get(currNode)) {
                    if(!visited[nextNode]) {
                        temp.add(nextNode);
                        visited[nextNode] = true;
                    }
                }
            }

            if(temp.isEmpty()) break;
            queue.addAll(temp);
            cnt = temp.size();
        }

        return cnt;
    }
}
