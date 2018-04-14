package SWExpert;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SW Expert D4 4050 재관이의 대량 할인
 */
public class D4_4050 {

    static int N;
    static int[] price;
    static int total, discount, temp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());

            price = new int[N];
            total = 0;
            discount = 0;
            temp = N % 3;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                price[i] = Integer.parseInt(st.nextToken());
                total+=price[i];
            }
            Arrays.sort(price);
            for(int i=0; i<N/3; i++){
                discount += price[temp+(i*3)];
            }
            bw.write("#"+(tc+1)+ " " + (total-discount) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
