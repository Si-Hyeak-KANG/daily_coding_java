package letsdoIt.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 깨알 지식 : int와 long 의 데이터 범위는 음수 ~ 양수
// 음수를 제외하는 방법이 있을까?
// Java8 부터 Integer, Long 에서 메소드 지원
// Integer.parseUnsignedInt("4294967295") -> -1
// Integer.toUnsignedString(-1) -> 4294967295
// DP로 풀이하자
// 일단 결과가 2^63-1 이하니까 타입을 Long으로 가자
// 이차원 테이블을 하고 최단경로로 해당 길을 통과하는 경우의 수를 저장하면서 찾자
// 만약 장애물이 위치한 곳이라면, 0으로 저장
public class BOJ_도로의개수_1577 {

    static long[][] map;
    static boolean[][] isNotLoad;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 가로 N, 세로 M -> row : M, column : N
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = toInt(st.nextToken());
        int M = toInt(st.nextToken());

        map = new long[M+1][N+1];
        isNotLoad = new boolean[M+1][N+1];
        int K = toInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = toInt(st.nextToken());
            int b = toInt(st.nextToken());
            int c = toInt(st.nextToken());
            int d = toInt(st.nextToken());
            isNotLoad[b][a] = true;
            isNotLoad[d][c] = true;
        }

        map[0][0] = 1;

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) {
                    map[i][j] = map[i][j-1];
                    check(i,j);
                }
                else if (j == 0) {
                    map[i][j] = map[i-1][j];
                    check(i,j);
                }
                else setCount(i,j);
            }
        }

        System.out.println(map[M][N]);
    }

    private static void setCount(int row, int column) {
        check(row-1,column);
        check(row,column-1);
        map[row][column] = map[row-1][column] + map[row][column-1];
    }

    private static void check(int row, int column) {
        if(isNotLoad[row][column]) map[row][column] = 0;
    }

    private static Integer toInt(String token) {
        return Integer.parseInt(token);
    }
}
