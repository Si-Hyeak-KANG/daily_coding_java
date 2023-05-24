package letsdoIt.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1<= n <= 2^31-1, 1<=k<=2^63-1
// long 으로 가자
// 자르는 방법 두 가지 : 가로로 자르는 방법, 세로로 자르는 방법
// 종이 수 : (가로+1) * (세로*1)
// ex : 4 -> 0,4. 1,3. 2,2. 3,1 4.0(가로와 세로의 순서가 바뀌어도 결과는 동일)
// 가로로 자르는 횟수는 0,1,2 => 0부터 n/2
// n이 2^31-1이라면, 0 ~ (2^32-1)/2
// 오 궁금한 점 생김
// 1. O(N)일경우 -> 틀리진 않음
// ㄴ 가로횟수를 21억(2^32-1) 전부 탐색할 경우엔 시간초과
// ㄴ 가로횟수를 약 10억만큼만 탐색할 경우 1144ms
// 2. O(logN)일경우
public class BOJ_색종이와가위_20444_N {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        for (long i = 0; i <= n / 2; i++) {
            long width = i;
            long height = n - i;
            if (k == crop(width,height)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    private static long crop(long w, long h) {
        return (w+1) * (h+1);
    }
}
