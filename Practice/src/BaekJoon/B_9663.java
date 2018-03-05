package BaekJoon;//import java.util.Scanner;
//
//public class BaekJoon.B_9663 {
//
//    static int path[] = new int[16];
//    static int n;
//    static int ans;
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//
//        for (int i = 0; i < n; i++) {
//            path[0] = i;
//            nQueen(i, 0);
//        }
//        System.out.println(ans);
//    }
//
//    private static void nQueen(int x, int y) {
//        for (int i = 0; i < y; i++) {
//            if (path[i] == x || Math.abs(x - path[i]) == y - i)
//                return;
//        }
//        if (y == n - 1) {
//            ans++;
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            path[y + 1] = i;
//            nQueen(i, y + 1);
//        }
//    }
//
//}
import java.io.*;

public class B_9663 {

    static int path[];
    static int N;
    static int result;
    static int num;

    private static void nQueen(int x, int y) {
        for (int i = 0; i < y; i++) { // y까지 가능한지 검사하는 부분
            if (path[i] == x || Math.abs(x - path[i]) == y - i)
                return;
        }
        if (y == N - 1) {
            result++;
            return;
        }
        for (int i = 0; i < N; i++) { // y값을 증가하는 부분
            path[y + 1] = i;
            nQueen(i, y + 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            path = new int[N];
            result = 0;
            for (int i = 0; i < N; i++) {
                path[0] = i;
                nQueen(i, 0);
            }
            bw.write(result + "\n");

            bw.flush();
            bw.close();
            br.close();
        }

    }

