package BaekJoon;

import java.io.*;

/**
 * 백준 2902 KMP는 왜 KMP일까
 */

public class B_2902 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = br.readLine().split("-");
        for(String s: st ){
            bw.write(s.charAt(0));
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
