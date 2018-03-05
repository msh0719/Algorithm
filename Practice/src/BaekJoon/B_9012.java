package BaekJoon;

import java.io.*;
import java.util.Stack;

public class B_9012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str, temp;
        String result;
        Stack<String> stack;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            result = "YES";
            str = br.readLine();
            stack = new Stack<>();
            for(int i=0; i<str.length(); i++){
                temp = str.substring(i, i+1);
                if(temp.equals("("))
                    stack.push("(");
                else if(temp.equals(")") && stack.empty()){
                    result = "NO";
                    break;
                }
                else
                    stack.pop();
            }
            if(stack.empty() && result.equals("YES"))
                bw.write(result + "\n");

            else if(!stack.empty() || result.equals("NO")) {
                result = "NO";
                bw.write(result + "\n");
            }


        }
        bw.flush();
        bw.close();
        br.close();
    }
}
