package SWExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D3_4223 {
    static int N;
    static int[] visited = { 2, 1, 1, 1, 1, 1 };
    static int min = 99999;
    static char[][] arr;
    static int[] value;
    static int[] size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Testcase = Integer.parseInt(br.readLine());
        String[] str;
        for (int t = 1; t <= Testcase; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new char[N][15];
            value = new int[N];
            size = new int[N];
            min = 99999;
            for (int i = 0; i < N; i++) {
                size[i] = Integer.parseInt(br.readLine());
                str = br.readLine().split(" ");
                for (int j = 0; j < size[i]; j++) {
                    arr[i][j] = str[j].charAt(0);
                }
                value[i] = Integer.parseInt(br.readLine());
            }
            DFS(0, 0);
            System.out.print("#" + t + " ");
            if (min == 99999) {
                System.out.println(-1);
            } else {
                System.out.println(min);
            }
        }
    }

    public static void DFS(int start, int sum) {

        for (int i = start; i < N; i++) {
            minus(i);
            DFS(i + 1, sum + value[i]);
            plus(i);
        }
        if (!Check()) {
            if (min > sum) {
                min = sum;
            }
        }

    }

    public static void plus(int k) {
        for (int i = 0; i < size[k]; i++) {
            switch (arr[k][i]) {
                case 'S':
                    visited[0]++;
                    break;
                case 'A':
                    visited[1]++;
                    break;
                case 'M':
                    visited[2]++;
                    break;
                case 'U':
                    visited[3]++;
                    break;
                case 'N':
                    visited[4]++;
                    break;
                case 'G':
                    visited[5]++;
                    break;

            }
        }
    }

    public static void minus(int k) {
        for (int i = 0; i < size[k]; i++) {
            switch (arr[k][i]) {
                case 'S':
                    visited[0]--;
                    break;
                case 'A':
                    visited[1]--;
                    break;
                case 'M':
                    visited[2]--;
                    break;
                case 'U':
                    visited[3]--;
                    break;
                case 'N':
                    visited[4]--;
                    break;
                case 'G':
                    visited[5]--;
                    break;

            }
        }
    }

    public static boolean Check() {
        boolean checkk = false;
        for (int i = 0; i < 6; i++) {
            if (visited[i] > 0) {
                checkk = true;
            }
        }
        return checkk;
    }
}