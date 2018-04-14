package BaekJoon;

        import java.io.*;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.StringTokenizer;

public class B_15663 {
    static int N, M;
    static int[] output;
    static int[] arr;
    static boolean[] visit;
    static HashMap<Integer, Integer> list = new HashMap<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void DFS(int index, int depth) throws IOException {
        if(depth == M-1){
            for(int i=0; i<M; i++){
                bw.write(output[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=0; i<N; i++){
            output[depth+1] = arr[i];

            if(visit[i])
                continue;

            if(list.containsKey(depth))
                if(list.get(depth) == arr[i])
                    continue;

            list.put(depth, arr[i]);
            visit[i]= true;
            DFS(arr[i],depth+1);
            visit[i] = false;
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
            if(i>0 && arr[i-1] == arr[i])
                continue;

            output[0] = arr[i];
            visit[i] = true;
            list.clear();
            DFS(arr[i],0);
            visit[i] = false;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
