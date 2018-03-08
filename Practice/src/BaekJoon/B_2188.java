package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 2188 축사배정
 * 이분 매칭
 */

public class B_2188 {

    static int N, M, L;
    static int[][] edge;
    static int[] cow_house;
    static boolean[] visit;

    public static boolean find(int x){
        visit[x] = true;
        for(int i=1; i<=M; i++){
          if(edge[x][i] == -1)
              break;
          int temp = edge[x][i];
          if(cow_house[temp] == 0 ||(!visit[cow_house[temp]] && find(cow_house[temp]))){
              cow_house[temp] = x;
              return true;
          }
        }
        return false;
    }
    public static void init(){
        for(int i=1; i<=N; i++)
            visit[i] = false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int result;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edge = new int[N+1][M+1];
        visit = new boolean[N+1];
        cow_house = new int[M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            for(int j=1; j<=L; j++){
                edge[i][j] = Integer.parseInt(st.nextToken());
            }
            for(int j=L+1; j<=M; j++){
                edge[i][j] = -1;
            }
        }
        result = 0;
        for(int i=1; i<=N; i++){
            init();
            if(find(i)) {
                result++;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
