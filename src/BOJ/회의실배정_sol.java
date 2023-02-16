package BOJ;

// 생각보다 간단한 문제였음..
// 문제를 잘읽자..
// 문제 회의실 한개있음, 최대 회의의 수 -> 활동 선택 문제
// 내가 이해한건. 회의를 모두 진행하기 위한 회의실 최대 수 -> count 누적합

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1) 끝나는 시간 오름차순으로 정렬
// 2) 끝나는 시간이 같으면 시작 시간 오름차순 정렬
// 3) 첫번째 인덱스부터 다음 인덱스의 시작 시간이 크거나 같으면 count,
// 4) 끝까지 반복
public class 회의실배정_sol {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
        }));

        for(int i = 0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] time = new int[2];
            time[0] = Integer.parseInt(st.nextToken());
            time[1] = Integer.parseInt(st.nextToken());
            pq.offer(time);
        }

        int cnt = 0, pastEnd = 0;
        for (int[] time : pq) {
            int start = time[0];
            int end = time[1];
            if(pastEnd > start) continue;
            pastEnd = end;
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
    }
}
