package letsdoIt.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간제한 2초, 메모리제한 128MB
// i-1을 기준으로 i를 누를지 말지 결정
// 첫번째 스위치를 누르냐 안누르냐 두 가지 케이스로 진행 -> 왜?
// ㄴ i-1 기준이 없기 때문에 시작부터 눌렀을 때와 안눌렀을 때로 시작
// 결과 -> 메모리 부족
// 시간복잡도 O(N^2)인 상황
// ㄴ 중간에 배열을 문자열로 변경하는 부분도 비효율적
// 비트 연산으로 메모리 성능 개선 필요
// 1비트로 표현하는 정수 int 형으로 사용하자 -> boolean 배열을 사용할 때보다 32배 메모리 절약
public class BOJ_2138_sol {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String now = br.readLine();
        String expect = br.readLine();

        int ans1 = 1, ans2 = 0, INF = 987654321;

        int[] firstTurnOn = new int[N];
        int[] firstTurnOff = new int[N];
        int[] expectArr = new int[N];

        for (int i = 0; i < N; i++) {
            firstTurnOn[i] = setIntArr(now.charAt(i));
            firstTurnOff[i] = setIntArr(now.charAt(i));
            expectArr[i] = setIntArr(expect.charAt(i));
        }

        firstTurnOn[0] = 1-firstTurnOn[0];
        firstTurnOn[1] = 1-firstTurnOn[1];

        for (int i = 1; i < N; i++) {

            if (firstTurnOn[i-1] != expectArr[i-1]) {
               firstTurnOn[i-1] = 1-firstTurnOn[i-1];
               firstTurnOn[i] = 1-firstTurnOn[i];
               ans1++;
               if (i != N-1) {
                   firstTurnOn[i+1] = 1-firstTurnOn[i+1];
               }
            }

            if (firstTurnOff[i-1] != expectArr[i-1]) {
                firstTurnOff[i-1] = 1-firstTurnOff[i-1];
                firstTurnOff[i] = 1-firstTurnOff[i];
                ans2++;
                if (i != N-1) {
                    firstTurnOff[i+1] = 1-firstTurnOff[i+1];
                }
            }
        }

        if (firstTurnOn[N-1] != expectArr[N-1]) ans1 = INF;
        if (firstTurnOff[N-1] != expectArr[N-1]) ans2 = INF;

        if (ans1 == INF && ans2 == INF) System.out.println(-1);
        else System.out.println(Math.min(ans1, ans2));
    }

    private static int setIntArr(char c) {
        return c - '0';
    }
}
