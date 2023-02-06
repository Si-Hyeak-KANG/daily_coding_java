package programmers.level2;

// 누적합 알고리즘
// 1. 00:00 부터 23:59 + 10 (청소시간) 까지 범위의 배열 생성
// 1-1 해당 시간을 분으로 나타내어 이를 인덱스로 취급(H*24+M);
// 2. 입력받은 예약시간의 입실과 퇴실 각각에 해당하는 인덱스에 값을 저장(입실:1, 퇴실: -1);
// 3. arr[i] += arr[i-1];
// 4. 위 점화식 방식으로 0번 인덱스부터 값을 저장하면서 마지막 시간까지 체크
// 5. 순회하면서 저장된 값 중 가장 큰 값을 출력
class 호텔대실_sol {

    final int TOTAL_TIME = 1_450;
    final int H = 60;
    final int CLEAN_TIME = 10;

    public int solution(String[][] book_time) {
        int answer = 0;
        int[] rooms = new int[TOTAL_TIME];
        for(int i = 0; i < book_time.length; i++) {
            String in = book_time[i][0];
            String out = book_time[i][1];
            int inTime = convertToMin(in);
            int outTime = convertToMin(out) + CLEAN_TIME;
            rooms[inTime] += 1;
            rooms[outTime] += -1;
        }

        // 1,451 최종 객실 퇴실 시간(청소 포함)
        for(int i = 1; i < TOTAL_TIME; i++) {
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);
        }
        return answer;
    }

    int convertToMin(String time) {
        String[] sp = time.split(":");
        int hour = Integer.parseInt(sp[0]);
        int min = Integer.parseInt(sp[1]);
        return hour * H + min;
    }
}
