import java.io.*;
import java.util.StringTokenizer;

public class brother {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(i == j){
                    System.out.println(i + " " + j);
                    break;
                }
            }
        }
    }
}
