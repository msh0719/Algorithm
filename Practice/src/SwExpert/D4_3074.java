package SwExpert;

import java.util.Scanner;

public class D4_3074 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int N, M;
        long max;
        long[] tf;
        long left, mid, right;
        long result;
        long temp;

        for(int tc = 0; tc < T; tc++){
            N = sc.nextInt();
            M = sc.nextInt();

            tf = new long[N];
            max = Integer.MIN_VALUE;
            for(int i = 0; i< N; i++){
                tf[i] = sc.nextLong();
                max = Math.max(max, tf[i]);
            }
            result = max * M;
            left = 1;
            right = max * M;
            while(left <= right){
                temp = 0;
                mid = (left + right) / 2;
                for(int i=0; i<N; i++)
                    temp += mid / tf[i];

                if(temp < M) {
                    left = mid + 1;
                }
                else if(temp >= M){
                    if(result > mid)
                        result = mid;
                    right = mid - 1;
                }
            }
            System.out.println("#" + (tc+1) + " " + result);
        }
    }
}
