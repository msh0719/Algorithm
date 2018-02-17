//import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class B_4383 {
//
//    public static void main(String[] args) throws IOException {
//
//        Scanner sc = new Scanner(System.in);
//
//        int[] arr;
//        int temp;
//        ArrayList<Integer> list = new ArrayList<>();
//
//
//        while (sc.hasNextInt()) {
//            int N = sc.nextInt();
//
//            arr = new int[N];
//            arr[0] = sc.nextInt();
//            for (int i = 1; i < N; i++) {
//                arr[i] = sc.nextInt();
//                temp = Math.abs(arr[i - 1] - arr[i]);
//                if (temp < N && !list.contains(temp))
//                    list.add(temp);
//            }
//            if (list.size() == N - 1)
//                System.out.println("Jolly");
//            else
//                System.out.println("Not jolly");
//
//            list.clear();
//
//        }
//    }
//}

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_4383 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String st1;
        int[] arr;
        int temp;
        ArrayList<Integer> list = new ArrayList<>();

        for(;;){
            st1 = br.readLine();

            if(st1.isEmpty())
                break;

            st = new StringTokenizer(st1);
            int N = Integer.parseInt(st.nextToken());

            arr = new int[N];
            arr[0] = Integer.parseInt(st.nextToken());
            for (int i = 1; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                temp = Math.abs(arr[i - 1] - arr[i]);
                if (temp < N && !list.contains(temp))
                    list.add(temp);
            }
            if (list.size() == N - 1)
                bw.write("Jolly" + "\n");
            else
                bw.write("Not jolly" + "\n");

            list.clear();
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

