package letsdoIt.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1) 배열의 길이 N 만큼 반복
2) 첫번째 포인트와 두번째 포인트를 0번 인덱스를 가리킨다.
3) 현재 부분합이 S보다 작으면 두번째 포인트 1증가하고 누적 저장
4) 현재 부분합이 S 이상이면
5) 현재 최소 길이와 비교하여 더 작을 경우 길이 저장 아니면 패스
6)
 */
public class BOJ_부분합_1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int start = 0, minLength = N+1, sum = 0, length = 0;
        for (int end = 0; end < N; end++) {
            length += 1;
            sum += arr[end];

            while(sum >= S) {
                minLength = Math.min(length, minLength);
                sum -= arr[start];
                start++;
                length--;
            }
        }

        if (minLength == N+1) System.out.println(0);
        else System.out.println(minLength);
    }
}
