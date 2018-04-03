package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 12100 2048(EASY)
 */

public class B_12100 {

    static int N;
    static int[][] map;
    static int result;
    static Queue<Integer> q;

    public static void move(int dir){
        // 위
        if(dir == 1) {
            q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[j][i] != 0)
                        q.offer(map[j][i]);
                    map[j][i] = 0;
                }
                int temp = 0;
                while (!q.isEmpty()) {
                    int num = q.poll();
                    if (map[temp][i] == 0)
                        map[temp][i] = num;
                    else if (map[temp][i] == num) {
                        map[temp][i] *= 2;
                        temp++;
                    } else {
                        temp++;
                        map[temp][i] = num;
                    }
                }
            }
        }
        //아래
        else if(dir == 2){
            q = new LinkedList<>();
            for(int i=0; i<N; i++){
                for(int j=N-1; j>=0; j--){
                    if(map[j][i] != 0)
                        q.offer(map[j][i]);
                    map[j][i] = 0;
                }
                int temp = N-1;
                while(!q.isEmpty()){
                    int num = q.poll();
                    if(map[temp][i] == 0)
                        map[temp][i] = num;
                    else if(map[temp][i] == num){
                        map[temp][i] *= 2;
                        temp--;
                    }
                    else{
                        temp--;
                        map[temp][i] = num;
                    }
                }
            }
        }
        //오른쪽
        else if(dir == 3){
            q = new LinkedList<>();
            for(int i=0; i<N; i++){
                for(int j=N-1; j>=0; j--){
                    if(map[i][j] != 0)
                        q.offer(map[i][j]);
                    map[i][j] = 0;
                }
                int temp = N - 1;
                while (!q.isEmpty()) {
                    int num = q.poll();
                    if (map[i][temp] == 0)
                        map[i][temp] = num;
                    else if (map[i][temp] == num) {
                        map[i][temp] *= 2;
                        temp--;
                    } else {
                        temp--;
                        map[i][temp] = num;
                    }
                }

            }
        }
        else if(dir == 4){
            q = new LinkedList<>();
            for(int i=0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if(map[i][j] != 0)
                        q.offer(map[i][j]);
                    map[i][j] = 0;
                }
                int temp = 0;
                while (!q.isEmpty()) {
                    int num = q.poll();
                    if (map[i][temp] == 0)
                        map[i][temp] = num;
                    else if (map[i][temp] == num) {
                        map[i][temp] *= 2;
                        temp++;
                    } else {
                        temp++;
                        map[i][temp] = num;
                    }
                }

            }
        }
    }

    public static int max(){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }
    public static void push(int cnt){
        if(cnt == 5) {
            result = Math.max(result, max());
            return;
        }

        int[][] map_temp = new int[N][N];
        map_copy(map, map_temp);
        for(int i=1; i<5; i++){
            move(i);
            push(cnt+1);
            map_copy(map_temp, map);
        }
    }

    public static void map_copy(int[][] map, int[][] temp){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                temp[i][j] = map[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                result = Math.max(result, map[i][j]);
            }
        }


        push(0);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();


    }
}
