package BaekJoon;

import java.io.*;
/**
 * 백준 10026 적록색약
 */

public class B_10026 {
    static int N;
    static String[][] map;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int R, G ,B;

    public static void dfs(int x, int y, int signal){
        visit[x][y] = true;

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX >= 0 && nextX < N && nextY >=0 && nextY < N && !visit[nextX][nextY]){
                    if(signal==0){
                        if(map[nextX][nextY].equals("R"))
                            dfs(nextX, nextY, 0);
                    }
                    if(signal==1){
                        if(map[nextX][nextY].equals("G"))
                            dfs(nextX, nextY, 1);
                    }
                    if(signal==2){
                        if(map[nextX][nextY].equals("B"))
                            dfs(nextX, nextY, 2);
                    }
                    if(signal==3){
                        if(map[nextX][nextY].equals("R") || map[nextX][nextY].equals("G"))
                            dfs(nextX, nextY, 3);
                    }
                }
            }
        }
    }
    public static void init(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                visit[i][j] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visit = new boolean[N][N];

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = temp.substring(j, j+1);
            }
        }
        R = 0;
        B = 0;
        G = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    if(map[i][j].equals("R")) {
                        R++;
                        dfs(i, j,0);
                    }
                    else if(map[i][j].equals("G")){
                        G++;
                        dfs(i,j,1);
                    }
                    else{
                        B++;
                        dfs(i,j,2);
                    }
                }
            }
        }
        int temp = R+G+B;
        init();
        R = 0;
        G = 0;
        B = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    if(map[i][j].equals("R") || map[i][j].equals("G")){
                        R++;
                        dfs(i,j, 3);
                    }
                    else{
                        B++;
                        dfs(i,j,2);
                    }
                }
            }
        }
        bw.write(temp + " " + (R+B) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
