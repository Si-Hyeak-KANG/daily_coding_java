package BOJ;

import java.util.*;
import java.io.*;

public class 연속합_1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int curr = Integer.parseInt(st.nextToken());

            sum = Math.max(sum+curr,curr);
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
