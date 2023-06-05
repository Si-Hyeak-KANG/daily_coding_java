package letsdoIt.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1) 블로그 방문자 수 배열을 0번 인덱스부터 N-X 인덱스까지 탐색
2) 방문할 때마다 누적합 저장 배열 초기화
3) 현재 인덱스 기준. i+(X-1) 까지 누적합 진행
4) 누적합 저장 배열에서 가장 큰 값이 현재 가장 큰값보다 크면 저장 count 1 대입
5) 만약 동일하다면 count +1
 */
// 시간초과, 생각해보니까 결국 O(N^2)
public class BOJ_블로그_21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] hitArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) hitArr[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        int count = 0;
        for (int i = 0; i <= N-X; i++) {

            int sum = hitArr[i];
            for (int j = i+1; j < i+X; j++) {
                sum += hitArr[j];
            }

            if (answer < sum) {
                count = 1;
                answer = sum;
            } else if (answer == sum) {
                count += 1;
            }
        }

        if (answer == 0) System.out.println("SAD");
        else {
            System.out.println(answer);
            System.out.println(count);
        }
    }
}
