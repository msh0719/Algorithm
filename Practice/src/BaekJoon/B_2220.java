package BaekJoon;

import java.io.*;

/**
 힙정렬 백준 2220
 **/

public class B_2220 {

    static int[] arr;
    static int N;

    public static void swap(int a, int b){
       int temp;
       temp = arr[a];
       arr[a] = arr[b];
       arr[b] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int temp;

        arr = new int[N+1];
        arr[1] = 1;
        for(int i = 2; i <= N; i++) {
            arr[i] = i;
            swap(i-1, i); // 1이랑 최근 들어온 숫자 swap
            swap(i-1, 1); // 최고힙의 조건에 맞추기 위해서 0번째 있는 값과 최근 들어온 큰 숫자와 swap
            // 최고힙 조건 맞추는 부분
            temp = i-1;
            while((temp/2) > 1){
                swap(temp,temp/2);
                temp = temp/2;
            }
        }
        for(int i=1; i<=N; i++)
            bw.write(arr[i] + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
