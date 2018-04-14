package BaekJoon;

import java.util.Scanner;


public class B_14889 {

    static int N;
    static int[][] arr = new int[20][20];
    static int temp = 0;

    static int min = Integer.MAX_VALUE;

    public static void DivTeam(int index, int start_t, int link_t, int start_num, int link_num, int start_ab, int link_ab){

        if(start_num + link_num == N){
            min = Math.min(min, Math.abs(start_ab - link_ab));
        }
        //start 팀
        if(start_num < (N/2)) {
            temp = 0;
            for (int i = 0; i < N; i++) {
                if((start_t & (1<<i)) == 0) {
                    temp += (arr[index][i] + arr[i][index]);
                }
            }
            DivTeam(index+1, (start_t | 1 << index), link_t, start_num+1, link_num, start_ab+temp, link_ab);
        }
        //link 팀
        if(link_num < (N/2)){
            temp = 0;
            for(int i=0; i<N; i++){
                if((link_t & (1<<i)) == 0){
                    link_ab += (arr[index][i] + arr[i][index]);
                }
            }
            DivTeam(index+1, start_t, (link_t | 1 << index), start_num, link_num+1, start_ab, link_ab+temp);
        }


    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        DivTeam(0,0,0,0,0,0,0);

        System.out.println(min);
    }
}