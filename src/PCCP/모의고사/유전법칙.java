package PCCP.모의고사;

import java.util.ArrayList;
import java.util.Arrays;

// 메모리 부족 발생
public class 유전법칙 {

    public static void main(String[] args) {

        유전법칙 test = new 유전법칙();
        int[][] queries = new int[][]{{3, 5}};
        String[] result = test.solution(queries);
        System.out.println(Arrays.toString(result));

        queries = new int[][]{{3, 8}, {2, 2}};
        result = test.solution(queries);
        System.out.println(Arrays.toString(result));

        queries = new int[][]{{3, 1}, {2, 3}, {3, 9}};
        result = test.solution(queries);
        System.out.println(Arrays.toString(result));

        queries = new int[][]{{4, 26}};
        result = test.solution(queries);
        System.out.println(Arrays.toString(result));
    }

    ArrayList<String> str[];
    int depth, target;

    public String[] solution(int[][] queries) {

        str = new ArrayList[17];

        for (int i = 0; i < 17; i++) {
            str[i] = new ArrayList<>();
        }

        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            depth = queries[i][0];
            target = queries[i][1];
            func(1, "Rr");
            answer[i] = str[depth].get(target-1);
        }
        return answer;
    }

    void func(int count, String curr) {

        if (count > depth) {
            return;
        }

        str[count].add(curr);

        if(curr.equals("RR")) {
            func(count+1,"RR");
            func(count+1,"RR");
            func(count+1,"RR");
            func(count+1,"RR");
        }
        else if(curr.equals("Rr")) {
            func(count+1,"RR");
            func(count+1,"Rr");
            func(count+1,"Rr");
            func(count+1,"rr");
        }
        else if(curr.equals("rr")) {
            func(count+1,"rr");
            func(count+1,"rr");
            func(count+1,"rr");
            func(count+1,"rr");
        }
    }

}
