package SWExpert;

import java.util.Scanner;

class Work {
    public int N;
    public int[][] P = new int[16][16];
    public double[] dp = new double[1<<16];

    public double cal(int use, int t) {

        if( t == N) return 100;
        double result = dp[use];

        if(result != -1.0) return result;
        result = 0;
        for(int i=0; i<N; i++){
            if((use&(1 << i)) == 0){
                result = Math.max(result, P[i][t] * cal(use | (1 << i), t+1)/100);
            }
        }
        return result;
    }
}


public class D4_1865 {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        Work work[];
        int testCase = sc.nextInt();
        double [] result = new double[testCase];

        work = new Work[testCase];
        for(int i=0; i<testCase; i++) {
            work[i] = new Work();
            work[i].N = sc.nextInt();

            for (int j = 0; j < work[i].N; j++) {
                for (int k = 0; k < work[i].N; k++) {
                    work[i].P[j][k] = sc.nextInt();
                }
            }
            for(int j=0; j<(1<<work[i].N); j++){
                        work[i].dp[j] = -1;
            }

            result[i] = work[i].cal(0,0);
        }

        for(int i=0; i<testCase; i++){
            System.out.println("#" + (i+1) + " " );
            System.out.printf("%.6f", result[i]);
            System.out.println();
        }
    }
}

//   for (int k = 0; k < (1 << arr.length); ++k) {
//        ret = 0;
//        for (int i = 0; i < arr.length; ++i) {
//        if ((k & (1 << i)) == 0) {
//        ret += arr[i];
//        }
//        }
//        if (ret == K)
//        result++;
//        }