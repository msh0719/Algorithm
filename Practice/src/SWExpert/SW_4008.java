package SWExpert;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 4008. [모의 SW 역량테스트] 숫자 만들기
 */

public class SW_4008 {
    static int N;
    static int[] arr;
    static int[] cal;
    static boolean[][] visit;
    static int max;
    static int min;

    public static void Calculation(int num, int index, int sum, int sub, int mul, int div){
        if(index == N){
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        if(sum < cal[0]){
            Calculation(num+arr[index], index+1, sum+1, sub, mul, div);
        }
        if(sub < cal[1]){
            Calculation(num-arr[index], index+1, sum, sub+1, mul, div);
        }
        if(mul < cal[2]){
            Calculation(num*arr[index], index+1, sum, sub, mul+1, div);
        }
        if(div < cal[3]){
            Calculation(num/arr[index], index+1, sum, sub, mul, div+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++) {

            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            cal = new int[4]; //sum, sub, mul, div
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                cal[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Calculation(arr[0], 1, 0, 0, 0, 0);

            bw.write("#"+(tc+1)+ " " + (max - min) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
