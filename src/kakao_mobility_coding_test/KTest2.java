package kakao_mobility_coding_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class KTest2 {
    public static void main(String[] args) {
        KTest2 test = new KTest2();
        String[] id_list = {"A B C D", "A D", "A B D", "B D"};
        System.out.println(test.solution(id_list, 2)); // 7

        String[] id_list2 = {"JAY",
                "JAY ELLE JAY MAY",
                "MAY ELLE MAY",
                "ELLE MAY",
                "ELLE ELLE ELLE",
                "MAY"
        };

        System.out.println(test.solution(id_list2, 3)); // 8
    }

    public int solution(String[] id_list, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        int date = 0;
        while (date < id_list.length) {
            ArrayList<String> receiptList = new ArrayList<>();
            String[] purchaseList = id_list[date].split(" ");

            for (String client : purchaseList) {
                if(!receiptList.contains(client)) {
                    map.put(client, map.getOrDefault(client, 0) + 1);
                    receiptList.add(client);
                }
            }
            date++;
        }

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        int count = 0;
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() > 2) {
                count += k;
            } else {
                count += entry.getValue();
            }
        }
        return count;
    }
}
