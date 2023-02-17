package programmers.level2;

import java.util.PriorityQueue;

public class 혼자놀기의달인 {

    public static void main(String[] args) {

        혼자놀기의달인 test = new 혼자놀기의달인();
        int result = test.solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4});
        System.out.println(result);
    }

    public int solution(int[] cards) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for(int i = 0; i < cards.length; i++) {

            int curr = cards[i];
            if(curr == 0) continue;

            cards[i] = 0;
            int cnt = 1;
            while(true) {
                int nextIdx = curr-1;
                curr = cards[nextIdx];
                if(curr == 0) break;
                cards[nextIdx] = 0;
                cnt++;
            }
            pq.offer(cnt);
        }

        if(pq.size() == 1) return -1;

        answer = pq.poll() * pq.poll();
        return answer;
    }
}
