package BaekJoon;

import java.io.*;
        import java.util.ArrayList;

public class B_9933 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i<N; i++){
            String temp = br.readLine();
            String reverse = new StringBuffer(temp).reverse().toString();
            if(temp.equals(reverse) || list.contains(reverse)){
                bw.write(temp.length() + " " + temp.charAt(temp.length()/2) + "\n");
            }
            else
                list.add(temp);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

