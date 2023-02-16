package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 누적합
// 최대 시간 Integer.MAX_VALUE 이하
// 배열의 크기는 Integer.MAX_VALUE+1
// 배열에 count<시작시간+1, 끝 시간-1>
// 실패! ,, 대체 누적합은 언제 어떻게 쓰는거지..
// 문제를 푸는 방법 -> 일단 끝나는 시간으로 정렬해라
public class 회의실배정 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] cntArr = new int[15];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            cntArr[start] += 1;
            cntArr[end] -= 1;
        }

        long max = cntArr[0];
        for(int i = 1; i < cntArr.length; i++) {
            cntArr[i] += cntArr[i-1];
            max = Math.max(cntArr[i], max);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        br.close();
    }
}
