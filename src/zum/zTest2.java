package zum;

import java.util.*;
public class zTest2 {

    public static void main(String[] args) {
        zTest2 test = new zTest2();
        int[][] data = {{1,2,10},
                {2,5,8},
                {3,6,9},
                {4,20,6},
                {5,25,5}};
        int[] result = test.solution(data);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[][] data) {
        int len = data.length;
        int[] answer = new int[len];

        int idx = 0, ansIdx = 0, endCnt = 0, time = 0;
        PriorityQueue<int[]> waiting = setWaitingQueue();

        while(endCnt < len) {

            // 인쇄 가능한 문서를 pq에 저장
            for(int i = idx; i < len; i++) {
                int[] curr = data[idx];
                int docuNum = curr[0];
                int start = curr[1];
                int pageAmount = curr[2];

                // 인쇄, 대기중인 문서가 없으면 바로 출력
                if(waiting.isEmpty()) {
                    endCnt++;
                    time += pageAmount;
                    idx++; // 재방문 방지
                    answer[ansIdx] = docuNum;
                    ansIdx++;
                    continue;
                }

                // 문서의 요청시간보다 현재 시간보다 작으면 break;
                if(start > time) break;
                // 그렇지 않으면 대기열 추가
                waiting.add(curr);
                idx++;
            }

            if(!waiting.isEmpty()) {
                int[] curr = waiting.poll();
                int docuNum = curr[0];
                int pageAmount = curr[2];

                answer[ansIdx] = docuNum;
                ansIdx++;
                endCnt++;
            }

            time++;
        }

        return answer;
    }

    // 대기열 Queue 정렬 전략 설정 (페이지 수 오름차순, (페이지 수 동일시) 요청 시각 오름차순)
    private PriorityQueue<int[]> setWaitingQueue() {
        return new PriorityQueue<>((o1,o2) -> {
            return o1[2] == o2[2] ? o2[1] - o1[1] : o2[2] -o1[2];
        });
    }

}
