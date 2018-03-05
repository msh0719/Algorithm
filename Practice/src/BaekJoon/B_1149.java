package BaekJoon;

import java.util.Scanner;

public class B_1149 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[][] price = new long[N][3];
        long[][] dp = new long[N][3];
        long max;
        long result = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                price[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = price[0][0];
        dp[0][1] = price[0][1];
        dp[0][2] = price[0][2];

        for(int i=1; i<N; i++){
            for(int j=0; j<3; j++){
                max = Integer.MAX_VALUE;
                for(int k=0; k<3; k++){
                    if(j != k){
                        max = Math.min(max, dp[i-1][k] + price[i][j]);
                    }
                }
                dp[i][j] = max;
            }
        }
        for(int i=0; i<3; i++){
            result = Math.min(result, dp[N-1][i]);
        }
        System.out.println(result);
    }
}
