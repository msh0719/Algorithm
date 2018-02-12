import java.io.*;

public class B_1065 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int x, y, z;

        if( N < 100)
            bw.write(N + "\n");

        else{
            result += 99;
            for(int i = 100; i<=N; i++){
                x = (i % 100) % 10; // 일의 자리
                y = (i % 100) / 10; // 십의 자리
                z = i / 100; // 백의 자리

                if( (x-y) == (y-z))
                    result++;
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
