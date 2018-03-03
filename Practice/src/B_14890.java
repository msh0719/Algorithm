import java.io.*;
import java.util.StringTokenizer;

public class B_14890 {

    static int N, L;
    static int[][] map_h, map_v;
    static int result;

    public static void check(int x, int[][] map){

        boolean[] visit = new boolean[N];
        boolean signal = true;
        for(int i=0; i<N-1; i++){
            if(map[x][i] != map[x][i+1]){ // 차이가 다르고
                if(map[x][i] < map[x][i+1]){ // 경사로를 왼쪽에 놓아야 할 경우
                    if(Math.abs(map[x][i] - map[x][i+1]) == 1){ // 경사로를 놓을 수 있을 때
                            for(int j=0; j<L; j++){ //L 만큼의 경사로를 놓기위해 검사하는 부분
                                if(i-j>=0 && !visit[i-j] && map[x][i] == map[x][i-j]){
                                    visit[i-j] = true;
                                }
                                else{
                                    signal = false;
                                    break;
                                }
                            }
                    }
                    else{
                        signal = false;
                        break;
                    }
                }
                else if(map[x][i] > map[x][i+1]){ // 경사로를 오른쪽에 놓아야 할 경우
                    if(Math.abs(map[x][i] - map[x][i+1]) == 1){ // 경사로를 놓을 수 있을 때
                            for(int j=0; j<L; j++){
                                if(i+1+j<N &&!visit[i+1+j] && map[x][i+1] == map[x][i+1+j])
                                    visit[i+1+j] = true;
                                else{
                                    signal = false;
                                    break;
                                }
                            }
                        }
                    else{
                        signal = false;
                        break;
                    }
                }
            }
        }
        if(signal) {
            result++;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map_h = new int[N][N];
        map_v = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map_h[i][j] = Integer.parseInt(st.nextToken());
                map_v[j][i] = map_h[i][j]; // 가로 세로 한방에 확인하기 위해서
            }
        }
        for(int i=0; i<N; i++){
            check(i, map_h);
            check(i, map_v);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
