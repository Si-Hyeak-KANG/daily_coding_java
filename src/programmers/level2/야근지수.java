package programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

import java.util.*;

public class 야근지수 {

    public long solution(int n, int[] works) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int w : works) {
            pq.offer(w);
        }

        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) return 0;
            int newNum = pq.poll() - 1;
            if (newNum == 0) continue;
            pq.offer(newNum);
        }

        long answer = 0;
        for (int val : pq) {
            answer += (long) Math.pow(val, 2);
        }

        return answer;
    }

}
