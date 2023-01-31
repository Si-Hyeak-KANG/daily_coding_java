package programmers.level2;

// 11011
// 11011 11011 00000 11011 11011
// 1 -> 11011, 0 -> 00000

// 1. 트리
// l부터 r까지 순회
// 2. Stack을 활용해서 child[l,r]부터 loot node까지 index 저장(n==1)
// 3. child / 5 가 부모 위치
// 4. Stack에 저장된 index를 꺼내면서 index % 5 의 값이 1인지 0인지 체크
// 5. 0이면 break, 1이면 이 과정을 마지막 데이터까지 진행
// 6. 끝까지 1이면, count;
import java.util.Stack;
public class 유사_칸토어_비트열 {

    public static void main(String[] args) {
        유사_칸토어_비트열 test = new 유사_칸토어_비트열();
        int result = test.solution(3, 1, 125);
        System.out.println(result);
    }
    //final int[] bit = {1,1,0,1,1};
    int ans;
    public int solution(int n, long l, long r) {

        for(long i = l-1; i < r; i++)
            if(isOne(i,n)) ans++;

        return ans;
    }

    boolean isOne(long child, int depth) {

        Stack<Long> st = new Stack<>();
        st.push(child);
        while(depth-- > 1) {
            long parent = child / 5;
            st.push(parent);
            child = parent;
        }

        while(!st.isEmpty()) {
            long curr = st.pop();
            long num = curr % 5;
            if(num == 2) return false;
        }

        return true;
    }
}
