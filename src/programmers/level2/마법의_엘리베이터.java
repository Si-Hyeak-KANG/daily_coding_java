package programmers.level2;

import java.util.ArrayList;
import java.util.List;

// 5가 문제,, 5를 버리거나, 올렸을 때 해가 다르다. 상황에 따라 최적이 다름
public class 마법의_엘리베이터 {

    public static void main(String[] args) {
        마법의_엘리베이터 test = new 마법의_엘리베이터();
        int result = test.solution(16);
        System.out.println(result);

        result = test.solution(2554);
        System.out.println(result); // 14 가 나와야함.
    }

    public int solution(int storey) {

        List<Integer> list = new ArrayList<>();
        while(storey > 0) {
            int n = 10;
            list.add(storey % n);
            storey /= 10;
        }

        int digit = list.size(), cnt = 0;
        boolean over = false;
        for (int i = 0; i < digit; i++) {
            int curr = list.get(i);

            if(over) curr+=1;

            if(curr == 0) continue;
            if(curr <=4 || firstIsFive(i,curr)) {
                cnt += curr;
                over = false;
            } else {
                if(i==digit-1 && curr==5) {
                    over = false;
                    cnt += curr;
                    break;
                }
                cnt += 10 - curr;
                over = true;
            }
        }

        if(over) cnt +=1;
        return cnt;
    }

    private boolean firstIsFive(int i, int curr) {
        return i == 0 && curr == 5;
    }
}
