package programmers.고득점kit.힙;
import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {
        더맵게 test = new 더맵게();
        System.out.println(test.solution(new int[]{1,2,3,9,10,12}, 10000)); // 2
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }

        int count = 0;
        int newValue = 0;

        while(pq.peek() < K) {
            if(pq.size() >= 2) {
                newValue = mixValue(pq.poll(), pq.poll());
            } else {
                return -1;
            }
            pq.offer(newValue);
            count++;
        }
        return count;
    }

    private int mixValue(int first, int second) {
        return first + (second*2);
    }
}
