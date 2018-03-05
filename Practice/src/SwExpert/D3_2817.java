package SwExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_2817 {

    public static int arr[];
    //    public static int [][][] dp = new int[1001][21][2];
    public static int N;
    public static int K;
    public static int result = 0;
    public static int ret = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] temp = new int[num];

        for (int m = 0; m < num; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N];
            result = 0;
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int a = 0; a < N; a++) {
                arr[a] = Integer.parseInt(st1.nextToken());
            }
            for (int k = 0; k < (1 << arr.length); ++k) {
                ret = 0;
                for (int i = 0; i < arr.length; ++i) {
                    if ((k & (1 << i)) == 0) {
                        ret += arr[i];
                    }
                }
                if (ret == K)
                    result++;
            }
            temp[m] = result;
        }

        for(int i=0; i<num; i++){
            System.out.println("#" + (i+1) + " " + temp[i]);
        }
    }
}

    //            for(int i=0; i<=K; i++){
//                for(int j=0; j<N; j++){
//                    dp[i][j][0] = -1;
//                    dp[i][j][1] = -1;
//                }
//            }
//    public static int solve(int now, int i,  int isSelect){
//        if(now == K) return 1;
//        if(i>=N || now > K) return 0;
//
//        int ret = dp[now][i][isSelect];
//
//        if(ret != -1)
//            return ret;
//
//        return ret = solve(now, i+1, 0) + solve( now+arr[i], i+1, 1);
//    }
//}