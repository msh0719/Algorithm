package SWExpert;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 4014. [모의 SW 역량테스트] 활주로 건설
 */


public class SW_4014 {

    static int N, X;
    static int[][] map_h, map_v;
    static int result;

    public static void Build(int row, int[][] map){

        boolean[] visit = new boolean[N];
        boolean ok = true;
        for(int i=0; i<N-1; i++){
            if(map[row][i] != map[row][i+1]){ //크기가 다르면 경사로를 놓아야한다
                if(map[row][i] > map[row][i+1]){ // 경사로 오른쪾에 놓기
                    if(Math.abs(map[row][i] - map[row][i+1]) == 1){ //높이 차이 1이라 경사로 가능
                        for(int j=0; j<X; j++){
                            if(i+j+1 < N && !visit[i+j+1] && map[row][i+1] == map[row][i+j+1]){
                                visit[i+j+1] = true;
                            }
                            else{
                                ok = false;
                                break;
                            }
                        }
                    }
                    else{
                        ok = false;
                        break;
                    }
                }
                if(map[row][i] < map[row][i+1]){ //경사로 왼쪽에 놓기
                    if(Math.abs(map[row][i] - map[row][i+1]) == 1){
                        for(int j=0; j<X; j++){
                            if(i-j>=0 && !visit[i-j] && map[row][i] == map[row][i-j]){
                                visit[i-j] = true;
                            }
                            else{
                                ok = false;
                                break;
                            }
                        }
                    }
                    else{
                        ok = false;
                        break;
                    }
                }
            }
        }
        if(ok)
            result++;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            map_h = new int[N][N];
            map_v = new int[N][N];
            result = 0;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map_h[i][j] = Integer.parseInt(st.nextToken());
                    map_v[j][i] = map_h[i][j];
                }
            }
            for(int i=0; i<N; i++){
                Build(i, map_h);
                Build(i, map_v);
            }
            bw.write("#"+(tc+1)+" " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
