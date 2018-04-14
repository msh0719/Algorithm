package BaekJoon;

import java.io.*;
import java.util.*;

/**
 * 백준 1261 알고스팟
 * 우선순위 큐
 */

class Wall{
    int x;
    int y;
    int cnt;

    Wall(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class B_1261_ {

    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static PriorityQueue<Wall> q;
    static int result;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void BFS(){

        while(!q.isEmpty()) {
            Wall wall = q.poll();
            int x = wall.x;
            int y = wall.y;
            int cnt = wall.cnt;

            if(x==M && y==N){
                result = cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx <= 0 || nx > M || ny <= 0 || ny > N)
                    continue;
                if(visit[nx][ny])
                    continue;

                if(map[nx][ny] == 0) {
                    q.offer(new Wall(nx, ny, cnt));
                    visit[nx][ny] = true;
                }

                if(map[nx][ny] == 1) {
                    q.offer(new Wall(nx, ny, cnt + 1));
                    visit[nx][ny] = true;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M+1][N+1];
        visit = new boolean[M+1][N+1];

        for(int i=1; i<=M; i++){
            String temp = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j+1] = Integer.parseInt(temp.substring(j, j+1));
            }
        }
        q = new PriorityQueue<Wall>(new Comparator<Wall>() {
            @Override
            public int compare(Wall o1, Wall o2) {
                if(o1.cnt > o2.cnt)
                    return 1;
                else if(o1.cnt < o2.cnt)
                    return -1;
                return 0;
            }
        });
        q.offer(new Wall(1,1,0));
        visit[1][1] = true;


        BFS();

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
