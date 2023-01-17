package programmers.고득점kit.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리_다른_풀이 {

    public int solution(int[][] maps) {

        int answer = 0;
        int[][] move = {{0,1}, {0,-1},{1,0},{-1,0}};

        Queue<Position> que = new LinkedList<>();
        int[][] count = new int[maps.length][maps[0].length];

        que.add(new Position(0,0));
        count[0][0]=1;

        while (!que.isEmpty()) {
            Position curr = que.poll();
            int curCnt = count[curr.y][curr.x];

            for(int i = 0; i < 4; i++) {
                Position p = new Position(curr.x + move[i][0], curr.y + move[i][1]);

                if(isOutside(maps, p)) continue;
                if(isWall(maps, p)) continue;
                count[p.y][p.x] = curCnt+1;
                maps[p.y][p.x] = 0;
                que.add(p);
            }
        }
        answer=count[maps.length-1][maps[0].length-1];
        if(answer==0) return -1;
        else return answer;
    }

    private static boolean isOutside(int[][] maps, Position p) {
        return p.x < 0 || p.y < 0 || p.x == maps[0].length || p.y == maps.length;
    }

    private static boolean isWall(int[][] maps, Position p) {
        return maps[p.y][p.x] == 0;
    }

    private class Position {
        int x,y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
