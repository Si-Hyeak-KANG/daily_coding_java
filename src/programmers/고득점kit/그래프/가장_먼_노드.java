package programmers.고득점kit.그래프;

import java.util.ArrayList;
import java.util.HashMap;

public class 가장_먼_노드 {

    public static void main(String[] args) {
        가장_먼_노드 test = new 가장_먼_노드();
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int result = test.solution(6, vertex);
        System.out.println(result); // 3
    }

    public int solution(int n, int[][] edge) {

        HashMap<Integer, ArrayList<Integer>> graph = setNewGraph(n);
        graph = setGraphInfo(edge, graph);

        HashMap<Integer, Integer> depthOfNode = new HashMap<>();
        ArrayList<Integer> visitedList = new ArrayList<>();
        int index = 0, depth = 0;
        depthOfNode.put(1, depth);
        visitedList.add(1);

        while (visitedList.size() < n) {
            int currNode = visitedList.get(index);
            depth = depthOfNode.get(currNode) + 1;
            ArrayList<Integer> nextList = graph.get(currNode);

            if(!nextList.isEmpty()) {
                for (int i = 0; i < nextList.size(); i++) {
                    Integer nextNode = nextList.get(i);

                    if (!depthOfNode.containsKey(nextNode)) {
                        visitedList.add(nextNode);
                        depthOfNode.put(nextNode, depth);
                    }
                }
            }
            index++;
        }
        Integer maxDepth = depthOfNode.get(visitedList.size() - 1);
        int count = 0;
        for (Integer value : depthOfNode.values()) {
            if(value==maxDepth) {
                count++;
            }
        }
        return count;
    }

    private HashMap<Integer, ArrayList<Integer>> setGraphInfo(int[][] edge,
                                                              HashMap<Integer, ArrayList<Integer>> graph) {
        for (int i = 0; i < edge.length; i++) {
            int node = edge[i][0];
            int val = edge[i][1];
            graph.get(node).add(val);
            graph.get(val).add(node);
        }
        return graph;
    }

    private HashMap<Integer, ArrayList<Integer>> setNewGraph(int n) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        return graph;
    }
}
