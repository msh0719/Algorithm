package SWExpert;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SW EXPERT 모의 SW 역량 테스트 홈 방범 서비스
 */

public class SW_2117 {

    static int N, M;
    static int temp;
    static int[][] map;
    static int cost, profit, home, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            temp = M*2 - 1;
            map = new int[N][N];
            for(int i=0; i< N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cost = 0;
            profit = 0;
            home = 0;
            result = Integer.MIN_VALUE;
            // 각 점을 완전 탐색
            for(int i=0; i<N; i++){
                int temp = 0;
                for(int j=0; j<N; j++){
                    for (int k = 1; k <= N+1; k++) {
                        cost = (k * k) + ((k - 1) * (k - 1));
                        profit = 0;
                        home = 0;
                        for (int l = 0; l < N; l++) {
                            for (int m = 0; m < N; m++) {
                                // 거리가 k 보다 작고 1인 경우
                                if (Math.abs(i - l) + Math.abs(j - m) < k && map[l][m] == 1) {
                                    profit += M;
                                    home++;
                                }
                            }
                        }
                        if (cost <= profit)
                            temp = home;
                        if (result < temp)
                            result = temp;
                    }
                }
            }
            bw.write("#" + (tc+1) + " " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
