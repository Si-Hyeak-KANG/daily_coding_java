package hyundai;

import java.io.*;
import java.util.*;

public class 팔단변속기 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        int past = 0;
        int i = 0;
        while(i < 8) {
            int input = Integer.parseInt(st.nextToken());
            if(i!=0) {
                if(input > past) count++;
                else count--;
            }
            past = input;
            i++;
        }
        String ans = "mixed";
        if(count == 7) ans = "ascending";
        else if(count == -7) ans = "descending";

        bw.write(ans);
        bw.flush();
        br.close();
    }
}
