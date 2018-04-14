package SWExpert;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * SW Expert D4 3752 가능한 시험 점수
 */

public class D4_3752 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N;

        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());
            HashSet<Integer> answer = new HashSet<Integer>();
            HashSet<Integer> temp = new HashSet<Integer>();
            st = new StringTokenizer(br.readLine());

            answer.add(0);
            for(int i = 0 ; i < N; i++) {
                int add = Integer.parseInt(st.nextToken());
                for(int ans : answer) {
                    temp.add(ans+add);
                }
                for(int t : temp) {
                    answer.add(t);
                }
            }

            bw.write("#" + (tc+1) + " " +answer.size() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
