import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 9237 이장님 초대
 */

public class B_9237 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] tree = new int[N];
        int max = Integer.MIN_VALUE;
        int day;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        day = 0;
        for(int i=N-1; i>=0; i--){
            ++day;
            max = Math.max(max, day+tree[i]);
        }
        bw.write(max+1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
