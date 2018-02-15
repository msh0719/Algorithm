import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_2910 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int temp;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> hash = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            temp = Integer.parseInt(st.nextToken());
            if(hash.containsKey(temp)){
                hash.replace(temp, hash.get(temp)+1);
            }else{
                hash.put(temp,1);
            }
        }

        System.out.println(hash);
    }
}
