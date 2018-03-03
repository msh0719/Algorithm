import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1920 수 찾기
 */

public class B_1920 {

    static int N, M;
    static int[] A;
    static boolean result = true;

    public static boolean check(int left, int right, int num){
        int mid = (left + right) / 2;

        if(left > right)
            return false;

        else{
            if(A[mid] > num)
                result = check(left, mid-1, num);

            else if(A[mid] < num)
                result = check(mid+1, right, num);
            else
                return true;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            if(check(0,N-1, Integer.parseInt(st.nextToken())))
                bw.write("1" + "\n");
            else
                bw.write("0" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
