package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 15652 N과 M (7)
 */


public class B_15657 {
    static int N, M;
    static int[] output;
    static int[] arr;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void DFS(int index, int min, int depth) throws IOException {
        if(depth == M-1){
            for(int i=0; i<M; i++){
                bw.write(output[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=0; i<N; i++){
            output[depth+1] = arr[i];

            if(arr[i] < min)
                continue;

            DFS(arr[i], arr[i], depth+1);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[N];
        output = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            output[0] = arr[i];
            DFS(arr[i], arr[i],0);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
