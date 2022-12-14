package programmers.고득점kit.해시;

import java.util.Arrays;
import java.util.HashSet;

public class 전화번호_목록 {

    public static void main(String[] args) {
        전화번호_목록 test = new 전화번호_목록();

        String[] pb = {"119", "97674223", "1195524421"};
        System.out.println(test.solution2(pb));// false

        pb = new String[]{"123", "456", "789"};
        System.out.println(test.solution(pb));// true

        pb = new String[]{"12", "123", "1235", "567", "88"};
        System.out.println(test.solution(pb));// false
    }

    /**
     * Sorting/Loop 을 활용한 solution
     * 1) 전화번호를 오름차순으로 sorting
     * 2) 한 번의 루프만 돌면서 두 개의 숫자를 비교
     * 3) 앞 의 숫자가 뒤의 숫자의 접두어인지 확인하며 정답을 구함
     */
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * Hash 를 활용한 Solution
     * 1) 모든 번호를 Hashing
     * 2) loop 를 돌면서 Hash 에서 접두어 검색
     * 3) 예외처리
     */
    public boolean solution2(String[] phone_book) {

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < phone_book.length; i++) {
            set.add(phone_book[i]);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for(int j = 1; j < phone_book[i].length(); j++) {
                String subStr = phone_book[i].substring(0, j);
                if(set.contains(subStr)) {
                  return false;
              }
            }
        }
        return true;
    }
}
