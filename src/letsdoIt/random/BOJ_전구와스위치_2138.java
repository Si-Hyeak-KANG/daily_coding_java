package letsdoIt.random;

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
public class BOJ_전구와스위치_2138 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String init = br.readLine();
        String goal = br.readLine();
        String[] firstLightOff = init.split("");
        String[] firstLightOn = turnLight(init.split(""), 0);
        int answer = 2;
        boolean find = false;
        for (int curr = 1; curr < N; curr++) {
            int past = curr - 1;
            search(firstLightOn, goal,curr,past);
            search(firstLightOff, goal,curr,past);

            String lightOn = toString(firstLightOn);
            String lightOff = toString(firstLightOff);

            if (goal.equals(lightOn) || goal.equals(lightOff)) {
                find = true;
                break;
            }
            answer++;
        }

        if (find) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

    }

    private static String toString(String[] lights) {
        StringBuilder sb = new StringBuilder();

        for (String light : lights) {
            sb.append(light);
        }

        return String.valueOf(sb);
    }

    private static void search(String[] lists, String goal, int curr, int past) {
        if (!isEqualsPastStateAndGoal(lists[past], goal.substring(past,curr))) {
            turnLight(lists, curr);
        }
    }

    private static boolean isEqualsPastStateAndGoal(String state, String goal) {
        return state.equals(goal);
    }

    private static String[] turnLight(String[] arr, int curIdx) {

        arr[curIdx] = change(arr[curIdx]);

        if (curIdx > 0 && curIdx < N-1) {
           arr[curIdx-1] = change(arr[curIdx-1]);
           arr[curIdx+1] = change(arr[curIdx+1]);
        } else if (curIdx == 0) {
            arr[curIdx+1] = change(arr[curIdx+1]);
        } else {
            arr[curIdx-1] = change(arr[curIdx-1]);
        }

        return arr;
    }

    private static String change(String state) {
        return state.equals("0") ? "1" : "0";
    }

}
