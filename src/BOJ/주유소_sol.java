package BOJ;

/**
 * 첫번째 인덱스 도시와 두번째 인덱스 도시의 비용이 오름차순 관계인지 체크
 * 1) 맞다면, 현재 도시의 비용을 다음 도시의 비용으로 적용
 * 2) 아니라면, 그대로 두고 패스
 *
 * // 틀리는 이유 -> long
 */
import java.util.*;
import java.io.*;
public class 주유소_sol {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[] distance = new long[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0, past = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {

            long expense = Long.parseLong(st.nextToken());
            if(i==N-1) break;
            if(past > expense) past = expense;
            answer += past * distance[i];
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
    }
}
