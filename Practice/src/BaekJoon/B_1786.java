package BaekJoon;

import java.io.*;
import java.util.ArrayList;

/**
 * 백준 1786 찾기
 * KMP
 */

public class B_1786 {
    static String T, P;

    public static ArrayList kmp(String str, String pattern){

        ArrayList<Integer> list = new ArrayList<>();
        int[] pi = getPi(pattern);
        int n = str.length();
        int m = pattern.length();
        int j = 0;
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();

        for(int i=0; i<n; i++){
            while(j>0 && s[i] != p[j]){
                j = pi[j-1];
            }
            if(s[i] == p[j]){
                if(j == m-1){
                    list.add(i-m+1);
                    j = pi[j];
                }
                else
                    j++;
            }
        }
        return list;
    }
    public static int[] getPi(String pattern){
        int m = pattern.length();
        int j = 0;
        char[] p = new char[m];
        int[] pi = new int[m];

        p = pattern.toCharArray();
        for(int i=1; i<m; i++){
            while(j>0 && p[i] != p[j]){
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
        ArrayList<Integer> result = new ArrayList<>();

        T = br.readLine();
        P = br.readLine();

        result = kmp(T, P);
        bw.write(result.size() + "\n");
        for(int i=0; i<result.size(); i++){
            bw.write(result.get(i)+1 + " ");
        }
        bw.flush();
        bw.close();
        br.close();


    }

}
