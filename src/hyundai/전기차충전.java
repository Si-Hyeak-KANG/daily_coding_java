package hyundai;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 전기차충전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] cars = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cars[i][0] = Integer.parseInt(st.nextToken());
            cars[i][1] = Integer.parseInt(st.nextToken());
            cars[i][2] = Integer.parseInt(st.nextToken());
        }

        int time = 0, idx = 0, completeCnt = 0, count = 0;
        Queue<Integer> queue = new LinkedList<>();
        while(count < N) {
            for(int i = idx; i < N; i++) {

                int[] curr = cars[i];
                int visit = curr[0];
                int chargingTime = curr[1];
                int waitingTime = curr[2];

                if(queue.isEmpty()) {
                    time += chargingTime + visit;
                    idx++;
                    continue;
                }

                if(visit <= time) {
                    if(time - visit > waitingTime) continue;
                    
                }

            }

        }

    }
}
