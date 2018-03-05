package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 11724 연결 요소의 개수
 * --> 방향성 생각 안해서 오답인거 같다.
 */

public class B_11724 {
    static int[][] graph;
    static int N, M;
    static int x, y;
    static int[] visit;
    static int cnt;

    public static void dfs(int x){
        visit[x] = 1;
        for(int i=1; i<=N; i++){
            if(graph[x][i] == 1 && visit[i] != 1)
                dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        visit = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;

        }
        cnt = 0;
        for(int i=1; i<=N; i++){
            if(visit[i] != 1){
                cnt++;
                dfs(i);
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
