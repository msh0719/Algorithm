package BaekJoon;

import java.util.Scanner;

public class B_11053{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 1;
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++) {
            dp[i] = 1;
            for(int j=1; j<i; j++) {
                if(arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    if(max < dp[i]) max = dp[i];
                }
            }
        }
        System.out.print(max);
    }
}