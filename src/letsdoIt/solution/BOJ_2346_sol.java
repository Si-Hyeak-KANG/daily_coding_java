package letsdoIt.solution;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


// S3
// 1번부터 시작
// 터진 풍선은 다시 x
// ArrayDeque 활용해보자
public class BOJ_2346_sol {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<int[]> balloons = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            balloons.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb= new StringBuilder();
        while (balloons.size() > 1) {
            int[] curr = balloons.pollFirst();
            int index = curr[0];
            int value = curr[1];
            sb.append(index).append(" ");

            if (value > 0) {
                for (int i = 1; i < value; i++) {
                    int[] next = balloons.pollFirst();
                    balloons.offerLast(next);
                }
            }
            else {
                for (int i = value; i < 0; i++) {
                    int[] next =balloons.pollLast();
                    balloons.offerFirst(next);
                }
            }
        }

        sb.append(balloons.poll()[0]);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
    }
}
