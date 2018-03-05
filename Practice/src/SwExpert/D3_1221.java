package SwExpert;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D3_1221 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        String t;

        HashMap<String, Integer> dict = new HashMap<>();
        dict.put("ZRO", 0); dict.put("ONE", 1); dict.put("TWO", 2); dict.put("THR", 3); dict.put("FOR", 4);
        dict.put("FIV", 5); dict.put("SIX", 6); dict.put("SVN", 7); dict.put("EGT", 8); dict.put("NIN", 9);

        HashMap<Integer, String> dict2 = new HashMap<>();
        dict2.put(0, "ZRO"); dict2.put(1, "ONE"); dict2.put(2, "TWO"); dict2.put(3, "THR"); dict2.put(4, "FOR");
        dict2.put(5, "FIV"); dict2.put(6, "SIX"); dict2.put(7, "SVN"); dict2.put(8, "EGT"); dict2.put(9, "NIN");

        for(int i=0; i<tc; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            t = st1.nextToken();
            int N = Integer.parseInt(st1.nextToken());
            int[] Sum = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                 Sum[dict.get(st.nextToken())]++;
            }


            System.out.print("#" + (i+1) + " ");
            for(int j=0; j<10; j++){
                if(Sum[j] != 0) {
                    for (int k = 0; k < Sum[j]; k++) {
                        System.out.print(dict2.get(j) + " ");
                    }
                }
            }
            System.out.println();
        }

    }
}
