import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 2695 캥거루 세마리
 */
public class B_2695 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] arr = new int[3];
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i>0){
                max = Math.max(max, arr[i]-arr[i-1]);
            }
        }
        bw.write(max-1 + "\n");
        bw.flush();
        bw.close();
        br.close();


    }
}
