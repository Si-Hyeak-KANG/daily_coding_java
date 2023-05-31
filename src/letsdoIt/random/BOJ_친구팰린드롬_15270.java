package letsdoIt.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Q) 무대에 초대한 세울 수 있는 친구의 수
// L) 2<=N[학생수]<=20, 0<=M[관계도 수]<=(N^2-N)/2, 최대 50
// 백트래킹, DFS
public class BOJ_친구팰린드롬_15270 {

    /*
     * 관계도에 맞게 graph 생성
     * boolean 배열로 방문 여부 체크 - 한번 방문한 노드는 다시는 방문하지 않음
     * 관계도 시작 순서에 따라 달라질 수 있기 때문에, 모든 탐색
     * 관계도의 양쪽 노드 중 하나라도 방문했다면 노 카운트 이후 패스
     */
    static int answer = Integer.MIN_VALUE;
    static boolean[] visit;
    static int[][] relationGraph;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        //  관계도 저장 그래프
        relationGraph = new int[edge][2];
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            relationGraph[i][0] = Integer.parseInt(st.nextToken());
            relationGraph[i][1] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[node+1];
        search(edge, 0, 0);

        answer *= 2;
        if (answer < node) {
            answer++;
        }

        System.out.println(answer);
    }

    private static void search(int edge, int idx, int count) {
        if (idx == edge) {
            answer = Math.max(answer, count);
            return;
        }

        int n1 = relationGraph[idx][0];
        int n2 = relationGraph[idx][1];

        if(visit[n1] || visit[n2]) {
            search(edge, idx+1, count);
        } else {
            visit[n1] = true;
            visit[n2] = true;
            search(edge, idx+1, count+1);

            visit[n1] = false;
            visit[n2] = false;
            search(edge, idx+1, count);
        }
    }
}
