package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class B_9322 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int N;
        String[][] arr;
        String[] result;

        for(int tc=0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());
            arr = new String[3][N];
            result = new String[N];

            for(int i =0; i<3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = st.nextToken();
                }
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[0][i].equals(arr[1][j])){
                        result[i] = arr[2][j];
                     }
                }
            }
            for(int i=0; i<N; i++){
                bw.write(result[i] + " ");
            }

            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
