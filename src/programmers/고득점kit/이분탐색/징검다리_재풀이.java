package programmers.고득점kit.이분탐색;
/*
바위 n개를 제거했을 때 최소 바위 사이의 거리 중 최댓값.
# 해석) 바위 사이의 거리가 x 일때, 제거된 바위의 개수가 n개인가?
1. 0부터 distance 까지의 중간 값을 임의의 바위 사이 거리 mid라고 지정
2. rocks 정렬
3. rocks를 순회하면서, prev부터의 거리가 mid보다 작으면 (제거) cnt +1
4. cnt가 추가되면, 해당 위치의 바위를 prev로 지정 (처음엔 0)
5. 모두 순회했을 때 cnt가 n과 동일한가?
6. n보다 크다면, 임의의 바위 사이 거리를 좁힌다. 방법은 right = mid-1;
7. 보다 작다면, 임의의 바위 사이 거리를 늘린다. 방법은 left = mid+1;
8. n과 동일한 거리중 최댓값을 구하는 것이기 때문에 left가 right를 넘어갈 때까지 진행
9. 최종 mid가 answer
# TIP
distance가 어떠한 연산없이 right이기 때문에 데이터 1,000,000,000(10억)까지는 int 타입 허용
*/
import java.util.*;
public class 징검다리_재풀이 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0,right = distance;
        Arrays.sort(rocks);

        while(left <= right) {
            int mid = (left + right) / 2;
            int prev = 0;
            int cnt = 0;

            for(int i = 0; i < rocks.length; i++) {
                int curr = rocks[i];
                int dis = curr - prev;
                if(dis < mid) cnt++;
                else prev = curr;
            }

            if(distance - rocks[rocks.length-1] < mid) cnt++;
            if(cnt <= n) {
                answer = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
