package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Top{
    int I;
    int J;
}

public class SW_1949 {

    static int N;
    static int K;
    static int len ;
    static int result ;
    static int[][] arr;
    static int[][] visited;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {0, 0, -1, 1}; //오, 왼, 상, 하
    static int[] dy = {1, -1, 0, 0};
    static boolean hint ;
    static ArrayList<Top> t;
    static Stack<Integer> pStack;

    public static void Path(int x, int y, boolean hint) {
        visited[x][y] = 1;
        pStack.push(arr[x][y]);
        boolean finish = true;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            int temp = isPossible(moveX, moveY, arr[x][y]);
            if (temp == 1) { // 앞으로 고고
                finish = false;
                Path(moveX, moveY, hint);
            } else if (temp == 2 && hint == true) { // 컷컷
                if (K > arr[moveX][moveY] - arr[x][y]) {
                    int temp_h;
                    temp_h = arr[moveX][moveY];
                    arr[moveX][moveY] = arr[x][y] - 1;
                    finish = false;
                    Path(moveX, moveY, false);
                    arr[moveX][moveY] = temp_h;
                }
            }
        }


        if (finish) {
            int count = pStack.size();
            if(count > 0)
                len = Math.max(len, count);
        }

        visited[x][y] = 0;
        pStack.pop();
    }

    public static int isPossible(int x, int y, int num) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return -1;
        }
        if (visited[x][y] == 1)
            return -1;

        if (arr[x][y] < num ) // 출동가능
            return 1;

        if(arr[x][y] >= num) //출동 불가능
            return 2;

        return 0;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < Tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            visited = new int[N][N];
            pStack = new Stack<>();
            max = Integer.MIN_VALUE;
            len = Integer.MIN_VALUE;
            result = 0;
            for (int j = 0; j < N; j++) { // 산 입력
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st1.nextToken());
                    max = Math.max(max, arr[j][k]);
                }
            }
            // 봉우리 초기화
            t = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] == max) {
                        Top top = new Top();
                        top.I = j;
                        top.J = k;
                        t.add(top);
                    }
                }
            }
            for (int j = 0; j < t.size(); j++) {
                hint = true;
                Path(t.get(j).I, t.get(j).J, hint);
                result = Math.max(result, len);
            }
            System.out.println("#" + (i+1) + " " + result);

        }
    }
}
