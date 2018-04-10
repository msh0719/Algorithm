package SWExpert;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 벌꿀 채취
 */

public class SW_2115_1 {

    static int N, M, C, result;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken()); // 벌통 개수
            C = Integer.parseInt(st.nextToken()); // 한 통에 담을 수 있는 최대 꿀양

            map = new int[N][N];
            dp = new int[N][N];
            result = 0;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 해당 좌표에서 꿀의 최대양을 dp 배열에 저장
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(j+M <= N) {
                        for(int n = 0; n < (1 << M); n++) {
                            int maxHoney = 0;
                            int bucket = 0;
                            for (int m = 0; m < M; m++) {
                                if ((n & (1 << m)) != 0) {
                                    bucket += map[i][j+m];
                                    maxHoney += (map[i][j+m]*map[i][j+m]);
                                }
                            }
                            if(bucket <= C) // 최대 양을 넘지 않고, 최대이면 dp 배열 갱신
                                dp[i][j] = Math.max(dp[i][j], maxHoney);
                        }
                    }
                }
            }
            // 두 일꾼이 최대로 채굴할 수 있는 꿀의 양 찾기
            // 1) 한 줄에 두명
            // 2) 다른 줄에 두명
            for(int i=0; i<N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    for (int n = i; n < N; n++) {
                        for (int m = 0; m <= N - M; m++) {
                            if (i == n && Math.abs(j - m) >= M && result < dp[i][j] + dp[n][m]) // 같은줄
                                result = dp[i][j] + dp[n][m];
                            else if (i != n && result < dp[i][j] + dp[n][m]) // 다른줄
                                result = dp[i][j] + dp[n][m];
                        }
                    }
                }
            }
            bw.write("#"+(tc+1) + " " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}


