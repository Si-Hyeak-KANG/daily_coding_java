package programmers.level2;

import java.util.*;

/**
 bfs 탐색(Queue) 활용 (시간초과 실패)
 1. int[][] 타입에 maps 생성, X 에는 0 저장
 2. idx(0,0) 부터 시작해서 현재 위치가 0인지 아닌지 체크
 3. 0 이면 1행 이동
 4. 0 이 아니면, Queue에 저장
 5. Queue에 더이상 데이터가 없을 때까지 순회
 6. (상,하,좌,우) 이동할 위치를 Queue에 저장
 7. Queue의 숫자를 빼면서, 연결된 무인도가 있는지 체크
 8. 뺀 숫자는 List에 저장 (갈 수 있는 무인도가 얼만큼 있는지 모르니 List)
 9.지나간 길은 0으로 변환
 10. idx가 마지막에 도달할 때까지 전체 순회
 11. 모두 마무리되고, List에 저장된 값이 없으면 -1, 있으면 오름차순 정렬 후 배열로 변환하고 return
 */
public class 무인도_여행 {

    public static void main(String[] args) {
        무인도_여행 test = new 무인도_여행();
        int[] result = test.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
        System.out.println(Arrays.toString(result));
    }

    final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우

    int endRow, endCol;
    PriorityQueue<Integer> result;
    int[][] intMaps;

    public int[] solution(String[] maps) {

        endRow = maps.length;
        endCol = maps[0].length();
        intMaps = new int[endRow][endCol];
        setIntMaps(maps, endRow, endCol);

        result = new PriorityQueue<>();

        for (int i = 0; i < endRow; i++) {
            for (int j = 0; j < endCol; j++) {

                if (intMaps[i][j] == 0) continue;

                int sum = 0;
                Queue<int[]> nextQueue = new LinkedList<>();
                nextQueue.offer(new int[]{i,j});

                while (!nextQueue.isEmpty()) {
                    int[] currRC = nextQueue.poll();
                    int currRow = currRC[0];
                    int currCol = currRC[1];
                    int curr = intMaps[currRow][currCol];
                    intMaps[currRow][currCol] = 0;
                    sum += curr;

                    for (int d = 0; d < 4; d++) {
                        int nextRow = currRow + move[d][0];
                        int nextCol = currCol + move[d][1];
                        if (!isPossible(nextRow, nextCol)) continue;
                        int next = intMaps[nextRow][nextCol];
                        if(next==0) continue;
                        nextQueue.offer(new int[]{nextRow,nextCol});
                    }
                }

                result.add(sum);
            }
        }

        if (result.isEmpty()) {
            return new int[]{-1};
        } else {
            int[] answer = new int[result.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = result.poll();
            }

            return answer;
        }

    }

    void setIntMaps(String[] maps, int r, int c) {

        for (int i = 0; i < endRow; i++) {
            for (int j = 0; j < endCol; j++) {
                String curr = maps[i].substring(j, j + 1);
                if (curr.equals("X")) continue;
                intMaps[i][j] = Integer.parseInt(curr);
            }
        }
    }

    boolean isPossible(int r, int c) {
        return r >= 0 && c >= 0 && r < endRow && c < endCol;
    }
}

