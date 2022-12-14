package fasstcampus.모의고사1set;

import java.util.Scanner;

// 실버 3
// 기초 수학, 정수론
// 유클리드 호제
// 두 양의 정수 x,y(x>y)에 대해 x = yq+r(0<=r<y)라면 GCD(x,y) = GCD(y,r)
// 만약 r = 0이라면, 최대 공약수는 y
// LCM(x,y) = (x*y) / GCD(x,y)
// LCM(x,y,z) = LCM(LCM(x,y),z)
public class 소수_최소_공배수_21919 {

    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        long ans = 1;

        for (int i = 0; i < N; i++) {
            long a;
            a = sc.nextInt();
            if (isPrimeNumber(a)) {
                ans = lcm(ans,a);
            }
        }

        if (ans == 1) System.out.println(-1);
        else System.out.print(ans);
    }

    private static boolean isPrimeNumber(long a) {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if(a % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 최소 공배수(LCM)
    private static long lcm(long x, long y) {
        return x / gcd(x,y) * y;
    }

    // 최대 공약수(GCD)
    private static long gcd(long x, long y) {
        while (y != 0) {
            long temp = x % y;
            x=y;
            y=temp;
        }
        return x;
    }
}
