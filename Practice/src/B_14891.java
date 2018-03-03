import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 14891 톱니바퀴
 */

public class B_14891 {

    static int[][] wheel;
    static int K;

    public static void rotate(int num, int pos) {
        if (pos == 1) { // 시계 방향
            int temp = wheel[num][7];
            for (int i = 7; i > 0; i--) {
                wheel[num][i] = wheel[num][i - 1];
            }
            wheel[num][0] = temp;
        } else { // 반 시계 방향
            int temp = wheel[num][0];
            for (int i = 0; i < 7; i++) {
                wheel[num][i] = wheel[num][i + 1];
            }
            wheel[num][7] = temp;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int result = 0;
        int num, dir;

        wheel = new int[4][8];

        // N극 0, S극 1
        for (int i = 0; i < 4; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = Integer.parseInt(temp.substring(j, j + 1));
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken()) - 1;
            dir = Integer.parseInt(st.nextToken());

            rotate(num, dir);


        }
        for (int i = 0; i < 4; i++) {
            for(int j=0; j<8; j++) {
                System.out.print(wheel[i][j]);
            }
            System.out.println();
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}