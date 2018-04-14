package BaekJoon;

import java.io.*;
import java.util.*;

/**
 * 백준 1261 알고스팟
 */
class Spot{
    int x;
    int y;
    int wall;

    Spot(int x, int y, int wall) {
        this.x = x;
        this.y = y;
        this.wall = wall;
    }
}
public class B_1261 {

    static int N, M;
    static int[][] map;
    static int[][] dist;
    static Queue<Spot> q;
    static int result;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void BFS(){

        while(!q.isEmpty()) {
            Spot spot = q.poll();
            int x = spot.x;
            int y = spot.y;
            int wall = spot.wall;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx <= 0 || nx > M || ny <= 0 || ny > N)
                    continue;
                if(wall + map[nx][ny] >= dist[nx][ny])
                    continue;

                dist[nx][ny] = wall + map[nx][ny];
                q.offer(new Spot(nx, ny, dist[nx][ny]));
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
        dist = new int[M+1][N+1];

        for(int i=1; i<=M; i++){
            String temp = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j+1] = Integer.parseInt(temp.substring(j, j+1));
                dist[i][j+1] = Integer.MAX_VALUE;
            }
        }
        q = new LinkedList<>();
        dist[1][1] = map[1][1];
        q.offer(new Spot(1,1, dist[1][1]));
        BFS();

        bw.write(dist[M][N]+ "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
