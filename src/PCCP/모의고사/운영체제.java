package PCCP.모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

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

    int count;
    HashMap<Integer, PriorityQueue<Integer>> programMap;

    public long[] solution(int[][] program) {
        long[] answer = new long[11];

        programMap = new HashMap<>();
        for (int i = 0; i < program.length; i++)
            programMap.put(program[i][1], new PriorityQueue<>());

        for(int i = 0; i < program.length; i++)
            programMap.get(program[i][1]).offer(program[i][0]);

        count = 0;

        while() {
            int min = Integer.MIN_VALUE;
            for (int i = count; i >= 0; i++) {
                min = Math.min(min,programMap.get(i).poll());
            }

            count++;
        }







        return answer;
    }
}
