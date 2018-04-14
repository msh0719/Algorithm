package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 15652 N과 M (4)
 */

public class B_15652 {

    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void DFS(int index, int min, int depth) throws IOException {
        if(depth == M-1){
            for(int i=0; i<M; i++){
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=0; i<N; i++){
            if(min > i)
                continue;

            arr[depth+1] = i+1;
            DFS(i, i,depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];

        for(int i=0; i<N; i++){
            arr[0] = i+1;
            DFS(i, i,0);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
