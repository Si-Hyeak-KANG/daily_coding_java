package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * idea
 * 1) PriorityQueue 에 비용들 저장 오름차순
 * 2) 현재 인덱스가 Queue.peek 과 동일하면, 현재 비용 * 총량
 * 3) 그렇지 않으면, 현재 비용 * 다음 인덱스까지의 거리 , 총량 - 다음 인덱스까지의 거리
 */
public class 주유소 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int totalDistance = 0;
        int[] distance = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
            totalDistance += distance[i];
        }

        int[] city = new int[N];
        int min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            city[i] = Integer.parseInt(st.nextToken());
            if(i==N-1) break;
            min = Math.min(min, city[i]);
        }

        int idx = 0, answer = 0;
        while(totalDistance > 0) {

            int curr = city[idx];
            if(curr == min) {
                answer += curr * totalDistance;
                break;
            } else {
                answer += curr * distance[idx];
                totalDistance -= distance[idx];
                idx++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
    }
}
