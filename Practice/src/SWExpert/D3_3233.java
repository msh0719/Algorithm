package SWExpert;

import java.util.Scanner;

public class D3_3233 {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T;
        long A, B;
        long  result;

        T = sc.nextInt();

        for(int i=0; i<T; i++){
            A = sc.nextLong(); //큰 삼각형 길이
            B = sc.nextLong(); // 작은 삼각형 길이

            if(A == B)
                result = 1;
            else
                result = A/B * A/B;

            System.out.println("#" + (i+1) + " " + result);
        }
    }
}
