package letsdoIt;

// TEST 1. 작업들이 요청시간별로 정렬이 되어있는가?
// 안되었다면, 요청시간별로 정렬
// time이 1초씩 증가하는 while 문 실행 -> 작업이 모두 끝나면 종료
// jobs 순회 -> 현재 탐색할 작업의 요청시간이 time이하면 (소요시간 오름차순 정렬)PriorityQueue에 넣음
// time 이상인 인덱스를 현재 탐색할 작업의 인덱스로 저장
// Priority Queue 에 값이 있다면, 순회하며 Poll
// time에서 소요시간을 더함. 해당 값을 sum에 더함
// 현재 탐색할 작업의 인덱스가 범위를 벗어나면 while 종료
// answer = sum / 작업의 수

/**
 * 분류 : 힙 활용 문제
 * 해당 문제는 CPU 스케줄링과 유사
 * 수행되고 있는 작업에 따라 뒤에 있을 작업의 수행 완료시간에 영향을 가함
 */
import java.util.*;
class 디스크컨트롤러 {

    public static void main(String[] args) {
        디스크컨트롤러 test = new 디스크컨트롤러();
        int result = test.solution(new int[][]{{1, 4}, {7, 9}, {1000, 3}});
        System.out.println(result);

    }

    // rq_time : 요청시간, tk_time : 소요시간
    public int solution(int[][] jobs) {

        int jobsCount = jobs.length;
        int time = 0;
        int total = 0;
        int idx = 0;
        int endCount = 0;

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 1. 소요시간이 같을 경우
        // 2. queue 에 담겨진 작업이 수행되는 도중에 새로운 소요시간이 작은 작업이 수행 가능할 경우
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
        });

        while(endCount < jobsCount) {

            for (int i = idx; i < jobsCount; i++) {
                int rq_time = jobs[i][0];

                if(rq_time <= time) {
                    idx = i+1;
                    pq.offer(jobs[i]);
                } else {
                    break;
                }
            }

            if(!pq.isEmpty()) {
                int[] curr = pq.poll();
                int rq_time = curr[0];
                int tk_time = curr[1];
                time += tk_time;
                total += time - rq_time;
                endCount++;
            } else {
                time++;
            }
        }

        return getAnswer(total, jobsCount);
    }

    private int getAnswer(int total, int count) {
        return total / count;
    }
}
