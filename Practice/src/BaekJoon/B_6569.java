package BaekJoon;

import java.util.Scanner;

public class B_6569 {

    static int H, W;
    static long[][] dp = new long[13][1<<11];
    static boolean[][] adj;

    public static boolean check(int a, int b){

        if((a & b) != 0)  return false;

        int ab = a | b;

        for(int i=0; i<W; i++){
            if(( ab & (1 << i)) == 0 ){
                if (i == W-1 || (ab & (1 << (i+1))) != 0)
                    return false;
                else i = i+1;
            }
        }
        return true;
    }

    public static void init(){
        for(int i=0; i<13; i++){
            for(int j=0; j< (1 << 11); j++){
                dp[i][j] = 0;
            }
        }
        adj = new boolean[1<<11][1<<11];
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);


        for(;;){
            H = sc.nextInt();
            W = sc.nextInt();

            if(H == 0 && W ==0)
                break;

            if (H < W) { // 항상 짧은 변으로 수
                int tmp = H;
                H = W;
                W = tmp;
            }
            init();
            for (int i = 0; i < (1<<W); ++i)
                for (int j = 0; j < (1<<W); ++j)
                    if (check(i, j))
                        adj[i][j] = true;

            dp[0][0] = 1;
            for (int row = 0; row < H; ++row)
                for ( int i = 0; i < (1<<W); ++i)
                    for ( int j = 0; j < (1<<W); ++j)
                         if (adj[i][j]) dp[row+1][j] += dp[row][i];

            System.out.println(dp[H][0]);

        }
    }
}
