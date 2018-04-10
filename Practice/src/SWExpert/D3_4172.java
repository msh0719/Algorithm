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

    public static void DFS(int index, int price_ ,int sat) {
        if(price_ > N) //해당 가격이 가격제한인 N을 초과하게되면 더이상의 진행은 무의미
            return;
        if(index==M) { //모든 경우를 다 선택하였을때
            if(sat > result) { //만족도가 가장 큰 것을 고른다.
                result = sat;
            }
            return;
        }
        DFS(index+1,price_ +price[index], sat+score[index]); //해당 index를 선택한 경우
        DFS(index+1, price_, sat); //선택 하지 않은경우
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int max;

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
            DFS(0,0,0);


            bw.write("#" + (tc+1) + " " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
