package SwExpert;

import java.util.Scanner;
public class D2_1859 {

    public static int N;
    public static int price[];

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        int max = 0;
        long result[] = new long[tc];

        for (int i = 0; i < tc; i++) {
            long money = 0;
            N = sc.nextInt();
            price = new int[N];

            for (int j = 0; j < N; j++) {
                price[j] = sc.nextInt();
            }
            max = Integer.MIN_VALUE;
            for (int j = N - 1; j >= 0; j--) {
                if (price[j] > max) {
                    max = price[j];
                } else {
                    money += (max - price[j]);
                }
            }
            result[i] = money;
        }
        for (int i = 0; i < tc; i++) {
            System.out.println("#" + (i + 1) + " " + result[i]);
        }

    }
}

//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.StringTokenizer;
//
//public class Solution {
//
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int T = Integer.parseInt(br.readLine());
//
//        for (int t = 1; t <= T; t++) {
//            int N = Integer.parseInt(br.readLine());
//            int[] arr = new int[N];
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            for (int i = 0; i < N; i++) {
//                arr[i] = Integer.parseInt(st.nextToken());
//            }
//            long ans = 0;
//
//            int max = arr[arr.length-1];
//            for(int i= arr.length; i>0; i--) {
//                if(arr[i-1] <= max) {
//                    ans += (max-arr[i-1]);
//                } else {
//                    max = arr[i-1];
//                }
//            }
//            sb.append("#" + t + " " + ans +"\n");
//
//        }
//        System.out.print(sb);
//
//    }
//
//}