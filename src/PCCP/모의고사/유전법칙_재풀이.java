package PCCP.모의고사;

import java.util.Stack;

// test 5번 runtime error 발생, 왜지?
public class 유전법칙_재풀이 {
    final String[] gene = {"RR","Rr", "Rr", "rr"};

    public String[] solution(int[][] queries) {
        int n = queries.length;
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            int depth = queries[i][0]-1;
            int position = queries[i][1]-1;
            String result = search(depth, position);
            answer[i] = result;
        }
        return answer;
    }

    String search(int depth, int curr) {

        if(depth==1) return gene[curr % 4];

        Stack<Integer> stack = new Stack<>();
        while(depth-- > 1) {
            int position = curr % 4;
            stack.add(position);
            curr /= 4;
        }

        while(stack.size() > 1) {
            int i = stack.pop();
            if(gene[i].equals("RR")) return "RR";
            else if(gene[i].equals("rr")) return "rr";
        }

        return gene[stack.pop()];
    }
}
