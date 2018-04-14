package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_15650 {

    static int N, M;
    static int[] arr;
    static ArrayList<String> result = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int index, int len, String str){

        if(len==M) {
            if(!result.contains(str))
                result.add(str);
            return;
        }
        if(index==N)
            return;

        String temp = Integer.toString(arr[index]);
        temp = str.concat(temp);


        dfs(index+1, len+1, temp);
        dfs(index+1, len, str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = i+1;

        dfs(0, 0, "");
        for(int i=0; i<result.size(); i++){
            for(int j=0; j<M; j++)
                bw.write(result.get(i).charAt(j) + " ");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}



//import java.io.BufferedReader;
//        import java.io.InputStreamReader;
//
//public class Main {
//    static int[] output;
//
//    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] str = br.readLine().split(" ");
//        int N = Integer.parseInt(str[0]);
//        int M = Integer.parseInt(str[1]);
//        int[] arr = new int[N];
//        output = new int[M];
//        boolean[] visited = new boolean[N];
//
//        for (int i = 0; i < N; i++) {
//            visited[i] = true;
//            DFS(arr, visited, N, M, i, 0);
//            visited[i] = false;
//        }
//    }
//
//    public static void DFS(int[] arr, boolean[] visited, int N, int M, int start, int depth) {
//        output[depth] = start + 1;
//
//        if (depth == M - 1) {
//            for (int i = 0; i < M; i++)
//                System.out.print(output[i] + " ");
//            System.out.println();
//            return;
//        }
//        for (int i = 0; i < N; i++) {
//            if (visited[i])
//                continue;
//            if(start>i) continue;
//            visited[i] = true;
//
//            DFS(arr, visited, N, M, i, depth + 1);
//            visited[i] =false;
//        }
//    }
//}