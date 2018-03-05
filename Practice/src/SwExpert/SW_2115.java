package SwExpert;

import java.util.*;

public class SW_2115 {
    static Scanner sc = new Scanner(System.in);
    static int t;
    static int N;
    static int M;
    static int C;
    static int map[][];
    static int d[][];
    static int result;

    public static void main(String arg[]) {
        t = sc.nextInt();
        for (int testCase = 0; testCase < t; testCase++) {
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            map = new int[N][N];
            d = new int[N][N];
            //입력단
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    d[i][j] = 0;
                }
            }

            //m일떄 최댓값을 d[][]에 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (j + M <= N) {
                        d[i][j] = 0;
                        for (int num = 0; num < (1 << M); num++) {
                            int sum = 0;
                            int maxHoney = 0;
                            for (int use = 0; use < M; use++) { //사용여부
                                if ((num & (1 << use)) != 0) {
                                    sum += map[i][j + use];
                                    maxHoney += map[i][j + use] * map[i][j + use];
                                }
                            }
                            if (sum <= C && d[i][j] < maxHoney)
                                d[i][j] = maxHoney;
                        }
                    }
                }
            }

            result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    for (int k = i; k < N; k++) {
                        for (int l = 0; l <= N - M; l++) {
                            if (i == k && Math.abs(j - l) >= M && result < d[i][j] + d[k][l]) {//같은 줄
                                result = d[i][j] + d[k][l];
                            }else if(i != k &&result < d[i][j] + d[k][l])//다른 줄
                                result = d[i][j] + d[k][l];
                        }
                    }
                }
            }
            System.out.println("#" + (testCase + 1) + " " + result);
        }
    }
}