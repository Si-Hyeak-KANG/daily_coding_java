package letsdoIt.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 1) O(N)으로 해결
// 2) 내림차순 정렬
// 3) (i+1) * arr[i]
public class BOJ_로프_2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int w = pq.poll() * (i + 1);
            max = Math.max(w,max);
        }

        System.out.println(max);
    }
}
