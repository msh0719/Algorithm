import java.io.*;
import java.util.StringTokenizer;

public class D1_2071 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int temp;
        double sum;

        for(int tc = 0; tc< T;  tc++){
            sum = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<10; i++){
                sum += Integer.parseInt(st.nextToken());
            }
            bw.write("#" + (tc+1) + " " + Math.round(sum/10) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
