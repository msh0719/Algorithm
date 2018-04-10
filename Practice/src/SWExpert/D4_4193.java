package SWExpert;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SW expert D$ 4193 수영대회 결승
 */

class Pos{
    int x;
    int y;
    int time;

    Pos(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class D4_4193 {

    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int startX, startY, endX, endY;
    static Queue<Pos> q;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int min;


    public static void bfs(){

        while(!q.isEmpty()){
            Pos pos = q.poll();
            int x = pos.x;
            int y = pos.y;
            int time = pos.time;

            if(x == endX && y == endY){
                min = Math.min(min, time);
            }

            for(int i=0; i<4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && map[nextX][nextY] != 1 && !visit[nextX][nextY]){
                    if(map[nextX][nextY] == 0) {
                        q.offer(new Pos(nextX, nextY, time+1));
                        visit[nextX][nextY] = true;
                    }
                    else if(map[nextX][nextY] == 2 && (time % 3 )== 2 ){ // 소용돌이 이동 가능
                        q.offer(new Pos(nextX, nextY, time+1));
                        visit[nextX][nextY] = true;
                    }
                    else if(map[nextX][nextY] == 2 && (time % 3 ) != 2 ) {
                        q.offer(new Pos(x, y, time + 1));
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

        for(int tc = 0; tc <T; tc++){
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visit = new boolean[N][N];

            q = new LinkedList<>();
            min = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            q.offer(new Pos(startX, startY, 0));
            visit[startX][startY] = true;

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            bfs();
            if(min != Integer.MAX_VALUE)
                bw.write("#" + (tc+1) + " " + min + "\n");
            else
                bw.write("#" + (tc+1) + " " + "-1" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
