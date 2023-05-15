package letsdoIt;

import java.io.*;

// 입력 계단수, 계단 별 점수
// 배열에 계단 별 점수를 저장 (인덱스는 계단 층 수에 맞게)
// 현재 계단까지 최대 점수를 저장할 배열 생성 (사이즈 300)
// 바텀업(반복문)
// 층수까지만 저장하고 리턴
// 구하고자 하는 층수까지의 최댓값 출력
public class BOJ_계단오르기_2579 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        setInOutStream();
        int target = Integer.parseInt(br.readLine());

        int[] points = new int[target+1];
        for (int i = 1; i <= target; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[301];
        dp[1] = points[1];

        if(target >= 2) dp[2] = points[1] + points[2];

        for (int i = 3; i <= target; i++) {
            int firstMaxPoint = points[i-1] + dp[i-3];
            int secondMaxPoint = dp[i-2];
            dp[i] = points[i] + Math.max(firstMaxPoint, secondMaxPoint);
        }

        bw.write(String.valueOf(dp[target]));
        bw.flush();
        br.close();
    }

    private static void setInOutStream() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }


}
