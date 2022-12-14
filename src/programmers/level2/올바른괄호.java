package programmers.level2;

public class 올바른괄호 {
    public static void main(String[] args) {
        올바른괄호 test = new 올바른괄호();
        String s = "()()";
        System.out.println(test.solution(s)); //t

        s = "(())()";
        System.out.println(test.solution(s)); //t

        s = ")()(";
        System.out.println(test.solution(s)); //f

        s = "(()(";
        System.out.println(test.solution(s)) ; //f
    }

    boolean solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String bracket = String.valueOf(s.charAt(i));
            if (bracket.equals("(")) {
                count++;
            } else {
                if (count==0) return false;
                count--;
            }
        }

        boolean answer = true;
        if (count!=0) answer = false;
        return answer;
    }
}
