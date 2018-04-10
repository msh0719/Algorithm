package SWExpert;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SW Expert D4 4168 삼성이의 쇼핑
 */

public class D4_4168 {

    static int N, M;
    static int[] price;
    static int[] score;
    static int result, list;

    public static void DFS(int index, int price_, int score_, int signal) {
        if(price_ > N)
            return;
        if(index==M) {
            if(score_ > result){
                result = score_;
                list = signal;
            }
            return;
        }
        DFS(index+1,price_ + price[index], score_+score[index], signal|(1<<index)); //해당 index를 선택한 경우
        DFS(index+1, price_, score_, signal); //선택 하지 않은경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            price = new int[M];
            score = new int[M];

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                price[i] = Integer.parseInt(st.nextToken());
                score[i] = Integer.parseInt(st.nextToken());
            }

            result = Integer.MIN_VALUE;
            list = 0;
            DFS(0,0,0, 0);

            bw.write("#" + (tc+1) + " ");
            for(int i=0; i<M; i++){
                if((list & (1<<i)) != 0)
                    bw.write(i+ " ");
            }
           bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
