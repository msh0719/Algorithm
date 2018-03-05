package BaekJoon;

import java.io.*;

/**
 * 백준 11726 2*N 타일 채우기
 * --> 나누기 뺴먹어서 처음에 오답!
 */

public class B_11726 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=N; i++){
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        bw.write(dp[N] % 10007 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
