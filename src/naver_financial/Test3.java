package naver_financial;

import java.util.ArrayList;

public class Test3 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ad = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ad.get(0).add(1);
        }

        ad.isEmpty();
    }


}
