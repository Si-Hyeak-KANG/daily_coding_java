package BOJ;

import java.io.*;
import java.util.*;

public class 덩치_sol {
    // 생각보다 엄청 간단했다.
    // 키와 몸무게 둘 다 작으면 [덩치가 크지 않다.] rank 가 밀려남.
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] people = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            int rank = 1;
            int currWeight = people[i][0];
            int currHeight = people[i][1];
            for(int j = 0; j < n; j++) {
                if(i==j) continue;
                int nextWeight = people[j][0];
                int nextHeight = people[j][1];
                if(currWeight < nextWeight && currHeight < nextHeight) rank++;
            }

            System.out.println(rank);
        }
    }
}
