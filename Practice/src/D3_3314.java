import java.util.Scanner;

public class D3_3314 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T;
        int[] score = new int[5];
        int sum;

        T = sc.nextInt();

        for(int tc = 0; tc<T; tc++){

            sum = 0;
            for(int i=0; i<5; i++){
                score[i] = sc.nextInt();
                if(score[i]<40)
                    score[i] = 40;
                sum += score[i];
            }

            System.out.println("#" + (tc+1) + " " + sum/5);
        }
    }
}
