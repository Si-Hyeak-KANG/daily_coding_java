package BOJ;

import java.util.*;
import java.io.*;

/*
1. N : 나무의 수, M : 필요한 나무 수,
2. 나무 배열 생성, 정렬
3. 절단기 높이 범위 지정, Left : 0, right 나무 중 가장 높은 높이
4. 범위 중 중간값을 임의의로 지정(mid)
- left 가 right 보다 커질 때까지 탐색
5. 나무 배열을 순회하면서, 나무높이에서 mid 를 뺌.
6. 0이하면 패스, 양수면 결과값 저장
7. 모두 순회한 후, 누적된 결과값들의 합과 M 비교
8. 합이 M보다 크거나 같으면, 날을 높여야하기 때문에 Left = mid + 1, ans = mid;
9. 작다면, Right = mid-1
10. 탐색이 끝났을 때, ans 는 mid
 */
public class 나무자르기 {
    public static void main(String[] args) throws IOException {
        // 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N : 나무의 수, M : 필요한 나무 수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] treeArr = new int[N];
        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            treeArr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, treeArr[i]);
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int tree : treeArr) {
                int val = tree - mid;
                if (val <= 0) continue;
                sum += val;
            }

            if (sum >= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(String.valueOf(left-1));
        bw.flush();
        br.close();
    }
}
