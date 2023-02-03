package BOJ;

import java.util.*;
import java.io.*;
public class 덩치 {

    // 틀림.
    public static void main(String[] args) throws IOException{

        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사람수 입력
        int N = Integer.parseInt(br.readLine());
        // 각각의 몸무게, 키 입력
        int[][] peoples = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            peoples[i][0] = Integer.parseInt(st.nextToken());
            peoples[i][1] = Integer.parseInt(st.nextToken());
        }
        // 점수 저장 우선순위 큐 타입 int[]{인덱스, 점수}, 점수로 정렬
        PriorityQueue<int[]> pointQueue = new PriorityQueue<>((o1,o2) -> o2[1]-o1[1]);
        // 사람 배열을 순회, 몸무게와 키 일일이 비교
        for(int i = 0; i < N; i++) {
            // 기본 점수 10점, 자신보다 큰 몸무게와 키를 마주칠때마다 각각에 -1 적용
            int totalPoint = N*2;
            int weight = peoples[i][0];
            int height = peoples[i][1];

            for(int j = 0; j < N; j++) {
                if(i==j) continue;
                int nextWeight = peoples[j][0];
                int nextHeight = peoples[j][1];
                if(weight < nextWeight) totalPoint--;
                if(height < nextHeight) totalPoint--;
            }
            // 점수 결과 배열에 저장
            int[] pointResult = {i,totalPoint};
            pointQueue.add(pointResult);
        }

        // 순회를 모두 마치고,
        // 각 인덱스에 등수를 저장할 배열 생성
        int[] result = new int[N];
        // PriorityQueue에서 값을 꺼낸다.
        // 나오는 순서로 등수를 매긴다.
        // 1등인 사람 먼저 출력
        int[] person = pointQueue.poll();
        int idx = person[0];
        int po = person[1];
        int grade = 1;
        result[idx] = grade;
        int n = 1; // 일정하게 증가하는 번째
        int temp = po;
        while(!pointQueue.isEmpty()) {
            person = pointQueue.poll();
            idx = person[0];
            po = person[1];
            // 앞서 나온 점수와 동일하다면, 등수 동일하게 적용
            if(temp!=po) grade+=n;
            else n++;
            result[idx] = grade;
            temp = po;
        }

        // 답을 저장할 StringBuilder 생성
        StringBuilder sb = new StringBuilder();
        for(int r : result) sb.append(r).append(" ");
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
    }
}
