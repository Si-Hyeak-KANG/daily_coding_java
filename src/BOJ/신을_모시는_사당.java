package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 신을_모시는_사당 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] LC = new int[100000];
        int LCIdx = 0;
        int[] RC = new int[100000];
        int RCIdx = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        for(int i = 1; i < N; i++) {
            int curr = arr[i];
            int pre = stack.peek();
            if(curr == pre) {
                stack.add(curr);
            } else {
                if(stack.size() > 1) {
                    if (pre == 1) {
                        LC[LCIdx] = stack.size();
                        LCIdx++;
                    }
                    else {
                        RC[RCIdx] = stack.size();
                        RCIdx++;
                    }
                }
                stack.clear();
                stack.add(curr);
            }
        }

        Arrays.sort(LC);
        Arrays.sort(RC);

        if(LC[LC.length-1] == 0 || RC[RC.length-1]==0) {
            System.out.println(1);
            return;
        }

        int answer1 = Math.abs(LC[LC.length-1]- RC[0]);
    }
}
