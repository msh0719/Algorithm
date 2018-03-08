package SWExpert;

import java.util.Scanner;

public class D3_3142 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T;
        int n, m;
        int r_1, r_2;

        T = sc.nextInt();

        //유니콘 뿔 1개 트윈혼 뿔 2개
        for(int Tc = 0; Tc < T; Tc++){
            n = sc.nextInt(); // n개의 뿔
            m = sc.nextInt(); // m마리의 짐승

            if( n % 2 == 0){
                if( m == (n / 2)) {
                    r_1 = 0;
                    r_2 = m; //트윈혼
                }
                else{
                    r_1 = 0;
                    r_2 = n/2;
                    while(m != (r_1+r_2) ){
                        r_2 = r_2 - 1;
                        r_1 = r_1 + 2;
                    }
                }
            }
            else{
                if( m == (n/2) + 1){
                        r_2 = n / 2;
                        r_1 = 1;
                }
                else{
                    r_1 = 1;
                    r_2 = n / 2;
                    while(m != (r_1+r_2)){
                        r_2 = r_2 - 1;
                        r_1 = r_1 + 2;
                    }
                }
            }

            System.out.println("#"+(Tc+1)+" "+r_1 + " " + r_2);
        }
    }
}
