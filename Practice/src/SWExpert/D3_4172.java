package SWExpert;
import java.io.*;
import java.util.StringTokenizer;

/**
 * SW Expert D3 4172 삼성이의 쇼핑
 */

public class D3_4172 {

    static int N, M;
    static int[] price;
    static int[] score;
    static int result;

    public static void dfs(int index, int price_ ,int score_) {
        if(price_ > N)
            return;
        if(index==M) {
            result = Math.max(result, score_);
            return;
        }
        dfs(index+1,price_+price[index], score_+score[index]);
        dfs(index+1, price_, score_);
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
            dfs(0,0,0);


            bw.write("#" + (tc+1) + " " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
