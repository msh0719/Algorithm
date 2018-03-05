package BaekJoon;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 백준 10816 숫자 카드2
 */

public class B_10816 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N, M;

        HashMap<Integer, Integer> hash = new HashMap<>();

        N = Integer.parseInt(br.readLine());


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(hash.containsKey(temp))
                hash.replace(temp, hash.get(temp)+1);
            else
                hash.put(temp,1);
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(hash.containsKey(temp))
                bw.write(hash.get(temp) + " ");
            else
                bw.write("0" + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
