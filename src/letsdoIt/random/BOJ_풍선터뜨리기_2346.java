package letsdoIt.random;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


// S3 (결과) -> 메모리초과
// 1번부터 시작
// 터진 풍선은 다시 x
public class BOJ_풍선터뜨리기_2346 {

    static int[] balloons;
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        // 풍선의 개수 N 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // N 만큼 순회하며 종이에 적힌 값 입력 -> 크기 N+1 배열에 저장 (0번은 dummy)
        balloons = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            balloons[i] = Integer.parseInt(st.nextToken());
        }

        // 1번부터 탐색 시작 -> 인자에 1번, 1번의 값이 양수인지
        result = new ArrayList<>();
        search(N, 1, isRight(balloons[1]));

        StringBuilder sb = new StringBuilder();
        for (Integer v : result) {
            sb.append(v).append(" ");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
    }

    private static void search(int n, int curr, boolean right) {

        if (result.size() == n) return;
        // 회전되는 방식이므로 나머지를 활용
        curr = convert(curr, n);
        int value = balloons[curr];
        // 배열[curr]가 이미 0이냐, 맞다면 그럼 옆으로 이동
        if (isAlready(value)) {
            // ㄴ right 면 curr+1
            if (right) search(n, curr+1, right);
            else search(n, curr-1, right);
            // ㄴ left 면 curr-1
        } else {
            // 밟은 위치는 0으로 변경
            balloons[curr] = 0;
            // result 배열에 저장
            result.add(curr);
            // 0이 아니면, search 함수 인자에 curr + value
            search(n, curr+value, isRight(value));
        }

    }

    private static boolean isRight(int v) {
        return v > 0;
    }

    private static boolean isAlready(int v) {
        return v==0;
    }

    private static int convert(int curr, int n) {
        if(curr == 0) return n;
        else return Math.abs(curr % n);
    }
}
