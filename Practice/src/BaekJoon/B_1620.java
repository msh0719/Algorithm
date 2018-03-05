package BaekJoon;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class B_1620 {
    public static void main(String[] args) throws IOException {

        Scanner  sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        int M = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        String[] pok;
        String temp;

        pok = new String[N];

        for(int i=0; i<N; i++){
            temp = sc.next();
            map.put(temp, i+1);
            pok[i] = temp;
        }
        for(int i=0; i<M; i++){
            if(sc.hasNextInt()){
                bw.write(pok[sc.nextInt()-1] + "\n");
            }
            else{
                bw.write(map.get(sc.next()) + "\n");
            }
        }
        bw.flush();
        bw.close();

    }

}


