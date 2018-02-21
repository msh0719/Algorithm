import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 7576 토마토
 */

class Tomato{
    int x;
    int y;
    int day;

    Tomato(int x, int y, int day){ // 토마토 객체 좌표와 날
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

public class B_7576 {

    static int N, M, temp;
    static int[] dx = {0, -1, 0, 1}; //오, 위, 왼, 아
    static int[] dy = {1, 0, -1, 0};
    static int[][] board;
    static boolean[][] visit;
    static Queue<Tomato> q = new LinkedList<>();

    public static int bfs(){
        while(!q.isEmpty()){
            Tomato t =  q.poll();
            int moveX = t.x;
            int moveY = t.y;
            int day_ = t.day;

            for(int i=0; i<4; i++){
                int nextX = moveX + dx[i];
                int nextY = moveY + dy[i];
                if(nextX < M && nextX >= 0 && nextY < N && nextY >= 0){
                    if(!visit[nextX][nextY]) { // 토마토가 익지 않았으면 상하좌우 안익은 토마토들 큐에 추가
                        visit[nextX][nextY] = true;
                        q.add(new Tomato(nextX, nextY, day_ + 1));
                    }
                }
            }
            temp = day_;
        }
        if(!check())
            temp = -1;

        return temp;
    }
    public static boolean check() { // 토마토가 전부 익었는지 확인하는 부분
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        visit = new boolean[M][N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == -1) //토마토가 익을 수 없는 경우는 visit를 true로 초기화
                    visit[i][j] = true;
            }
        }
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(board[i][j] == 1) { // 토마토가 익어있는 경우에는 visit를 true로 하고 큐에 추가
                    visit[i][j] = true;
                    q.add(new Tomato(i,j,0));
                }
            }
        }
        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
