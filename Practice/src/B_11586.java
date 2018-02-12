import java.io.*;


public class B_11586 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K;
        String[][] mirror = new String[N][N];
        String temp;


        for(int i=0; i<N; i++){
            temp = br.readLine();
            for(int j=0; j<N; j++){
                mirror[i][j] = temp.substring(j, j+1);
            }
        }
        K = Integer.parseInt(br.readLine());

        switch(K){
            case 1:
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        bw.write(mirror[i][j]);
                    }
                    bw.write("\n");
                }
                break;
            case 2:
                for(int i=0; i<N; i++){
                    for(int j=N-1; j>=0; j--){
                        bw.write(mirror[i][j]);
                    }
                    bw.write("\n");
                }
                break;
            case 3:
                for(int i=N-1; i>=0; i--){
                    for(int j=0; j<N; j++){
                        bw.write(mirror[i][j]);
                    }
                    bw.write("\n");
                }
                break;

        }
        bw.flush();
        bw.close();
        br.close();
    }

}
