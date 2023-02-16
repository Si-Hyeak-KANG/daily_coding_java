package prgms_internship;

import java.util.Arrays;

// 2명의 플레이어가 게임을 진행중
// 2차원 배열이 주어졌을 때 각 인덱스별 일차원 배열이 한 게임
// 첫번째 플레이어부터 시작해서 배열 내에서 0이 아닌 수를 -1
// 다음 플레이어도 0이 아닌 수 -1
// 이와 같이 반복하면서 먼저 대칭을 이루는 배열을 만들면 승리
// 첫번째 플레이가 이기면 1, 지면 0
public class Test {
    public static void main(String[] args) {

        Test test = new Test();
        int[] result = test.solution(new int[][]{{2, 0}, {3, 1}});
        System.out.println(Arrays.toString(result));

    }

    int totalCnt, gameCnt;
    public int[] solution(int[][] queries) {
        totalCnt = queries.length;
        int[] answer = new int[totalCnt];

        for(int i = 0; i < totalCnt; i++) {
            int winner = 0;
            int[] game = queries[i];
            gameCnt = game.length;
            winner = play(game, 0);
            answer[i] = winner;
        }
        return answer;
    }

    private int play(int[] game, int player) {

        int j = gameCnt-1;
        boolean isSame = true;
        for(int i = 0; i < Math.sqrt(gameCnt); i++) {
            if(game[i] != game[j]) {
                isSame = false;
                break;
            }
        }

        if(isSame) return player;

        for (int i = 0; i < game.length; i++) {
            if(game[i] == 0) continue;

            game[i] -= 1;

            if(player == 0) play(game, 1);
            else play(game, 0);

            if(isSame) break;
            game[i] += 1;
        }

        return player;
    }
}
