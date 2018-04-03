package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 14501 퇴사
 */

public class B_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] counsel = new int[N][2];
        int day, pay, result = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            counsel[i][0] = Integer.parseInt(st.nextToken());
            counsel[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<(1<<N); i++){
            day = 0;
            pay = 0;
            for(int j=0; j<N; j++){
                if( (i & (1<<j)) != 0){
                    int temp = j + counsel[j][0];
                    if(j >= day && temp <= N) {
                        day = j + counsel[j][0];
                        pay += counsel[j][1];
                    }
                }
            }
            result = Math.max(result, pay);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
