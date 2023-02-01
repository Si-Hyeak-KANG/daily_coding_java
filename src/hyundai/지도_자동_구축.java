package hyundai;

import java.util.*;
import java.io.*;
public class 지도_자동_구축 {

    static int[] DP = new int[16];
    public static void main(String args[]) throws IOException
    {
        // 1. 입력, 출력 클래서 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 입력값 받기
        int N = Integer.parseInt(br.readLine());

        // 3. 0단계(start) 지점의 점에 개수 저장
        DP[0] = 2;

        int result = search(N);

        String answer = String.valueOf(result);
        bw.write(answer);
        bw.flush();
        br.close();
    }

    static int search(int N) {

        for(int i = 1; i <= N; i++) {
            DP[i] = 2 * DP[i-1]-1;
        }


        return DP[N];
    }
}
