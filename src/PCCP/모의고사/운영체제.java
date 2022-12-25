package PCCP.모의고사;

import java.util.*;

public class 운영체제 {

    public static void main(String[] args) {
        운영체제 test = new 운영체제();
        int[][] program = new int[][]{{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}};
        long[] result = test.solution(program);
        System.out.println(Arrays.toString(result));

        program = new int[][]{{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {5, 0, 5}};
        result = test.solution(program);
        System.out.println(Arrays.toString(result));
    }

    public long[] solution(int[][] program) {

        long[] answer = new long[11];
        int proLength = program.length;
        int idx = 0, count = 0;
        long time = 0, total = 0;

        Arrays.sort(program, (o1, o2) -> o1[1] - o2[1]);

        PriorityQueue<int[]> pq
                = new PriorityQueue<>((o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        });

        while (count < proLength) {

            // 시작가능한 프로그램을 pq에 저장
            for (int i = idx; i < proLength; i++) {

                int priority = program[i][0];
                int start = program[i][1];
                int execution = program[i][2];
                int[] curr = {priority, start, execution};

                if (start <= time) {
                    pq.add(curr);
                    idx++; // 재방문 방지
                } else {
                    break;
                }
            }

            if (!pq.isEmpty() && total <= time) {
                int[] curr = pq.poll();
                int priority = curr[0];
                int start = curr[1];
                int execution = curr[2];

                answer[priority] += time - start;
                total = time + execution;
                count++;
            }

            time++;
        }

        answer[0] = total;
        return answer;
    }
}

