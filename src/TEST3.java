import java.util.ArrayList;
import java.util.StringTokenizer;

public class TEST3 {
    public static void main(String[] args) {
        TEST3 test = new TEST3();
        String[] subway = {"1 2 3 4 5 6 7 8", "2 11", " 0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21"};
        int start = 1;
        int end = 1;
        int result = test.solution(subway, start, end);
        System.out.println(result); // 1

        subway = new String[]{"1 2 3 4 5 6 7 8 9 10", "2 8"};
        start = 1;
        end = 10;
        result = test.solution(subway, start, end);
        System.out.println(result); // 0

        subway = new String[]{"1 2 3 4", "1 12 13 14"};
        start = 2;
        end = 12;
        result = test.solution(subway, start, end);
        System.out.println(result); // 0
    }

    static ArrayList<Integer> transfer = new ArrayList<>();
    static ArrayList<ArrayList<String>> subwayList = new ArrayList<>();

    int solution(String[] subway, int start, int end) {
        int answer = 0;
        for(int i = 0; i < subway.length; i++) {
            ArrayList<String> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(subway[i]," ");
            while(st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
            subwayList.add(list);
        }
        return answer;
    }

    void countTransfer(int start, int end) {

    }

}
