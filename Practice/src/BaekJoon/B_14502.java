package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 14502 연구소
 */

class Virus{
    int x;
    int y;

    Virus(int x, int y){
        this.x = x;
        this.y = y;
    }
}



public class B_14502 {

    static int N, M;
    static int virus_num;
    static int total, result;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Virus> q;
    static ArrayList<Virus> virus = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void dfs(int count){
        if(count == 3){ //벽을 다 세웠다면.
            int cnt = 0;
            visit = new boolean[N][M];
            virus_add();
            while(!q.isEmpty()){
                Virus v = q.poll();
                int X = v.x;
                int Y = v.y;

                for(int i=0; i<4; i++){
                    int nextX = X + dx[i];
                    int nextY = Y + dy[i];
                    if(nextX >= 0 && nextX <N && nextY >=0 && nextY<M && map[nextX][nextY] == 0 && !visit[nextX][nextY]){
                        q.add(new Virus(nextX, nextY));
                        visit[nextX][nextY] = true;
                        cnt--;
                    }
                }
            }
            result = Math.max(result, total+cnt);
            return;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(count+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    // 바이러스 큐에 추가
    public static void virus_add(){
        q = new LinkedList<>();
        for(int i=0; i<virus.size(); i++)
            q.offer(virus.get(i));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        virus_num = 0;
        total = 0;
        result = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)
                    virus.add(new Virus(i, j));
                else if(map[i][j] == 0)
                    total++;

            }
        }
        dfs(0);
        bw.write((result-3) + "\n"); // 벽 3개를 제외한 값.
        bw.flush();
        bw.close();
        br.close();


    }
}
