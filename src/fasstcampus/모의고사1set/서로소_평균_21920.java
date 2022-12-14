package fasstcampus.모의고사1set;

import java.util.Scanner;

// 실버4
// 기초수학, 정수론
// 서로소 : 두 양수의 정수가 1 이외의 공약수를 가지지 않는 것
// GCD(x,y) = 1 일 때, 서로소 관계
public class 서로소_평균_21920 {

    static int N, X;
    static long[] A;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        X = sc.nextInt();

        double count = 0;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            if (gcd(A[i], X) == 1) {
                count++;
                sum += A[i];
            }
        }
        double result = sum / count;
        System.out.printf("%.6f", result);
    }

    public static long gcd(long x, long y) {
        while (y != 0) {
            long rest = x % y;
            x = y;
            y = rest;
        }
        return x;
    }
}
