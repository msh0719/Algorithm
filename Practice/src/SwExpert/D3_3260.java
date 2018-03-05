package SwExpert;

import java.util.Scanner;

public class D3_3260 {

    public static int[] result;

    public static void cal(int[] A1, int[] B1, int Lo, int Sh){
        result = new int[A1.length];
        for(int i=0; i<Lo; i++){
            if(i < Sh) {
                if (A1[i] + B1[i] < 10)
                    result[i] = A1[i] + B1[i];
                else {
                    result[i] = 10 - (A1[i] + B1[i]);
                    A1[i + 1]++;
                }
            }
            else
                result[i] = A1[i];
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T;
        int temp = 0;
        String A, B;
        int[] A1, B1;
        T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            A = sc.next();
            B = sc.next();

            A1 = new int[A.length()];
            B1 = new int[B.length()];
            temp = 0;
            for (int j = A.length(); j > 0; j--) {
                A1[temp] = Integer.parseInt(A.substring(j - 1, j));
                temp++;
            }
            temp = 0;
            for (int j = B.length(); j > 0; j--) {
                B1[temp] = Integer.parseInt(B.substring(j - 1, j));
                temp++;
            }

            if(A.length() > B.length())
                cal(A1, B1, A.length(), B.length());
            else
                cal(B1, A1, B.length(), A.length());

            System.out.print("#" + i + " ");
            for(int j=result.length-1; j>=0; j--){
                System.out.print(result[j]);
            }
            System.out.println();

        }
    }
}
