package test;

import java.util.LinkedList;
import java.util.Queue;

public class feel2 {

    public static void main(String[] args) {
        feel2 test = new feel2();
        int[][] map = new int[6][6];
        map[1][3] = -1;
        map[2][0] = -1;
        map[3][1] = -1;
        map[4][4] = -1;
        int result = test.searchFlagCnt(map);
        System.out.println(result);

    }

    final int[][] flag = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1,1}}; // 폭탄 주변 깃발 설치 위치

    public int searchFlagCnt(int[][] map) {

        int cnt=0;
        // map을 전부 순회
        for(int row = 0; row < 6; row++) {
            for(int col = 0; col < 6; col++) {

                int curr = map[row][col];
                if(curr > -1) continue;

                // 현재 위치가 지뢰일 경우 깃발을 설치할 주변 탐색
                for (int position = 0; position < flag.length; position++) {
                    int nextRow = row + flag[position][0];
                    int nextCol = col + flag[position][1];

                    if(isOut(nextRow, nextCol)) continue;

                    int next = map[nextRow][nextCol];
                    if(isLandMine(next)) continue;

                    cnt++;
                }
            }
        }

        return cnt;
    }

    private boolean isLandMine(int next) {
        return next==-1;
    }

    private boolean isOut(int r, int c) {
        return r < 0 || c < 0 || r > 5 || c > 5;
    }

}
