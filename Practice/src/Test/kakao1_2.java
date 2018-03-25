package Test;

import java.io.*;

public class kakao1_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double[] score = new double[3];
        int cnt = 0;

        String str = br.readLine();

        for(int i=0; i<str.length(); i++){
            String temp = str.substring(i, i+1);

                switch (temp){
                    case "1":
                        score[cnt] = 1;
                        cnt++;
                        break;
                    case "2":
                        score[cnt] = 2;
                        cnt++;
                        break;
                    case "3":
                        score[cnt] = 3;
                        cnt++;
                        break;
                    case "D":
                        score[cnt] = Math.pow(score[cnt], 2);
                        cnt++;
                        break;
                    case "T":
                    case "*":
                    case "#":
                }
            }
        }
}
