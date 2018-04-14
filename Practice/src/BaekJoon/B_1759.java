package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1759 암호 만들기
 */

public class B_1759 {

    static int L, C;
    static char[] password;
    static ArrayList<String> result = new ArrayList<>();

    public static void DFS(int index, int len, String str){
        if(len==L && possible(str)) {
            result.add(str);
            return;
        }
        if(index==C)
            return;

        String temp = Character.toString(password[index]);
        temp = str.concat(temp);

        DFS(index+1, len+1, temp);
        DFS(index+1, len, str);
    }

    public static boolean possible(String str){
        int a = 0;
        int b = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                a++;
            else
                b++;
        }
        if(a>=1 && b>=2)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        password = new char[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++)
            password[i] = st.nextToken().charAt(0);

        Arrays.sort(password);

        DFS(0,0, "");
        for(int i=0; i<result.size(); i++){
            bw.write(result.get(i) + "\n");
        }


        bw.flush();
        bw.close();
        br.close();

    }
}
