package letsdoIt.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1<=N(회원)<=30, 3<=M(치킨 종류의 수)<=30
// 최대 세 가지 종류의 치킨만 주문
// 시킨 치킨 세 마리 중 가장 선호도가 큰 값으로 적용
// O(NM^3)
public class BOJ_치킨치킨치킨_16439 {
    // 내부에 M 만큼한 배열을 가질, 크기가 N인 배열을 만든다.
    // 재귀를 통해서 세 개의 열을 선택 - 생각해보니 굳이..?
    // 목표 : 각 행마다 선택한 세 개의 열 내에서 최댓값을 각각 더한 값을 출력
    static int answer = Integer.MIN_VALUE;
    static int[][] members;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        members = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                members[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                for (int k = j + 1; k < M; k++) {
                    isMaxValue(N, 0, 0, new int[]{i,j,k});
                }
            }
        }

        System.out.println(answer);
    }

    private static void isMaxValue(int memberCount, int total, int row, int[] columns) {

        if (row == memberCount) {
            answer = Math.max(total,answer);
            return;
        }

        int[] curr = members[row];
        int max = Math.max(Math.max(curr[columns[0]], curr[columns[1]]), curr[columns[2]]);

        isMaxValue(memberCount,total + max, row+1, columns);
    }
}
