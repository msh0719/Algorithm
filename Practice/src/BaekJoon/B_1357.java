package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 1357 뒤집힌 덧셈
 */

public class B_1357{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String X, Y, revX, revY;
        String temp_s, result;
        int temp;

        st = new StringTokenizer(br.readLine());

        X = st.nextToken();
        Y = st.nextToken();

        revX = new StringBuffer(X).reverse().toString();
        revY = new StringBuffer(Y).reverse().toString();

        temp = Integer.parseInt(revX) + Integer.parseInt(revY);
        temp_s = Integer.toString(temp);

        result = new StringBuffer(temp_s).reverse().toString();
        bw.write(Integer.parseInt(result) + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

}
