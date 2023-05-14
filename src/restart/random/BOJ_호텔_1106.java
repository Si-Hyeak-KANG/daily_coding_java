package restart.random;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_호텔_1106 {

    // 투자별 고객 수 저장 배열 전역 변수로 저장
    static int[][] customersByCost;
    static int target, city;
    // 최소 비용을 저장할 전역 변수
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // C 확보 (target) 고객, N 도시(city), Cost, Customer
        target = Integer.parseInt(st.nextToken());
        city = Integer.parseInt(st.nextToken());

        // Cost, Customer 이차원 배열에 저장
        customersByCost = new int[city][2];
        for (int i = 0; i < city; i++) {
            st = new StringTokenizer(br.readLine());
            customersByCost[i][0] = Integer.parseInt(st.nextToken());
            customersByCost[i][1] = Integer.parseInt(st.nextToken());
        }
        // 고객 수 내림차순 정렬
        Arrays.sort(customersByCost, (o1,o2) -> o2[1] == o1[1] ? o1[0] - o1[1] : o2[1] - o2[0]);

        // 일차원 배열과 누적고객을 인자로 재귀함수
        search(customersByCost[0], 0, 0);
        // 최소값 클래수 변수 리턴
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean find ;

    // 재귀 함수
    // 현재 일차원 배열을 인자로 전달
    // 목표 고객 수에 도달했을 때 종료
    private static void search(int[] curr, int sumCustomer, int total) {

        int cost = curr[0];
        int customer = curr[1];
        // 누적 고객 수와 추가될 고객 수의 합이 타겟을 넘기면 return
        // 만약 타겟과 일치하면, 최소값 클래스 변수와 totalCost 을 비교해서 더 작으면 최소값 클래스 변수에 저장하고 return
        int next = sumCustomer + customer;
        total += cost;

        if (next > target) return;
        if (next == target) {
            answer = Math.min(answer, total);
            return;
        }

        // 클래스 변수에 저장된 내용의 수만큼 반복 (자신포함)
        for (int i = 0; i <city; i++) {
            search(customersByCost[i], next, total);
        }
    }
}
