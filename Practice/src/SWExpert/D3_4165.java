package SWExpert;

import java.io.*;

/**
 * SW expert D3 4165 완전한 팀1
 */

public class D3_4165 {

    static int N;
    static int num;
    static int[][] team;

    public static void DivTeam(int index, int cnt, int number, int[][] arr){

        if(index == N)
            return;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){

            N = Integer.parseInt(br.readLine());

            num = N / 2;
            team =  new int[num][2];


        }

    }

}
