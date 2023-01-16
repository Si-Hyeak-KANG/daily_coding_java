package hyundai;

import java.io.*;
import java.util.*;

public class 성적평가 {

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] score = new int[3][N];
        int[] total = new int[N];
        int[][] result = new int[4][N];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) score[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {

            for(int j = 0; j < N; j++) {
                int count = 0;
                int curr = score[i][j];

                for(int k = 0; k < N; k++) {
                    if(j==k) continue;
                    int next = score[i][k];
                    if(curr < next) count++;
                }

                result[i][j] = count+1;
                total[j] += curr;
            }
        }

        for(int i = 0; i < N; i++) {
            int curr = total[i];
            int count = 0;
            for(int j = 0; j < N; j++) {
                if(i==j) continue;
                int next = total[j];
                if(curr < next) count++;
            }

            result[3][i] = count+1;
        }

        for (int[] v2 : result) {
            for (int v1 : v2) {
                sb.append(v1).append(" ");
            }
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
    }
}
