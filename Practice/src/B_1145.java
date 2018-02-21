import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] arr = new int[5];
        int cnt, temp, min;

        min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
        }
        temp = min;
        while(true){
            cnt = 0;
            for(int i=0; i<5; i++){
                if( (temp % arr[i]) == 0) {
                    cnt++;
                }
            }
            if(cnt >= 3)
                break;
            temp++;
        }
        bw.write(temp + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
