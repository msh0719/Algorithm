package BaekJoon;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Min{
    int x;
    int y;
    int time;
    int book;

    Min(int x, int y, int time, int book){
        this.x = x;
        this.y = y;
        this.time = time;
        this.book = book;
    }
}

public class B_1194 {
    static int N, M;
    static char[][] map;
    static boolean[][][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Min> q;
    static int result, temp;

    public static void bfs(){

        while(!q.isEmpty()){
            Min loopy = q.poll();
            int x = loopy.x;
            int y = loopy.y;
            int time = loopy.time;
            int book = loopy.book;

            if(map[x][y] == '1') {
                result = Math.min(result, time);
            }

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(map[nx][ny] == '#' || visit[book][nx][ny])
                    continue;

                if(Character.isUpperCase(map[nx][ny])){
                    temp = (int) Character.toLowerCase(map[nx][ny]) - 97;
                    if((book & (1<<temp)) != 0){ // 키가 있다면
                        q.offer(new Min(nx, ny, time+1, book));
                        visit[book][nx][ny] = true;
                    }
                }
                else if(Character.isLowerCase(map[nx][ny])){
                    temp = (int) map[nx][ny] - 97;
                    q.offer(new Min(nx, ny, time+1, book | (1<<temp)));
                    visit[book | (1<<temp)][nx][ny] = true;
                }
                else{
                    q.offer(new Min(nx, ny, time+1, book));
                    visit[book][nx][ny] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            visit = new boolean[1<<6][N][M];
            q = new LinkedList<>();
            result = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                String temp = br.readLine();
                for(int j=0; j<M; j++){
                    map[i][j]= temp.charAt(j);
                    if(map[i][j]=='0') {
                        q.offer(new Min(i, j, 0, 0));
                        visit[0][i][j] = true;
                    }
                }
            }
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


