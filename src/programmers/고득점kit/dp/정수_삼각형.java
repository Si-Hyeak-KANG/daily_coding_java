package programmers.고득점kit.dp;

public class 정수_삼각형 {
    public static void main(String[] args) {

        정수_삼각형 test = new 정수_삼각형();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 7}};
        int result = test.solution(triangle);
        System.out.print(result);
    }

    // bottom up 방식 활용
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int bottom = height-1;
        int[][] temp = new int[height][height];

        // 1. 삼각형 제일 아래 값들 저장
        for (int i = 0; i < triangle.length; i++) {
            temp[bottom][i] = triangle[bottom][i];
        }

        // 2. 삼각형 내부에 값 저장
        for (int i = bottom-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                temp[i][j] = Math.max(temp[i+1][j], temp[i+1][j+1]) + triangle[i][j];
            }
        }

        // 3. 최종연산 중 가장 높은 수 출력
        return temp[0][0];
    }
}
