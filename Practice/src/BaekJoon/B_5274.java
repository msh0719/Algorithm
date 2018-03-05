package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 5274 불  BFS
 */

class Board{
    int x;
    int y;
    int time;
    int signal;

    Board(int x, int y, int time, int signal){
        this.x = x;
        this.y = y;
        this.time = time;
        this.signal = signal;
    }
}
public class B_5274 {
    static int W, H, min, x, y;
    static int[] dx = {0, -1, 0, 1}; //오, 위, 왼, 아
    static int[] dy = {1, 0, -1, 0};
    static String[][] map;
    static Queue<Board> q = new LinkedList<>();

    public static int bfs(){
            while(!q.isEmpty()) {
                Board b = q.poll();
                int X = b.x;
                int Y = b.y;
                int time = b.time;
                int signal = b.signal;

                if((X == H - 1 || Y == W - 1 || X == 0 || Y == 0) && signal == 0) { // 탈출 조건
                        min = Math.min(time + 1, min);
                }
                else {
                    for (int i = 0; i < 4; i++) {
                        int nextX = X + dx[i];
                        int nextY = Y + dy[i];
                        if (nextX < H && nextX >= 0 && nextY < W && nextY >= 0) { // 판을 벗어나지 않는 다면
                            if (map[nextX][nextY].equals(".")) {
                                if (signal == 1) {
                                    q.offer(new Board(nextX, nextY, time, 1));
                                    map[nextX][nextY] = "*";
                                }
                                else if (signal == 0 && time+1 < min) { // 상근이 이고, 시간이 현재 최소 값보다 작다면
                                        q.offer(new Board(nextX, nextY, time + 1, 0)); // 상근이 이동
                                        map[X][Y] = "*";
                                }
                            }
                        }
                    }
                }
            }
            if (min != Integer.MAX_VALUE)
                return min;

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int result;
        String temp;

        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new String[H][W];
            min = Integer.MAX_VALUE;
            for(int i=0; i<H; i++){
                temp = br.readLine();
                for(int j=0; j<W; j++){
                    map[i][j] = temp.substring(j, j+1);
                    if(map[i][j].equals("*"))  // 불을 먼저 큐에 넣는 곳
                        q.offer(new Board(i, j, 0,  1));
                }
            }
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(map[i][j].equals("@"))
                        q.offer((new Board(i, j,0,0)));
                }
            }
            result = bfs();
            if(result != 0)
                bw.write(result + "\n");
            else
                bw.write("IMPOSSIBLE" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
