package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class B_2455 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int out, in, cur = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            out = Integer.parseInt(st.nextToken());
            in = Integer.parseInt(st.nextToken());
            cur += in - out;
            max = Math.max(cur, max);
        }
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
