package hyundai;
import java.util.*;
import java.io.*;
public class 장애물_인식_프로그램 {
    // [상하좌우] 이동거리 좌표 배열
    static int[] moveRow = {-1, 1, 0, 0};
    static int[] moveCol = {0, 0, -1, 1};
    // 맵의 끝단 row, column index
    static int endRow, endCol;
    public static void main(String args[]) throws IOException
    {
        // 입출력 클래스 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 지도 크기 입력(N)
        int N = Integer.parseInt(br.readLine());
        endRow = N-1;
        endCol = N-1;

        // String[] 타입 맵 생성
        String[] map = new String[N];
        // 맵 정보 입력(String)
        for(int i = 0; i <= endRow; i++) map[i] = br.readLine();

        // bfs 탐색
        List<Integer> results = obstacleCount(map);

        // 장애물 개수 오름차순 정렬
        Collections.sort(results);

        // 속도 향상을 위해 StringBuilder에 저장 후 다시 String 변환하여 bw write 출력
        StringBuilder sb = new StringBuilder();

        sb.append(results.size()).append("\n");
        for(int i = 0; i < results.size(); i++) {
            int result = results.get(i);
            sb.append(result).append("\n");
        }

        String ans = String.valueOf(sb);
        bw.write(ans);
        bw.flush();
        br.close();
    }

    // bfs 탐색하며 장애물 개수 체크 메서드
    static List obstacleCount(String[] map) {

        // 장애물 개수 저장 리스트
        List<Integer> cntList = new ArrayList<>();

        // 방문 여부 체크
        boolean[][] visit = new boolean[endRow+1][endCol+1];
        // NxN 전체 탐색 이중 반복문, 시작은 0,0
        for(int i = 0; i <= endRow; i++) {
            for(int j = 0; j <= endCol; j++) {
                // Queue 생성
                Queue<int[]> next = new LinkedList<>();
                int cnt = 0;
                // curr 위치가 0이라면 continue
                int row = i;
                int col = j;
                if(visit[row][col]) continue;
                char curr = map[row].charAt(j);
                if(!isObs(curr)) continue;

                // 맞다면 Queue에 저장
                int[] location = {row,col};
                next.offer(location);
                // 0으로 변경(방문)
                visit[row][col] = true;
                // 장애물 수
                cnt++;

                // Queue 에 아무 데이터도 없을 때까지 순회
                while(!next.isEmpty()) {

                    location = next.poll();
                    int currRow = location[0];
                    int currCol = location[1];

                    for(int m = 0; m < 4; m++) {
                        int nextRow = currRow + moveRow[m];
                        int nextCol = currCol + moveCol[m];
                        // 다음 목적지가 맵 내부인지 체크
                        if(!isValid(nextRow,nextCol)) continue;
                        // 다음 목적지를 방문했었는지 체크
                        if(visit[nextRow][nextCol]) continue;
                        // 다음 목적지가 장애물인지 체크
                        if(!isObs(map[nextRow].charAt(nextCol))) continue;
                        // 모두 가능하다면 Queue에 저장
                        location = new int[]{nextRow,nextCol};
                        next.offer(location);
                        visit[nextRow][nextCol] = true;
                        cnt++;
                    }
                }
                // 더 이상 연결된 장애물이 없다면 List에 저장
                cntList.add(cnt);
            }
        }
        return cntList;
    }

    // 다음 목적지가 맵 내부인지 체크 메서드
    static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r <= endRow && c <= endCol;
    }
    // 다음 목적지가 장애물인지 체크
    static boolean isObs(char s) {
        return s == '1';
    }
}
