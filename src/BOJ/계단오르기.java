package BOJ;

import java.io.*;

/*
#check
1) 한 계단 또는 두 계단 이동 가능
2) 연속된 세 개 X(시작점 O)
3) 마지막은 반드시 밟아야 함.
 */
public class 계단오르기 {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[] dp;
    public static void main(String[] args) throws IOException
    {
        // 입출력
        setInOutStream();
        // 계단 수
        int stairCnt = Integer.parseInt(br.readLine());
        // 각 계단의 점수 저장(인덱스+1 == 층수)
        int[] pointArr = new int[stairCnt+1];
        for(int i = 1; i <= stairCnt; i++) pointArr[i] = Integer.parseInt(br.readLine());

        dp = new int[stairCnt+1];
        dp[1] = pointArr[1];
        if(stairCnt >= 2) dp[2] = pointArr[2] + pointArr[1];
        if(stairCnt >= 3) searchMaxPoint(stairCnt,pointArr);

        bw.write(String.valueOf(dp[stairCnt]));
        bw.flush();
        br.close();
    }
    static void searchMaxPoint(int n,int[] pointArr) {

        for(int i = 3; i <= n; i++) {
            int firstPoint = dp[i-2];
            int secondPoint = dp[i-3] + pointArr[i-1];
            dp[i] = Math.max(firstPoint, secondPoint) + pointArr[i];
        }
    }

    // 입출력 선언 메서드
    static void setInOutStream(){
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
}
