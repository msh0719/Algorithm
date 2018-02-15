import java.io.*;

public class B_10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10];
        long sum = 0;

        for(int i=1; i<10; i++){
            dp[1][i] = 1;
        }
        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
                if(j == 0)
                    dp[i][j] = dp[i-1][1] % 1000000000;
                else if(j == 9)
                    dp[i][j] = dp[i-1][8] % 1000000000;
                else
                    dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1]) % 1000000000;

            }
        }
        for(int i=0; i<10; i++){
            sum += dp[N][i];
        }
        bw.write(sum % 1000000000 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
