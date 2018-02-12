import java.io.*;
import java.util.StringTokenizer;

public class B_10942 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M, S, E, len;
        int[] arr = new int[N];
        boolean[][] dp = new boolean[N][N];
        boolean temp = true;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                if(arr[i] == arr[j])
                    dp[i][j] = true;
                else
                    dp[i][j] = false;
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            len = E - S + 1;
            if(E == S){
                bw.write(1+"\n");
            }
            else{
                temp = true;
                for(int j=0; j< len/2; j++){
                    if(dp[S-1+j][E-1-j] == false){
                        temp = false;
                        break;
                    }
                }
                if(temp)
                    bw.write(1+"\n");
                else
                    bw.write(0+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
