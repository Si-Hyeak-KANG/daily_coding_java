package programmers.level2;

import java.util.*;

public class 롤케이크_자르기 {

    private int solution(int[] topping) {
        int answer = 0;
        int size = topping.length;

        Set<Integer> first = new HashSet<>();
        Map<Integer,Integer> sec = new HashMap<>();

        first.add(topping[0]);
        for(int i = 1; i < size; i++) {
            int num = topping[i];
            sec.put(num, sec.getOrDefault(num, 0)+1);
        }

        for (int i = 1; i < size; i++) {
            int num = topping[i];
            first.add(num);
            sec.put(num, sec.get(num)-1);

            if(sec.get(num) == 0) sec.remove(num);
            if(first.size() == sec.size()) answer++;
        }

        return answer;
    }
}
