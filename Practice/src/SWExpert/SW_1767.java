package SWExpert;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * SW expert SW test 1767 프로세서 연결하기
 */

class Processor{
    int x;
    int y;

    Processor(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class SW_1767 {

    static int N, num;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Processor> list;
    static int result, cntP;

    public static void dfs(int index, int cnt, int len){

        if(index == list.size()){ //프로세서 전부를 확인했다면 len 갱신
            if(cntP < cnt){
                cntP = cnt;
                result = len;
            }
            else if(cntP==cnt) {
                result = Math.min(result, len);
            }

            return;
        }

        int x = list.get(index).x;
        int y = list.get(index).y;

        if(x==0 || x==N-1 || y==0 || y==N-1) { // 가장자리 프로세서이면 인덱스, 연결횟수만 늘려서 보낸다.
            dfs(index+1, cnt+1, len);
            return;
        }
        //가장자리가 아닌 프로세서들을 처리하는 부분
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            int temp = 0;
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) //맵을 벗어나면 버리기
                continue;
            if(map[nx][ny] == 1) //이미 연결 되어 있거나 프로세서인 경우는 버리기
                continue;

            temp++;
            map[nx][ny] = 1;
            while(true){
                if(nx==0 || nx==N-1 || ny==0 || ny==N-1){
                    dfs(index+1, cnt+1, len+temp); // 프로세서 연결이 끝나면 인덱스, 횟수, 길이 업데이트해서 넘긴다.
                    map[nx][ny] = 0;
                    break;
                }
                nx += dx[i];
                ny += dy[i];
                if(map[nx][ny]==1) // 이미 연결된 곳이거나 프로세서 자리면 부레이크!
                    break;

                map[nx][ny] = 1;
                temp++;
            }
            while(true){ // 연결한거 다시 돌려놓기
                nx -= dx[i];
                ny -= dy[i];
                if(nx==x && ny== y) // 줄인 좌표가 시작한 좌표와 일치한다면
                    break;

                map[nx][ny] = 0;
            }
        }
        dfs(index+1, cnt, len); //현재 index 프로세서 연결안하고 다음거로 넘기기
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            list = new ArrayList<>();
            num = 0;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = 0;
            cntP = 0;
            for(int i=0; i<N; i++) {
                for (int j = 0; j<N; j++) {
                    if (map[i][j] == 1) {
                        list.add(new Processor(i, j));
                    }
                }
            }
            dfs(0,0,0);
            bw.write("#"+(tc+1)+ " " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
