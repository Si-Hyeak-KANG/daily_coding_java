package kakao_mobility_coding_test;

import java.util.ArrayList;

public class KTest3 {

    public static void main(String[] args) {
        KTest3 test = new KTest3();
        String s = "2021:04:12:16:08:35";
        String[] times = {"01:06:30:00", "01:04:12:00"};
        int[] result = test.solution(s, times);
        for (int i : result) {
            System.out.println(i);
        }
    }

    // YYYY:MM:DD:HH:mm:SS & DD:HH:mm:SS
    public int[] solution(String s, String[] times) {
        int[] answer = {};
        ArrayList<Double> savingList = new ArrayList<>();
        Double firstSaving = Double.parseDouble(s.replaceAll(":", ""));
        savingList.add(firstSaving);

        for (int i = 0; i < times.length; i++) {
            Double nextSaving = Double.parseDouble(times[i].replaceAll(":", ""));
            nextSaving += firstSaving;
            firstSaving = nextSaving;
            savingList.add(nextSaving);
        }

        for (Double aDouble : savingList) {
            System.out.println(aDouble);
        }
        double savingPeriod = savingList.get(savingList.size() - 1) - savingList.get(0);
        System.out.println(savingPeriod);
        return answer;
    }
}
