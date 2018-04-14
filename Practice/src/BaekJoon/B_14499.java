package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 14499 주사위 굴리기
 */

public class B_14499 {

    static int N, M;
    static int R, C;
    static int K;
    static int[][] map;
    static int[] dir;
    static int[] dx = {-1, 0, 0, -1, 1};
    static int[] dy = {-1, 1, -1, 0, 0};
    static int[] dice = new int[6];

    public static int move(int x, int y, int dir){

        int nextX = x + dx[dir];
        int nextY = y + dy[dir];
        int[] temp = dice.clone();

        if(nextX < 0 || nextX >= N || nextY < 0  || nextY >= M )
            return -1;

        R = nextX;
        C = nextY;

        switch (dir){
            case 1:
                dice[0] = temp[3];
                dice[2] = temp[0];
                dice[3] = temp[5];
                dice[5] = temp[2];
                break;
            case 2:
                dice[0] = temp[2];
                dice[2] = temp[5];
                dice[3] = temp[0];
                dice[5] = temp[3];
                break;
            case 3:
                dice[0] = temp[4];
                dice[1] = temp[0];
                dice[4] = temp[5];
                dice[5] = temp[1];
                break;
            case 4:
                dice[0] = temp[1];
                dice[1] = temp[5];
                dice[4] = temp[0];
                dice[5] = temp[4];
                break;
        }

        if(map[nextX][nextY] == 0)
            map[nextX][nextY] = dice[5];
        else if(map[nextX][nextY] != 0){
            dice[5] = map[nextX][nextY];
            map[nextX][nextY] = 0;
        }
        return dice[0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dir = new int[K];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            int temp = move(R, C, Integer.parseInt(st.nextToken()));
            if(temp != -1)
                bw.write(temp + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
