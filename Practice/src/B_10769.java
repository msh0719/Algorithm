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
