package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 14500 테트로미노
 */

public class B_14500 {
    static int N,M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max;
    static int result;

    public static void dfs(int x, int y, int cnt){
        int temp = 0;

        if(cnt == 4){
            result = Math.max(result, max);
            return;
        }

        temp = map[x][y];
        max += temp;
        map[x][y] = 0;
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >=0 && nextX < N && nextY >=0 && nextY < M && map[nextX][nextY] != 0){
                 dfs(nextX, nextY, cnt+1);
            }
        }
        //원래 대로 돌리기!
        map[x][y] = temp;
        max -= temp;
    }

    // ㅗ ㅓ ㅜ ㅏ 는 dfs로 탐색이 되지 않는다.
    public static void exception(int x, int y){
        if(x-1 >= 0 && y+1<M && y-1 >=0){ // ㅗ
            result = Math.max(result, map[x][y]+map[x-1][y]+map[x][y+1]+map[x][y-1]);
        }
        if(x-1>=0 && x+1<N && y-1>=0) { // ㅓ
            result = Math.max(result, map[x][y]+map[x-1][y]+map[x+1][y]+map[x][y-1]);
        }
        if(x+1<N && y-1>=0 && y+1<M){ //ㅜ
            result = Math.max(result, map[x][y]+map[x+1][y]+map[x][y-1]+map[x][y+1]);
        }
        if(x+1<N && x-1>=0 && y+1<M){ //ㅏ
            result = Math.max(result, map[x][y]+map[x+1][y]+map[x-1][y]+map[x][y+1]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = 0;
        result = Integer.MIN_VALUE;


        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                exception(i, j);
                dfs(i,j,0);
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
