import java.io.*;
import java.util.StringTokenizer;

public class B_11722 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr;
        int max;
        int[] dp;

        arr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i] < arr[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        for(int i=0; i<N; i++){
            max = Math.max(max, dp[i]);
        }
            bw.write(max + "\n");

            bw.flush();
            bw.close();
            br.close();
        }

}

