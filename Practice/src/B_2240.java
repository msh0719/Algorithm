import java.util.Scanner;

public class B_2240 {


    public static void main(String[] args){

        Scanner sc = new Scanner((System.in));

        int T = sc.nextInt();
        int K = sc.nextInt();
        int num;
        int max = 0;
        int [][] dp = new int[31][3];

        for(int i=0; i<T; i++){
            num = sc.nextInt();

            dp[0][num]++;

            for(int j=1; j<=K; j++){
                if(num == 1) {
                    dp[j][1] = Math.max(dp[j][1], dp[j - 1][2])+1;
                    dp[j][2] = Math.max(dp[j][2], dp[j - 1][1]);
                }
                else{
                    dp[j][2] = Math.max(dp[j][2], dp[j - 1][1])+1;
                    dp[j][1] = Math.max(dp[j][1], dp[j - 1][2]) ;
                }
            }
        }

        for(int i=0; i<=K; i++){
            max = Math.max(Math.max(dp[i][1], dp[i][2]), max);
        }

        System.out.println(max);

    }
}
