package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 11403 경로찾기 DFS
 */

public class B_11403 {

    static int N;
    static int[][] graph;
    static boolean[] visit;

    public static void dfs(int start, int x, int y){
        for(int i=0; i<N; i++){
            if(graph[y][i] == 1 && y != i && graph[start][i] != 1) {
                graph[start][i] = 1;
                dfs(start, y, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visit = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(graph[i][j] != 0)
                    dfs(i, i, j);
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bw.write(graph[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
