package programmers.level2;

import java.util.PriorityQueue;

public class 디펜스게임_sol {
    public int solution(int n, int k, int[] enemy) {

        // 무적권으로 방어할 라운드의 적의 수 저장
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int round = 0; round < enemy.length; round++) {
            // 각 라운드의 적의 수를 queue에 저장
            queue.add(enemy[round]);

            // 무적권 수 보다 방어할 라운드가 많은 경우, 적의 수가 가장 적은 라운드 전투하여 병력 감소
            if(queue.size() > k) n -= queue.poll();

            // 병력이 0보다 적어지면 게임이 종료되며 해당 라운드 수를 반환
            if(n < 0) return round;
        }

        // 게임 클리어
        return enemy.length;
    }
}
