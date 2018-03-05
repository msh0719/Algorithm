package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class B_4383 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int[] arr;
        int temp;
        ArrayList<Integer> list = new ArrayList<>();


        while (sc.hasNextInt()) {
            int N = sc.nextInt();

            arr = new int[N];
            arr[0] = sc.nextInt();
            for (int i = 1; i < N; i++) {
                arr[i] = sc.nextInt();
                temp = Math.abs(arr[i - 1] - arr[i]);
                if (temp < N && !list.contains(temp))
                    list.add(temp);
            }
            if (list.size() == N - 1)
                System.out.println("Jolly");
            else
                System.out.println("Not jolly");

            list.clear();

        }
    }
}

