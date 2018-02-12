import java.util.Scanner;


public class D3_3307 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T;
        int N;
        int[] arr;
        int max;
        int[] dp;

        T = sc.nextInt();

        for(int tc = 0; tc < T; tc++){
            N = sc.nextInt();

            arr = new int[N];
            dp = new int[N];

            for(int i=0; i<N; i++){
                arr[i] = sc.nextInt();
                dp[i] = 1;
            }
            max = 1;
            for(int i=0; i<N; i++){
                for(int j=0; j<i; j++){
                    if(arr[i] > arr[j] && dp[i] <= dp[j]){
                        dp[i] = dp[j] + 1;
                        max = Math.max(max, dp[i]);
                    }
                }
            }
            System.out.println("#"+(tc+1)+" " + max);
        }
    }
}
