package BaekJoon;

import java.util.Scanner;

/*
계단오르기
 */
public class B_2579 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] s = new int[N];
        int[] dp = new int[N];

        for(int i=0; i<N; i++){
            s[i] = sc.nextInt();
        }

        dp[0] = s[0];
        dp[1] = Math.max(s[0]+s[1], s[1]);
        dp[2] = Math.max(s[0]+s[2], s[1]+s[2]);

        for(int i=3; i < N; i++){
            dp[i] = Math.max(dp[i-3]+s[i-1]+s[i], dp[i-2]+s[i]);
        }
        System.out.println(dp[N-1]);
    }

}
