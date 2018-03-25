package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 13459 째로탈출
 */

class Ball{
    int x;
    int y;
    int color; // 레드 1, 블루 0
    int cnt;

    Ball(int x, int y, int color, int cnt){
        this.x = x;
        this.y = y;
        this.color = color;
        this.cnt = cnt;
    }
}

public class B_13459 {

    static int N, M;
    static String[][] map;
    static boolean[][] visit;
    static int R_x, R_y,O_x, O_y;
    // 파란 구슬이 빠지면 안된다!!
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = 0;
    static Queue<Ball> blue = new LinkedList<>();
    static Queue<Ball> red = new LinkedList<>();
    static Queue<Ball> q = new LinkedList<>();

    public static void bfs(){
        while(!red.isEmpty()){
            Ball ball = red.poll();
            int X = ball.x;
            int Y = ball.y;
            int color = ball.color;
            int cnt = ball.cnt;

            visit[X][Y] = true;
            for(int i=0; i<4; i++){
                int nextX = X + dx[i];
                int nextY = Y + dy[i];

                if(nextX >= 0 && nextX < N && nextY >=0 && nextY < M && !visit[nextX][nextY]){
                    if(map[nextX][nextY].equals(".")){
                        red.offer(new Ball(nextX, nextY, color, cnt+1));
                    }
                }
            }


            if(X == O_x && Y == O_y && color == 1){
                result = 1;
                return;
            }

            if(color == 1 && cnt == 10){
                return;
            }

        }
    }

    public static void print(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = temp.substring(j, j+1);
                if(map[i][j].equals("B")) {
                    blue.offer(new Ball(i, j, 0, 0));
                }
                else if(map[i][j].equals("R")){
                    red.offer(new Ball(i, j, 0, 0));
                }
                else if(map[i][j].equals("O")){
                    O_x = i;
                    O_y = j;
                }
                else{
                    visit[i][j] = true;
                }
            }
        }

        bfs();

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
