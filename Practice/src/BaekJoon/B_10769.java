package BaekJoon;

import java.io.*;
import java.util.ArrayList;

/**
 * 백준 10769 행복한지 슬픈지
 */


public class B_10769 {

    static String s;
    static ArrayList<Integer> startIndex = new ArrayList<>();
    static int happy, sad;

    public static void check(int index){
        if(s.substring(index+1, index+2).equals("-")){
            if(s.substring(index+2, index+3).equals(")"))
                happy++;
            else if(s.substring(index+2, index+3).equals("("))
                sad++;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine();

        happy = 0;
        sad = 0;
        for(int i=0; i<s.length(); i++){
            if(s.substring(i, i+1).equals(":"))
                startIndex.add(i);
        }

        for(int i=0; i<startIndex.size(); i++){
            check(startIndex.get(i));
        }
        if(sad == 0 && happy == 0)
            bw.write("none" + "\n");
        else if(happy == sad)
            bw.write("unsure" + "\n");
        else if(happy > sad)
            bw.write("happy" + "\n");
        else
            bw.write("sad" + "\n");


        bw.flush();
        bw.close();
        br.close();

    }
}


//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.regex.Matcher;
//        import java.util.regex.Pattern;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException{
//        // TODO Auto-generated method stub
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        Pattern happy =Pattern.compile(":-\\)");
//        Pattern sad =Pattern.compile(":-\\(");
//        Matcher matcher1 = happy.matcher(str);
//        Matcher matcher2 = sad.matcher(str);
//        int h_count=0;
//        int s_count=0;
//        while(matcher1.find()){
//            h_count++;
//        }
//        while(matcher2.find()){
//            s_count++;
//        }
//
//        if(h_count==0 && s_count==0){
//            System.out.println("none");
//        }else if(h_count==s_count){
//            System.out.println("unsure");
//        }else if(h_count>s_count){
//            System.out.println("happy");
//        }else if(h_count<s_count){
//            System.out.println("sad");
//        }
//
//    }
//
//}
