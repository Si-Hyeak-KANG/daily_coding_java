package test;

import java.util.ArrayList;
import java.util.HashMap;

// n 개의 세그먼트가 주어질 때 만들 수 있는 등식 경우의 수 구하기
// 0 <= n <= 25;
// 0 + 0 = 0
public class Test2 {

    public static void main(String[] args) {
        Test2 test = new Test2();
        int result = test.solution(21);
        System.out.println(result); // 4

        result = test.solution(0);
        System.out.println(result);
    }

    int[] cnt = new int[26];
    int[] number = new int[10];

    int solution(int n) {

        setEachSegment();
        for(int i = 0; i < 9; i++) {
            search(i);
        }

        return cnt[n];
    }

    void setEachSegment() {
        number[0] = 6;
        number[1] = 2;
        number[2] = 5;
        number[3] = 5;
        number[4] = 4;
        number[5] = 5;
        number[6] = 6;
        number[7] = 3;
        number[8] = 7;
        number[9] = 6;
    }
    void search(int curr) {

        for(int i = 0; i < 10; i++) {
            operate(curr, i, "+");
            operate(curr, i, "-");
            operate(curr, i, "*");
            if(i==0) continue;
            operate(curr, i, "/");
        }
    }

    void operate(int a, int b, String op) {

        int val1 = number[a];
        int val2 = number[b];
        int opVal = 0;
        int result = 0;
        if(op.equals("+")) {
            result = a + b;
            opVal = 2;
        } else if(op.equals("-")){
            result = a - b;
            opVal = 1;
        } else if(op.equals("/")) {
            result = a / b;
            opVal = 1;
        } else {
            result = a * b;
            opVal = 2;
        }

        if(result >= 10 || 0 > result) return;
        int idx = val1 + val2 + opVal + number[result];
        if (idx <= 25) cnt[idx]++;
    }
}
