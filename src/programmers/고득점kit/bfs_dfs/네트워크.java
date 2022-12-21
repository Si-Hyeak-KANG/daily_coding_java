package programmers.고득점kit.bfs_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    public static void main(String[] args) {

        네트워크 test = new 네트워크();
        int n = 3;
        int[][] computers = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int result = test.solution(n, computers);
        System.out.println(result); // 2

        n = 3;
        computers = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        result = test.solution(n, computers);
        System.out.println(result); // 1
    }

    ArrayList<ArrayList<Integer>> network;
    int count;

    public int solution(int n, int[][] computers) {

        network = new ArrayList<>();
        for (int i = 0; i < n; i++) network.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && computers[i][j] == 1) continue;
                if (computers[i][j] == 1) network.get(i).add(j);
            }
        }
        bfs(n);
        return count;
    }

    int bfs(int n) {
        Queue<Integer> temp = new LinkedList<>();
        boolean[] visited = new boolean[n];
        count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            temp.add(i);
            visited[i] = true;
            while(!temp.isEmpty()) {
                Integer curr = temp.poll();
                ArrayList<Integer> nextList = network.get(curr);
                for (Integer next : nextList) {
                    if (!visited[next]) {
                        temp.add(next);
                        visited[next] = true;
                    }
                }
            }

            count++;
        }

        return count;
    }
}
