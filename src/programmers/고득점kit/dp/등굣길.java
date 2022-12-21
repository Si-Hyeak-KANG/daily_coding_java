package programmers.고득점kit.dp;

public class 등굣길 {
    public static void main(String[] args) {
        등굣길 test = new 등굣길();
        int[][] puddles = {{2,2}};
        int result = test.solution(4, 3, puddles);
        System.out.println(result);
    }

    final int mod = 1000000007;

    public int solution(int m, int n, int[][] puddles) {

        int[][] board = new int[n+1][m+1];
        for (int i = 0; i < puddles.length; i++) {
            int row = puddles[i][1];
            int column = puddles[i][0];
            board[row][column]=-1;
        }

        board[1][1] = 1;
        for (int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m+1; j++) {
                if (board[i][j]==-1) continue;
                if (board[i-1][j] > 0) board[i][j] += board[i-1][j] % mod;
                if (board[i][j-1] > 0) board[i][j] += board[i][j-1] % mod;
            }
        }

        return board[n][m] % mod;
    }
}
