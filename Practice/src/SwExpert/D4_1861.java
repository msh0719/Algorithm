package SwExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1861 {

    public static int N;
    public static int cnt = 0;
    public static int max = 0;
    public static int result = 0;
    public static int  [][] room;


    public static void dfs(int x, int y){
        if(y+1 < N && room[x][y] + 1 == room[x][y+1] ){ //우
            cnt++;
            dfs(x, y+1);
        }
        if(y-1>=0 && room[x][y] + 1 == room[x][y-1] ){ //좌
            cnt++;
            dfs(x, y-1);
        }
         if(x-1 >= 0 && room[x][y] + 1 == room[x-1][y] ){ // 상
            cnt++;
            dfs(x-1, y);
        }
        if(x+1<N && room[x][y] + 1 == room[x+1][y] ){
            cnt++;
            dfs(x+1, y);
        }
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int i=0; i<tc; i++){
            N = Integer.parseInt(br.readLine());
            room = new int[N][N];
            max = Integer.MIN_VALUE;
            for(int j=0; j<N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<N; k++){
                    room[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for(int x = 0; x<N; x++){
                for(int y=0; y<N; y++){
                    cnt = 1;
                    dfs(x,y);
                    if( max < cnt){
                        max = cnt;
                        result = room[x][y];
                    }
                    else if(max == cnt){
                        result = Math.min(result, room[x][y]);
                    }
                }
            }
            System.out.println("#" + (i+1) + " " + result + " "+ max);
        }
    }
}
