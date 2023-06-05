package letsdoIt.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// i-X 가 0 인 위치부터 누적합에서 arr[i-X] 빼자
// 무조건 O(N)으로 끝낼것
public class BOJ_21921_sol {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] hitArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) hitArr[i] = Integer.parseInt(st.nextToken());

        int sum = 0, answer = 0, count = 0;
        for (int i = 0; i < N; i++) {
            sum += hitArr[i];
            if (i-X >= 0) sum -= hitArr[i-X];
            if(answer < sum) {
                count = 1;
                answer = sum;
            } else if(answer==sum) {
                count +=1;
            }
        }

        if (answer == 0) System.out.println("SAD");
        else {
            System.out.println(answer);
            System.out.println(count);
        }
    }
}
