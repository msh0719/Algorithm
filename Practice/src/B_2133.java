import java.io.*;

public class B_2133 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[31];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for(int i = 4; i <= N; i+=2) {
            dp[i] += dp[i-2]*3;
            for(int j=4; j <= i; j+=2){
                dp[i] += dp[i-j] * 2;
            }
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
