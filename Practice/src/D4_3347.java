import java.util.Scanner;

public class D4_3347 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T;
        int N, M;
        int max;
        int result = 0;
        int[] A = new int[1000];
        int[] B = new int[1000];
        int[] score = new int[1000];

        T = sc.nextInt();

        for(int tc = 0; tc < T; tc++){
            N = sc.nextInt();
            M = sc.nextInt();


            for(int i=0; i<N; i++){
                A[i] = sc.nextInt();
                score[i] = 0;
            }
            for(int i=0; i<M; i++){
                B[i] = sc.nextInt();
            }
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(B[i] >= A[j]) {
                        score[j]++;
                        break;
                    }
                }
            }
            max = Integer.MIN_VALUE;
            for(int i=0; i<N; i++){
                if(max < score[i]){
                    max = score[i];
                    result = i + 1;
                }

            }
            System.out.println("#" + (tc+1) + " " + result);
        }
    }
}
