package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 무인도_여행_sol {
    public static void main(String[] args) {
        무인도_여행_sol test = new 무인도_여행_sol();
        int[] result = test.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(String[] maps) {
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            int sum = 0;
            for (int j = 0; j < maps[i].length(); j++) {
                sum = search(i, j, visit, maps);
                if(sum > 0) list.add(sum);
            }
        }

        Collections.sort(list);
        return list.isEmpty() ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).toArray();
    }

    private int search(int i, int j, boolean[][] visit, String[] maps) {

        if (i < 0 || j < 0 || i >= visit.length || j >= visit[0].length || visit[i][j] || maps[i].charAt(j) == 'X') {
            return 0;
        }
        visit[i][j] = true;
        return (maps[i].charAt(j) - '0')
                + search(i - 1, j, visit, maps) // 상
                + search(i + 1, j, visit, maps) // 하
                + search(i, j - 1, visit, maps) // 좌
                + search(i, j + 1, visit, maps); // 우
    }
}
