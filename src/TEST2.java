import java.util.ArrayList;

public class TEST2 {
    public static void main(String[] args) {
        TEST2 test = new TEST2();
        String[] record = {
                "jack:9,10,13,9,15",
                "jerry:7,7,14,10,17",
                "jean:0,0,11,20,0",
                "alex:21,2,7,11,4",
                "kevin:8,4,5,0,0",
                "brown:3,5,16,3,17",
                "ted:0,8,0,0,8",
                "lala:0,12,0,7,9",
                "hue:17,16,8,6,10",
                "elsa:11,13,10,4,13"
        };
        test.solution(record);
    }

    String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String[]> recordList = new ArrayList<>();

        for(int i = 0; i < record.length; i++) {
            String[] split = record[i].split("[:,]");
            recordList.add(split);
        }

        for(int i = 0; i < recordList.size(); i++) {

        }
        return answer;
    }
}
