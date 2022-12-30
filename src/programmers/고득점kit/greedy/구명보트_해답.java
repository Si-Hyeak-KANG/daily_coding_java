package programmers.고득점kit.greedy;

import java.util.ArrayList;

public class 구명보트_해답 {
    public static void main(String[] args) {
        구명보트_해답 test = new 구명보트_해답();
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int result = test.solution(people, limit);
        System.out.println(result);

        people = new int[]{70, 50, 80};
        limit = 100;
        result = test.solution(people, limit);
        System.out.println(result);
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < people.length; i++) temp.add(people[i]);
        temp.sort((o1, o2) -> o2-o1);

        int first= 0;
        int second = temp.size()-1;
        // 2. limit >= 가장 무거운 사람 + 가장 가벼운 사람
        while(first <= second) {

            int heaviest = temp.get(first);
            int lightest = temp.get(second);

            if(heaviest <= limit / 2) {
                answer += Math.ceil((second + 1 - first) / 2);
                break;
            }
            if(limit >= heaviest + lightest) {
                lightest--;
            }
            first++;
            answer++;
        }

        // 3. 가능한 무게 중 가장 큰 수를 같이 제거하며 카운트
        return answer;
    }
}
