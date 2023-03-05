package programmers.level2;

import java.util.ArrayList;

public class 마법의엘리베이터2 {

    public static void main(String[] args) {
        마법의엘리베이터2 test = new 마법의엘리베이터2();
        int storey = 16;
        int result = test.solution(storey);
        System.out.println(result); // 6*/

        test.answer = Integer.MAX_VALUE;
        storey = 2554;
        result = test.solution(storey);
        System.out.println(result); // 16
    }

    /*
    1) 각 자리수별 수들을 배열에 저장
    2) 재귀로 0번인덱스부터 마지막인덱스 탐색
    3) 4이하 -> 값 그대로 answer 에 저장
    4) 6이상 -> 값에 10을 뺀 결과를 answer에 저장하고, 다음 인덱스 값 + 1
    5) 5 -> 두 가지 경우로 체크
     */
    int answer = Integer.MAX_VALUE;
    int[] arr;

    public int solution(int storey) {
        String toString = String.valueOf(storey);
        arr = new int[toString.length()];
        int idx = arr.length-1;
        for (char num : toString.toCharArray()) {
            arr[idx] = num - 48;
            idx--;
        }

        move(0,0, false);

        return answer;
    }

    // storey 현재 층수, floor 단위
    private void move(int idx,int sum, boolean isPlus) {

        if (idx == arr.length) {
            if(isPlus) sum++;
            answer = Math.min(answer, sum);
            return;
        }

        int curr = arr[idx];
        if(isPlus) curr++;

        if (curr <= 4) {
            move(idx+1, sum+curr, false);
        } else if (6 <= curr) {
            move(idx+1, sum+(10-curr), true);
        } else {
           move(idx+1, sum+curr, false);
           move(idx+1, sum+curr, true);
        }
    }
}
