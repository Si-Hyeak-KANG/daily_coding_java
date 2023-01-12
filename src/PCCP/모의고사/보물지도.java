package PCCP.모의고사;

public class 보물지도 {

    // 시간초과 발생
    public static void main(String[] args) {

        보물지도 test = new 보물지도();


        int result = test.solution(5, 4
                , new int[][]{
                        {1, 4}, {2, 1}, {2, 2}, {2, 3},
                        {2, 4}, {3, 3}, {4, 1}, {4, 3},
                        {5, 3}
                });
        System.out.println(result);

        result = test.solution(4, 4
                , new int[][]{
                        {2,3} , {3,3}});
        System.out.println(result);
    }

    int answer = Integer.MAX_VALUE;
    int targetR, targetC;
    boolean[][] isHole;
    boolean useJump;
    boolean[][] isVisit;
    boolean find;

    public int solution(int n, int m, int[][] hole) {

        targetR = m;
        targetC = n;
        isHole = new boolean[m + 1][n + 1];
        isVisit = new boolean[m + 1][n + 1];

        for (int[] h : hole) {
            int c = h[0];
            int r = h[1];
            isHole[r][c] = true;
        }
        move(1, 1, 0);

        if (find) return answer;
        else return -1;
    }

    void move(int row, int column, int count) {

        if (row == targetR && column == targetC) {
            answer = Math.min(answer, count);
            find = true;
            return;
        }

        isVisit[row][column] = true;

        int up = row + 1;
        int right = column + 1;

        // up
        if (up <= targetR && !isVisit[up][column]) {
            if (isHole[up][column]) {
                if (!useJump && up+1 <= targetR) {
                    if(!isHole[up+1][column]) {
                        up += jump();
                        move(up, column, count + 1);
                    }
                }
            } else {
                move(up, column, count + 1);
            }
            isVisit[up][column] = false;
        }


        // Right
        if (right <= targetC && !isVisit[row][right]) {
            if (isHole[row][right]) {
                if (right+1 <= targetC && !useJump) {
                    if(!isHole[row][right+1]) {
                        right += jump();
                        move(row, right, count + 1);
                    }
                }
            } else {
                move(row, right, count + 1);
            }
            isVisit[row][right] = false;
        }

        useJump = false;
    }

    int jump() {
        useJump = true;
        return 1;
    }
}
