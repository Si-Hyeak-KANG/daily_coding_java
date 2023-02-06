package programmers.level2;

/**
 * 1. 숫자 < 10 이하일때 버튼 누를 개수를 배열에 저장
 * 2. 현재 숫자에서 5이하이면, 값만 더해주고 재귀호출
 * 3. 현재 숫자에서 5 이상이면, 다음 숫자에 +1 한다음 재귀호출
 * 4. 현재 숫자 < 10 이면, answer 업데이트 후 종료
 * .. 지린다.
 */
public class 마법의엘리베이터_sol {

    int cnt[] = {0, 1, 2, 3, 4, 5, 4, 3, 2, 1};
    int answer = Integer.MAX_VALUE;

    public int solution(int cur) {
        helper(cur, 0);
        return answer;
    }

    public void helper(int cur, int val) {
        if (cur < 10) {
            int p = cur > 5 ? 1 : 0;
            answer = Math.min(cnt[cur] + p + val, answer);
            return;
        }
        if(cur % 10 <= 5) helper(cur / 10, cnt[cur%10] + val);
        if(cur % 10 >= 5) helper(cur / 10+1, cnt[cur % 10] + val);
    }
}
