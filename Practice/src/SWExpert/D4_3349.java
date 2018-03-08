package SWExpert;

import java.util.Scanner;

public class D4_3349 {


    static int W, H, N;
    static int[] x;
    static int[] y;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T;
        int temp_x;
        int temp_y;
        int result;

        T = sc.nextInt();

        for(int tc = 0; tc < T; tc++){
            W = sc.nextInt();
            H = sc.nextInt();
            N = sc.nextInt();

            x = new int[N];
            y = new int[N];

            for(int i=0; i<N; i++){
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }

            result = 0;
            for(int i=1; i<N; i++) {
                temp_x = x[i-1]-x[i];
                temp_y = y[i-1]-y[i];
                if(x[i-1]-x[i] == y[i-1]-y[i])
                    result += Math.abs(temp_x);
                else if(temp_x < 0 && temp_y < 0 && Math.abs(temp_x) > Math.abs(temp_y))
                    result += Math.abs(temp_x);
                else if(temp_x < 0 && temp_y < 0 && Math.abs(temp_x) < Math.abs(temp_y))
                    result += Math.abs(temp_y);
                else if(temp_x < 0 || temp_y <0)
                    result += Math.abs(temp_x) + Math.abs(temp_y);
                else if(temp_x > temp_y)
                    result += Math.abs(temp_x);
                else if(temp_x < temp_y)
                    result += Math.abs(temp_y);
            }
            System.out.println("#"+(tc+1)+" "+result);
        }

    }
}
