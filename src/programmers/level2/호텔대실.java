package programmers.level2;

/*
check
1) 최소한의 객실로 모든 손님이 다 이용
2) 한번 사용한 객실은 퇴실시간 기준으로 10분간 청소
3) 시각은 24시간 표기법 (00:00 ~ 23:59)
4) 각각의 예약시각(입실,퇴실)이 모두 동일할 수 있음
*/
// 1. 예약시간 입실 기준, 오름차순 정렬
// 2. 객실 List 생성
// 3. 예약 내역을 순회
// 3-1. 현재 사용중인 객실이 없으면 바로 객실 1개 생성 후 현재 예약의 퇴실 시간 저장(다음 예약 처리)
// 3-2. 객실이 있다면, 객실 List 순회
// 3-2-1. 객실의 퇴실시간 + 10분 보다 현재 예약의 입실 시간 크다면. 현재 객실 갱신
// 3-3. 예약 처리
// 4. 모두 순회하고 List.size 출력
// 테스트 9,17 실패
import java.util.*;

public class 호텔대실 {
    public static void main(String[] args) {
        호텔대실 test = new 호텔대실();
        String[][] book_time = {
                {"15:00", "17:00"},
                {"16:40", "18:20"},
                {"14:20", "15:20"},
                {"14:10", "19:20"},
                {"18:20", "21:20"}
        };
        int result = test.solution(book_time);
        System.out.println(result);

        book_time = new String[][]{
                {"09:10", "10:10"},
                {"10:20", "12:20"}
        };
        result = test.solution(book_time);
        System.out.println(result);
    }

    public int solution(String[][] book_time) {

        // 1. 예약시간 입실 기준, 오름차순 정렬
        sort(book_time);
        // 2. 객실 List 생성
        List<Integer> rooms = new ArrayList<>();
        // 3. 예약 내역을 순회
        for (int i = 0; i < book_time.length; i++) {

            String in = book_time[i][0];
            String out = book_time[i][1];
            int inTime = convertTime(in);
            int outTime = convertTime(out);
            // 3-1. 현재 사용중인 객실이 없으면 바로 객실 1개 생성 후 현재 예약의 퇴실 시간 저장(다음 예약 처리)
            if (rooms.isEmpty()) {
                rooms.add(outTime);
                continue;
            }
            // 3-2. 객실이 있다면, 객실 List 순회
            for (int j = 0; j < rooms.size(); j++) {
                Integer currRoomEndTime = rooms.get(j);

                // 3-2-1. 객실의 퇴실시간 + 10분 보다 현재 예약의 입실 시간 크다면. 현재 객실 갱신
                if (currRoomEndTime + 10 <= inTime) {
                    rooms.remove(j);
                    break;
                }
            }
            // 3-2-2. 예약 처리
            rooms.add(outTime);

        }
        // 4. 모두 순회하고 List.size 출력
        return rooms.size();
    }

    void sort(String[][] arr) {
        Arrays.sort(arr, ((o1, o2) -> o1[0].compareTo(o2[0]))); // 문자열은 compareTo
    }

    Integer convertTime(String time) {
        String[] sp = time.split(":");
        String hour = sp[0];
        String min = sp[1];
        int h = Integer.parseInt(hour);
        int m = Integer.parseInt(min);
        return h*24 + m;
    }
}
