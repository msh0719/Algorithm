package SWExpert;

import java.util.Scanner;

public class D_2048 {

    public static int board[][] = new int[20][20];
    public static boolean visited[][] = new boolean[20][20];
    public static int direction[] = {1, 2, 3, 4};  // 오, 아, 왼, 위
    public static int N;

    public static void move(int signal) {

        switch (signal) {
            case 1: // 오른쪽
                for (int i = 0; i <N; i++) {
                    for(int j = N-1;  j>=0;  j--){
                        if(board[i][j] != 0 && visited[i][j] == false) {

                        }
                    }
                }
                break;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int signal = 0;


        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
                visited[i][j] = false;
            }
        }

    }
 }

