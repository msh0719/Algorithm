package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class B_11723 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int S = 0;

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        String cmd;
        int num = 0;
        for(int i=0; i<M; i++) {

            st = new StringTokenizer(br.readLine());

            cmd = st.nextToken();
            if (st.hasMoreTokens()) num = Integer.parseInt(st.nextToken());

            switch (cmd) {

                case "add":
                    S |= 1 << num;
                    break;

                case "remove":
                    S &= ~(1 << num);
                    break;

                case "check":
                    if (((1 << num) & S) != 0)
                        bw.write(1+"\n");
                    else
                        bw.write(0+"\n");
                    break;

                case "toggle":
                    if (((1 << num) & S) == 0)
                        S = S | (1 << num);
                    else
                        S = S & (0 << num);
                    break;

                case "all":
                    S |= (1 << 21) - 1;
                    break;

                case "empty":
                    S = 0;
                    break;
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }
}