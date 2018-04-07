package SWExpert;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 모의 SW 역량테스트 디저트 카페
 */

public class SW_2105 {

    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1, 1, -1, -1}; // 왼쪽아래, 오른쪽 아래, 오른쪾위, 왼쪽위
    static int[] dy = {-1, 1, 1, -1};
    static int distance, result;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void dfs(int startX, int startY, int x, int y, int dir){
        if(list.size() > 1 && startX == x - 1 && startY == y- 1 ){
            distance = Math.max(distance, list.size()+1);
        }
        visit[x][y] = true;
        list.add(map[x][y]);

        for(int i=dir; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(possible(nextX, nextY)){
                dfs(startX, startY, nextX, nextY, i);
            }
        }

        visit[x][y] = false;
        list.remove(list.size()-1);
    }

    public static boolean possible(int nextX, int nextY){
        if(nextX>=0 && nextX<N && nextY>=0 && nextY<N && !visit[nextX][nextY] && !list.contains(map[nextX][nextY]))
            return true;

        else
            return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){

            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visit = new boolean[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = 0;
            for(int i=0; i<N-2; i++){
                for(int j=1; j<N-1; j++){
                    distance = 0;
                    dfs(i,j,i,j, 0);
                    result = Math.max(result, distance);
                }
            }
            if(result == 0)
                result = -1;

            bw.write("#" + (tc+1) + " " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}