package SWExpert;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWExpert 모의 SW 역량 테스트 1953 탈주범 검거
 */

class Criminal{
    int x;
    int y;
    int time;

    Criminal(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class SW_1953 {

    static int N, M;
    static int R, C, L;
    static int result;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0}; // 하, 상, 우, 좌
    static int[] dy = {0, 0, 1, -1};
    static Queue<Criminal> q = new LinkedList<Criminal>();

    public static void bfs(){
        while (!q.isEmpty()){
            Criminal criminal = q.poll();
            int x = criminal.x;
            int y = criminal.y;
            int time = criminal.time;


            int temp = map[x][y];
            result++;
            for(int i=0; i<4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX >=0 && nextX<N && nextY>= 0 && nextY<M && !visit[nextX][nextY] && time+1 <= L ){
                    if(pipe(temp, i)){
                        // 이동 후 방향이 가능한 파이프인지 검사하기 위해서 signal을 수정한다.
                        double sig = Math.pow(-1, i);
                        if(pipe(map[nextX][nextY], i+sig)){
                            visit[nextX][nextY] = true;
                            q.offer(new Criminal(nextX,nextY, time+1));
                        }
                    }
                }
            }
        }

    }

    //파이프가 해당 방향일때 가능한 경우인지 확인하는 함수이다.
    public static boolean pipe(int pipe, double dir){
        if(dir == 0) {
            if (pipe == 1 || pipe == 2 || pipe == 5 || pipe == 6)
                return true;
        }
        if(dir == 1){
            if(pipe == 1 || pipe == 2 || pipe == 4 || pipe == 7)
                return true;
        }
        if(dir == 2){
            if(pipe == 1 || pipe == 3 || pipe == 4 || pipe == 5)
                return true;
        }
        if(dir == 3){
            if(pipe == 1 || pipe == 3 || pipe == 6 || pipe == 7)
                return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visit = new boolean[N][M];

            result = 0;
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visit[R][C] = true;
            q.offer(new Criminal(R, C, 1));
            bfs();
            bw.write("#"+(tc+1)+ " " + result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
