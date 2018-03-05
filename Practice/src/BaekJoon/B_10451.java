package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class B_10451 {

    static int[] arr;
    static int[] visit;
    static int N;

    public static void check(int index){
        visit[index] = 1;

        if(index <= N && visit[arr[index]] == 0)
            check(arr[index]);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int num = 0;

        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());
            num = 0;
            arr = new int[N+1];
            visit = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<=N; i++){
                if(visit[i] == 0){
                    num++;
                    check(arr[i]);
                }
            }
            bw.write(num+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}