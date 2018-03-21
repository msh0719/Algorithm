package SWExpert;


import java.io.*;
import java.util.StringTokenizer;

/**
 * 모의 SW 역량 테스트 - 보호필름
 */
public class SW_2112 {

    static int D, W, K;
    static int[][] film;
    static int[][] film_temp;
    static int min;

    public static boolean check(){
    // flim이 테스트가 가능한지 검사해주는 함수이다.
        int ok = 0;
        for(int i=0; i<W; i++){
            for(int j=0; j<= D-K; j++){
                int cnt = 1;
                for (int n = 1; n < K; n++) { // K개 있는지 확인하는 조
                    if (film[j][i] == film[j+n][i])
                        cnt++;
                    else
                        break;
                }
                if(cnt == K) { //성능 검사를 통과한 열이면 ok ++
                    ok++;
                    break;
                }
            }
            if(ok <= i)  // ok개수가 현재 열보다 작거나 같으면 오류다
                // ex) i가 0이면 ok는 1이여야한다!
                return false;
        }
        return true;
    }

    public static void dfs(int x, int count){

        if(x == D){
            if(check())
                min = Math.min(min, count);
        }
        if(count > min) // min보다 크면 검사할 이유가 없다.
            return;

        if(x+1 <= D) {
            //투입 없이
            dfs(x+1, count);

            //A 투입
            Inject(x, 0);
            dfs(x+1, count+1);
            Inject_re(x);

            //B 투입
            Inject(x, 1);
            dfs(x+1, count+1);
            Inject_re(x);
        }
    }
    public static void Inject(int x, int kind){ //약물 주입하는 함수
        for(int i=0; i<W; i++){
            film_temp[x][i] = film[x][i];
            film[x][i] = kind;
        }
    }

    public static void Inject_re(int x){ //주입한걸 원래대로 돌려놓는 함수
        for(int i=0; i<W; i++){
            film[x][i] = film_temp[x][i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];
            film_temp = new int[D][W];

            for(int i=0; i<D; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++){
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            dfs(0,0);
            bw.write("#" + (tc+1) + " " + min + "\n");


        }
        bw.flush();
        bw.close();
        br.close();
    }
}
