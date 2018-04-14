package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 15649 N과 M (2)
 */

public class B_15649 {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] output;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void DFS(int start, int depth) throws IOException {
        if (depth == M - 1) {
            for (int i = 0; i < M; i++) {
                bw.write(output[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            output[depth + 1] = i + 1;
            DFS(i, depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        output = new int[M];

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            output[0] = i + 1;
            DFS(i, 0);
            visited[i] = false;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}