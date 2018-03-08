package SWExpert;

import java.util.Scanner;

public class D3_1493 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        int p, q;
        int n1, n2;
        int x, y;
        int result[] = new int[tc];

        for(int i=0; i<tc; i++){
            p=sc.nextInt();
            q=sc.nextInt();
            n1 = 0;
            n2 = 0;
            while(true){
                if( p <= (n1*(n1+1)) / 2){
                    n1--;
                    break;
                }
                n1++;
            }
            while(true){
                if( q <= (n2*(n2+1)) / 2){
                    n2--;
                    break;
                }
                n2++;
            }
            x = p - ( n1*(n1+1)) /2 + q - (n2*(n2+1)) / 2;
            y = n1+n2+4-x;

            result[i] = (x+y-1)*(x+y)/2  -  y + 1 ;
        }
        for(int i=0; i<tc; i++){
            System.out.println("#" + (i+1) + " " + result[i]);
        }

    }
}
