package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 13460 째로탈출2
 */

class Ball{
    int rx;
    int ry;
    int bx;
    int by;
    int cnt;

    Ball(int rx, int ry, int bx, int by, int cnt){
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}

public class B_13460 {

    static int N, M;
    static String[][] map;
    static int[] dx = {0, 0, -1, 1}; // 우, 좌, 상, 하
    static int[] dy = {1, -1, 0, 0};
    static int o_x, o_y;
    static int result = Integer.MAX_VALUE;
    static Queue<Ball> q = new LinkedList<>();

    public static void bfs(){

        while (!q.isEmpty()) {
            Ball b = q.poll();
            int rx = b.rx;
            int ry = b.ry;
            int bx = b.bx;
            int by = b.by;
            int cnt = b.cnt;

            if (cnt > 10)
                break;

            for (int i = 0; i < 4; i++) {

                int nextrX = rx + dx[i];
                int nextrY = ry + dy[i];
                int nextbX = bx + dx[i];
                int nextbY = by + dy[i];

                int rXtemp = rx, rYtemp = ry, bXtemp = bx, bYtemp = by;

                boolean rGoal = false;
                boolean bGoal = false;
                boolean bSignal = false;

                // 파란공이 빨간공보다 앞에 있는 경우 파란공 먼저 움직이기
                if (!position(rx, ry, bx, by, i)) {
                    bSignal = true;
                    if (possible(nextbX, nextbY)) {
                        while (!map[nextbX][nextbY].equals("#") && !bGoal) {
                            if (nextbX == o_x && nextbY == o_y) {
                                bXtemp = nextbX;
                                bYtemp = nextbY;
                                bGoal = true;
                            }
                            if (rXtemp == nextbX && rYtemp == nextbY) {
                                break;
                            }
                            nextbX += dx[i];
                            nextbY += dy[i];
                        }
                        if(!bGoal) {
                            bXtemp = nextbX - dx[i];
                            bYtemp = nextbY - dy[i];
                        }
                    }
                }
                //빨간공 굴리기
                if (possible(nextrX, nextrY)) {
                    while (!map[nextrX][nextrY].equals("#") && !rGoal) {
                        if (nextrX == o_x && nextrY == o_y) {
                            rXtemp = nextrX;
                            rYtemp = nextrY;
                            rGoal = true;
                        }
                        if (nextrX == bXtemp && nextrY == bYtemp) {
                            break;
                        }
                        nextrX += dx[i];
                        nextrY += dy[i];
                    }
                    if(!rGoal) {
                        rXtemp = nextrX - dx[i];
                        rYtemp = nextrY - dy[i];
                    }
                }

                //파란공 굴리기
                if (possible(nextbX, nextbY) && !bSignal) {
                    while (!map[nextbX][nextbY].equals("#") && !bGoal) {
                        if (nextbX == o_x && nextbY == o_y) {
                            bXtemp = nextbX;
                            bYtemp = nextbY;
                            bGoal = true;
                        }
                        if (nextbX == rXtemp && nextbY == rYtemp) {
                            break;
                        }
                        nextbX += dx[i];
                        nextbY += dy[i];
                    }
                    if(!bGoal) {
                        bXtemp = nextbX - dx[i];
                        bYtemp = nextbY - dy[i];
                    }
                }

                //빨간공만 들어온 경우
                if (rGoal && !bGoal) {
                    result = Math.min(result, cnt);
                }
                //빨간공 파란공 둘 다 안들어간 경우 큐에 삽입
                else if(!rGoal && !bGoal)
                    q.offer(new Ball(rXtemp, rYtemp, bXtemp, bYtemp, cnt+1));
            }
        }
    }

    public static boolean position(int rx, int ry, int bx, int by, int dir){
        switch (dir){
            case 0:
                if(ry > by)
                    return true;
                else
                    return false;
            case 1:
                if(ry < by)
                    return true;
                else
                    return  false;
            case 2:
                if(rx < bx)
                    return true;
                else
                    return false;
            case 3:
                if(rx > bx)
                    return true;
                else
                    return false;
        }
        return false;
    }

    public static boolean possible(int x, int y){
        if(x >= 0 && x<N && y>=0 && y<M)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = temp.substring(j, j+1);
                if(map[i][j].equals("R")) {
                    rx = i;
                    ry = j;
                }
                else if(map[i][j].equals("B")) {
                    bx = i;
                    by = j;
                }
                else if(map[i][j].equals("O")){
                    o_x = i;
                    o_y = j;
                }
            }
        }

        q.add(new Ball(rx, ry, bx, by, 1));
        bfs();

        if(result != Integer.MAX_VALUE)
            bw.write(result + "\n");
        else
            bw.write(-1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
//6 7
//#######
//#..BR##
//#.#####
//#.#O###
//#....##
//#######

//10 10
//##########
//#R.....#B#
//#........#
//#........#
//#........#
//#........#
//#........#
//#.....#..#
//#....#O..#
//##########