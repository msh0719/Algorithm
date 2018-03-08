package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 백준 2309 일곱난장이
 */

public class B_2309 {

    static int[] height = new int[9];
    static int result = 0;

    public static void dwarf(int num, int height_sum, int signal){
        if(num == 7 && height_sum==100)
            result = signal;

        if(num < 7) {
            for (int i = 0; i < 9; i++) {
                if ((signal & (1 << i)) == 0) {
                    int temp = height_sum + height[i];
                    if (temp <= 100)
                        dwarf(num + 1, temp, signal | (1 << i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<9; i++){
            height[i] = Integer.parseInt(br.readLine());
        }
        dwarf(0,0,0);

        for(int i=0; i<9; i++){
            if((result&(1<<i)) != 0)
                list.add(height[i]);
        }
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
