package SWExpert;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWExpert 모의 SW 역량테스트 4012 요리사
 */

public class SW_4012 {

    static int N, result;
    static int[][] cook;

    public static void Div(int index, int a_visit, int b_visit, int a_num, int b_num, int a_score, int b_score){

        if(a_num + b_num == N ) {
            result = Math.min(result, Math.abs(a_score - b_score));
        }

        if(a_num < (N/2)){
            int temp = 0;
            for(int i=0; i<N; i++){
                if((a_visit & (1<<i)) == 0){
                    temp += (cook[i][index] + cook[index][i]);
                }
            }
            Div(index+1, (a_visit | 1<<index) , b_visit, a_num+1, b_num, a_score+temp, b_score);
        }
       if(b_num < (N/2)){
            int temp = 0;
            for(int i=0; i<N; i++){
                if((b_visit & (1<<i)) == 0){
                    temp += (cook[i][index] + cook[index][i]);
                }
            }
            Div(index+1, a_visit, (b_visit | 1<<index), a_num, b_num+1, a_score, b_score+temp);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());
            cook = new int[N][N];

            result = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    cook[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            Div(0,0,0,0,0,0,0);
            bw.write("#"+(tc+1)+" " + result + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
