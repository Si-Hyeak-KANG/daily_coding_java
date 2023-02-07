package test;

public class Test {

    final int TOTAL_TIME = 1_450;
    final int H = 60;
    final int CLEAN_TIME = 10;

    public int solution(String[][] book_time) {
        int answer = 0;
        int[] rooms = new int[TOTAL_TIME];
        for (int i = 0; i < book_time.length; i++) {
            String in = book_time[i][0];
            String out = book_time[i][1];
            int inTime = convertToMin(in);
            int outTime = convertToMin(out) + CLEAN_TIME;
            rooms[inTime] += 1;
            rooms[outTime] += -1;
        }

        // 1,451 최종 객실 퇴실 시간(청소 포함)
        for (int i = 1; i < TOTAL_TIME; i++) {
            rooms[i] += rooms[i - 1];
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
