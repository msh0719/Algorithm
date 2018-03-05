package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class B_1065 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int x, y, z;

        if( N < 100)
            bw.write(N + "\n");

        else{
            result += 99;
            for(int i = 100; i<=N; i++){
                x = (i % 100) % 10; // 일의 자리
                y = (i % 100) / 10; // 십의 자리
                z = i / 100; // 백의 자리

                if( (x-y) == (y-z))
                    result++;
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static class B_1018 {

        static int[][] board;
        static int M;
        static int N;
        static int cur;
        static int num, num1;
        static int result = Integer.MAX_VALUE;
        static String temp;

        public static int change(int x, int y){

            if(board[x][y] == 1)
                cur = 1;
            else
                cur = -1;

            for(int i=0; i<8; i++){
                cur *= -1;
                for(int j=0; j<8; j++){
                    if(j%2 == 0){
                        if(board[x+i][y+j] != cur)
                            num++;
                    }
                    else {
                        if (board[x+i][y+j] != (cur * -1))
                            num++;
                    }
                }
            }
            cur *= -1;
            for(int i=0; i<8; i++){
                cur *= -1;
                for(int j=0; j<8; j++){
                    if(j%2 == 0){
                        if(board[x+i][y+j] != cur)
                            num1++;
                    }
                    else {
                        if (board[x+i][y+j] != (cur * -1))
                            num1++;
                    }
                }
            }
            num = Math.min(num, num1);

            return num;
        }
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st;

            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            board = new int[M][N];

            for(int i=0; i<M; i++){
                temp = br.readLine();
                for(int j= 0; j<N; j++){
                    if(temp.substring(j,j+1).equals("W"))
                        board[i][j] = 1;
                    else
                        board[i][j] = -1;
                }
            }

            for(int i=0; i<=M-8; i++){
                for(int j=0; j<=N-8; j++) {
                    num = 0;
                    num1 = 0;
                    change(i, j);
                    result = Math.min(result, num);
                }
            }

            bw.write(result + "\n");
            bw.flush();
            bw.close();
            br.close();
        }
    }
}
