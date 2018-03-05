package BaekJoon;

import java.util.Scanner;

public class B_2661 {

    public static boolean stop = false;

    public static boolean isPossible(String C) {

        int len = C.length();
        int half = len / 2;
        int start = len - 1;
        int current = len;

        for (int i = 1; i <= half; i++) {
            if (C.substring(start - i, len - i).equals(C.substring(current - i, len))) {
                return false;
            }
            start--;
        }
        return true;
    }
    public static void add(int N, int len, String C){

        if(stop){
            return;
        }

        if(len == N) {
            stop = true;
            System.out.println(C);
        }

        else{
            for(int i=1; i<=3; i++){
                if(isPossible(C + i)){
                    add(N,len+1, C+i);
                }
            }
        }
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        add(N, 1, "1");

    }
}
