package BaekJoon;

import java.io.*;

/**
 * 백준 9655 돌 게임 ..... 그냥 돌아가면서 이기는거 같다.
 */

public class B_9655 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if((N % 2) != 0)
            bw.write("SK" + "\n");
        else
            bw.write("CY" + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}
