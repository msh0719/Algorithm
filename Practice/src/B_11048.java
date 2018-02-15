import java.io.*;
        import java.util.StringTokenizer;

public class B_11048 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] candy = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                candy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                dp[i][j] = candy[i][j] + Math.max(dp[i-1][j], Math.max(dp[i-1][j-1], dp[i][j-1]));
            }
        }
        bw.write(dp[N][M] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
