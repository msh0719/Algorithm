import java.util.Scanner;

public class D3_3282 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T;
        int N, K;
        int[] V;
        int[] C;
        int[][] dp;

        T = sc.nextInt();

        for(int tc = 0; tc < T; tc++){

            N = sc.nextInt();
            K = sc.nextInt();

            V = new int[N];
            C = new int[N];

            dp = new int[N+1][K+1];

            for(int i=0; i<N; i++){
                V[i] = sc.nextInt();
                C[i] = sc.nextInt();
            }

            for(int i=0; i<N+1; i++){
                for(int j=0; j<K+1; j++){
                    dp[i][j] = 0;
                }
            }

            for(int j=0; j<K+1;j++){
                for(int i=1; i<N+1; i++){
                    if(j < V[i-1])
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-V[i-1]]+C[i-1]);

                }
            }

            System.out.println("#"+(tc+1)+" "+ dp[N][K]);
        }
    }
}




//
//    Scanner sc = new Scanner(System.in);
//
//    int T;
//    int N, K;
//    int max;
//    int temp, temp_1;
//    int result;
//    Knapsack knapsack[];
//
//        T = sc.nextInt();
//
//                for(int i=0; i<T; i++){
//
//        N = sc.nextInt();
//        K = sc.nextInt();
//
//        knapsack = new Knapsack[N];
//
//        result = 0;
//        max = Integer.MIN_VALUE;
//        for(int j=0; j<N; j++){
//        knapsack[j] = new Knapsack(sc.nextInt(), sc.nextInt());
//        }
//        for(int j=0; j < (1 << N); ++j){
//        temp = 0;
//        temp_1 = 0;
//        for(int k=0; k < N; ++k){
//        if((j & ( 1 << k)) == 0){
//        temp += knapsack[k].V;
//        if(temp <= K){
//        temp_1 += knapsack[k].C;
//        max = Math.max(max, temp_1);
//        }
//        }
//        result = Math.max(result, max);
//        }
//        }
//
//        System.out.println("#"+ (i+1) + " " + max);
//        }


