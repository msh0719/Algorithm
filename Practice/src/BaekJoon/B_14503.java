package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 14503 로봇청소기
 */

public class B_14503 {

    static int N, M;
    static int R, C, D;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; //북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};
    static int clean;

    public static void dfs(int x, int y, int d){

        boolean signal = false;
        int dir = d;

        map[x][y] = 2;
        for(int i=0; i<4; i++){
            dir = rotate(dir);
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

           if(nextX >=0 && nextX<N && nextY>=0 && nextY<M && map[nextX][nextY] == 0){
               clean++;
               signal = true;
               dfs(nextX, nextY, dir);
               break;
           }
        }
        if(!signal){ //청소를 못했다면
            boolean sig = false;
            int back = back(d);
            int nextX = x + dx[back];
            int nextY = y + dy[back];

            while(true){
                if(nextX<0 || nextX>=N || nextY<0 || nextY>=M || map[nextX][nextY] == 1)
                    break;

                for(int i=0; i<4; i++){
                    int next_x = nextX + dx[i];
                    int next_y = nextY + dy[i];
                    if(next_x >=0 && next_x < N && next_y >= 0 && next_y < M && map[next_x][next_y]==0){
                        sig = true;
                        dfs(nextX, nextY, d);
                        break;
                    }
                }
                if(sig)
                    break;

                nextX += dx[back];
                nextY += dy[back];
            }
        }
    }

    public static int back(int dir){
        switch(dir){
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 0;
            case 3:
                return 1;
        }
        return 0;
    }

    public static int rotate(int dir){
        switch(dir){
            case 0:
                return 3;
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean = 1;
        map[R][C] = 2;
        dfs(R, C, D);

        bw.write(clean + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
