package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 2098 외판원 순회
 */

public class B_2098 {

    static int N;
    static int[][] map;
    static int[][] dp;
    static int min = Integer.MAX_VALUE;

    public static int find_path(int start, int cur, int visit){

        if(visit == Math.pow(2, N) - 1) // 모든 정점 방문했을 경우 다시 돌아오는 값 더하기...
            return map[cur][start];

        if (dp[cur][visit] > 0)
            return dp[cur][visit];

        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) == 0) { // 다음 갈 경로가 방문되지 x
                if (map[cur][i] != 0) {
                    visit |= 1 << i;
                    int temp = map[cur][i] + find_path(start, i, visit);
                    min = Math.min(min, temp);
                }
            }
        }
        dp[cur][visit] = min;

        return dp[cur][visit];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int result = Integer.MAX_VALUE;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][1<<N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(find_path(0,0,1<<0));
        System.out.println(find_path(1,1,1<<1));
        System.out.println(find_path(2,2,1<<2));
        System.out.println(find_path(3,3,1<<3));

//        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
