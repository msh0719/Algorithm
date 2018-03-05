package BaekJoon;

import java.io.*;
/*
이친수
 */

public class B_2193 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[91];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<91; i++){
            dp[i] = dp[i-1] + dp[i-2]; // -1, -2의 이친수들이 i 이친수에 부분이 된다.
        }

        bw.write(dp[N] + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}
