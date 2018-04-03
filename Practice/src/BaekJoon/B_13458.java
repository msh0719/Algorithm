package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 13458 시험감독
 * int 범위 벗어나서 한번 틀림 --> long
 */

public class B_13458 {

    static int N;
    static long[] examinee;
    static int B, C;
    static long result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        examinee = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            examinee[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        result = 0;
        for(int i=0; i<N; i++){
            if(examinee[i]-B > 0) {
                if ((examinee[i] - B) % C != 0)
                    result += ((examinee[i] - B) / C + 1);
                else
                    result += ((examinee[i] - B) / C);
            }
        }

        bw.write((result+N) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
