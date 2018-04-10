package SWExpert;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SW expert D4 4206 연구소 탈출
 */

class Position{
    int x;
    int y;
    int time;

    Position(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }

}

public class D4_4206 {

    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Position> q;
    static int manX, manY;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int min;
    static boolean zombie;

    public static void bfs(){

        while (!q.isEmpty()){
          Position pos = q.poll();
          int x = pos.x;
          int y = pos.y;
          int time = pos.time;
          int kind = map[x][y];

          visit[x][y] = true;

          for(int i=0; i<4; i++){
              int nextX = x + dx[i];
              int nextY = y + dy[i];

              if(kind==3){
                  if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                      min = Math.min(min, time);
              }

              if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && map[nextX][nextY] != 1){
                  if(map[nextX][nextY] == 0 && !visit[nextX][nextY]){ // 땅
                      map[nextX][nextY] = kind;
                      if(kind == 3)
                          map[x][y] = 0;
                      q.offer(new Position(nextX, nextY, time+1));
                  }
                  else if(kind==3 && map[nextX][nextY]==2){
                      zombie = true;
                  }
              }
          }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visit = new boolean[N][M];
            q = new LinkedList<>();
            min = Integer.MAX_VALUE;
            zombie = false;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2)
                        q.offer(new Position(i, j, 0));
                    else if (map[i][j] == 3) {
                        manX = i;
                        manY = j;
                    }
                }
            }
            q.offer(new Position(manX, manY, 0));
            bfs();

            if (min != Integer.MAX_VALUE)
                bw.write("#"+(tc+1) + " " +(min+1) + "\n");
            else if (min == Integer.MAX_VALUE && zombie)
                bw.write("#"+(tc+1) + " " +"ZOMBIE" + "\n");
            else if (min == Integer.MAX_VALUE && !zombie)
                bw.write("#"+(tc+1) + " " +"CANNOT ESCAPE" + "\n");

        }
        bw.flush();
        bw.close();
        br.close();

    }
}
