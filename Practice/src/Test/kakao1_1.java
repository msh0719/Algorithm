package Test;

import java.io.*;
import java.util.StringTokenizer;

public class kakao1_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr2[i] =  Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            int temp = arr1[i] | arr2[i];
            for(int j=N-1; j>=0; j--){
                if((temp & (1<<j)) != 0)
                    bw.write("#");
                else
                    bw.write(" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
