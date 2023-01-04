package programmers.고득점kit.bfs_dfs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    public static void main(String[] args) {
        게임_맵_최단거리 test = new 게임_맵_최단거리();
        int[][] maps = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int result = test.solution(maps);
        System.out.println(result); // 11

        maps = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0,}, {0, 0, 0, 0, 1}};
        result = test.solution(maps);
        System.out.println(result); // -1
    }

    int answer, targetRow, targetColumn;
    boolean[][] visit;
    boolean find;

    public int solution(int[][] maps) {
        answer = 0;
        targetRow = maps.length - 1;
        targetColumn = maps[0].length - 1;
        visit = new boolean[targetRow + 1][targetColumn + 1];

        searchRoad(0, 0, 0, maps);

        if(!find) return -1;
        else return answer;
    }


}
