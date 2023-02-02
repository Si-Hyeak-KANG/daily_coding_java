package programmers.고득점kit.greedy;
import java.util.Arrays;
public class 단속카메라 {
    public static void main(String[] args) {
        단속카메라 test = new 단속카메라();
        int result = test.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}});
        System.out.println(result);
    }
    public int solution(int[][] routes) {
        Arrays.sort(routes, (int[] o1, int[] o2) -> o1[1] - o2[1]);
        int carCnt = routes.length;
        boolean[] isCheck = new boolean[carCnt];
        int cnt = 0;
        int camera = routes[0][1];
        for(int i = 0; i < carCnt; i++) {
            if(isCheck[i]) continue;

            for(int j = i+1; j < carCnt; j++) {
                int start = routes[j][0];
                int end = routes[j][1];

                if(start <= camera) {
                    isCheck[j] = true;
                } else {
                    camera = end;
                    break;
                }
            }

            cnt++;
        }

        return cnt;
    }
}
