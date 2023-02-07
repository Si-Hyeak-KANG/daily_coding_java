package programmers.level2;

import java.util.*;
public class 디펜스게임 {

    public static void main(String[] args) {

        디펜스게임_sol test = new 디펜스게임_sol();
        int result = test.solution(7, 3, new int[]{4,2,4,5,3,3,1});
        System.out.println(result);

        result = test.solution(2, 4, new int[]{3, 3, 3, 3});
        System.out.println(result);

        result = test.solution(3, 2, new int[]{1, 2, 10});
        System.out.println(result);

        result = test.solution(3, 2, new int[]{1,2, 3});
        System.out.println(result);
    }
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int totalRound = enemy.length;
        int remains = n;

        PriorityQueue<Integer> temp = new PriorityQueue<>((o1,o2) -> o2 - o1);

        for(int i = 0; i < totalRound; i++) {
            int currEnemy = enemy[i];
            remains -= currEnemy;
            temp.add(currEnemy);

            if(remains > 0) continue;

            if(k==0) return answer-1;
            remains += temp.poll();
            k--;
        }

        return totalRound;
    }
}
