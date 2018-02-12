import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N, result;
        String name, kind;
        ArrayList<String> kind_c;
        int[] kind_n;

        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());
            kind_n = new int[N];
            kind_c = new ArrayList<>();
            result  = 1;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                name = st.nextToken();
                kind = st.nextToken();

                if(!kind_c.contains(kind)) {
                    kind_c.add(kind);
                    kind_n[kind_c.indexOf(kind)]++;
                }
                else {
                    kind_n[kind_c.indexOf(kind)]++;
                }
            }
            for(int i=0; i<kind_c.size(); i++){
                result *= kind_n[i]+1;
            }


            bw.write(result-1+"\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
