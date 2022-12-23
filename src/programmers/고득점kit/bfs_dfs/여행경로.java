package programmers.고득점kit.bfs_dfs;

import java.util.*;

public class 여행경로 {
    public static void main(String[] args) {
        여행경로 test = new 여행경로();
        String[][] tickets = new String[][]{{"ICN","JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] result = test.solution(tickets);
        System.out.println(Arrays.toString(result));

        tickets = new String[][]{{"ICN","SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},{"ATL","ICN"},{"ATL","SFO"}};
        result = test.solution(tickets);
        System.out.println(Arrays.toString(result));

        tickets = new String[][]{{"ICN","AAA"}, {"ICN", "CCC"}, {"CCC", "DDD"},{"AAA","BBB"},{"DDD","ICN"},{"BBB","AAA"}};
        result = test.solution(tickets);
        System.out.println(Arrays.toString(result));
    }

    Map<String,Boolean> cities = new HashMap();
    Map<String,PriorityQueue<String>> graph = new HashMap<>();
    ArrayList<String> result;
    public String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            cities.put(tickets[i][0],false);
            cities.put(tickets[i][1],false);
        }

        for (String city : cities.keySet()) {
            graph.put(city,new PriorityQueue<>());
        }

        for (int i = 0; i < tickets.length; i++) {
            graph.get(tickets[i][0]).offer(tickets[i][1]);
        }

        result = new ArrayList<>();
        String[] answer = new String[result.size()];
        return result.toArray(answer);
    }


}
