package BaekJoon;

import java.io.*;

/**
 * 백준 5525 IOIOI
 */

public class B_5525 {

    static int N, M;
    static String S;
    static int cnt;

    public static int kmp(String str, String pattern){

        int[] pi = getPi(pattern);
        int n = str.length();
        int m = pattern.length();
        int j = 0;
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();

        for(int i=0; i<n; i++){
            while (j>0 && s[i] != p[j]){
                j = pi[j-1];
            }
            if(s[i] == p[j]){
                if(j == m-1){
                    cnt++;
//                    list.add(i - m + 1);
                    j = pi[j];
                }
                else{
                    j++;
                }
            }
        }
        return cnt;
    }
    public static int[] getPi(String pattern){
        int m = pattern.length();
        int j = 0;
        char[] p = new char[m];
        int[] pi = new int[m];

        p = pattern.toCharArray();
        for(int i=1; i<m; i++){
            while (j>0 && p[i] != p[j]){
                j = pi[j-1];
            }
            if(p[i] == p[j])
                pi[i] = ++j;
        }
        return pi;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        StringBuilder temp = new StringBuilder("I");

        for(int i=1; i<=N; i++)
            temp.append("OI");

        cnt = 0;
        bw.write(kmp(S, temp.toString()) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
