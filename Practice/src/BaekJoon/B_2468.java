package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 2468 안전영역
 */

public class B_2468 {

    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int min, max, result;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y, int height){
        if(x<0 || x>=N || y<0 || y>=N)
            return;

        if(visit[x][y] || map[x][y]<=height)
            return;

        visit[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            dfs(nx, ny, height);
        }
    }
    public static void init(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++)
                visit[i][j] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        result = 1;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        for(int i=min; i<max; i++){
            init();
            int cnt = 0;
            for(int x=0; x<N; x++){
                for(int y=0; y<N; y++){
                    if(map[x][y] > i && !visit[x][y]){
                        dfs(x, y, i);
                        cnt++;
                    }
                }
            }
            result = Math.max(result, cnt);
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
