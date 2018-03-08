package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class D3_1244 {

    public static int N;
    public static String C;
    public static int len;
    public static int max;
    public static int []arr = new int[6];

    public static void CtoN(String C){
        for(int i=0; i<len; i++){
            arr[i] = Integer.parseInt(C.substring(i, i+1));
        }
    }

    public static int AtoI(int [] arr){
        int temp = 0;
        int x = 1;

        for(int i= len-1; i>=0; i--){
            temp += arr[i] * x;
            x *= 10;
        }
        return temp;
    }

    public static void maxPrice(int num){

        if(num == N){
                if(max < AtoI(arr))
                    max = AtoI(arr);
                return;
        }
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    maxPrice(num+1);
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
            }
        }
    }
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int i=0; i<tc; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = st.nextToken();
            N = Integer.parseInt(st.nextToken());

            int temp = N;
            len = C.length();
            if(N >= len)
                N = len -1;
            max = 0;
            CtoN(C);
            maxPrice(0);
            if((temp - N) % 2 != 0){
                int temp1, temp2;
                temp1 = (max/10) % 10; //10 의자리
                temp2 = max%10; //1의자리
                max = max -  temp1*10-temp2 + temp2*10+temp1;
            }
            System.out.println("#" + (i+1) + " " + max);
        }
    }
}
