package BOJ;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {

        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 단수 입력

        for(int i=1;i<10;i++) {
            System.out.println(n+" * "+i+" = "+n*i);
        }
    }
}
