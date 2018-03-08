package SWExpert;

import java.util.*;
class S_2105{
    static int check(int b, int c, int d, int e, int n,int[][]map) {
        if(b+d>=n||c+d>=n||b+d+e>=n||c+d-e<0||c+d-e>=n||b+e>=n||c-e<0) {
            return -1;
        }
        else {
            boolean[]eaten=new boolean[101];
            eaten[map[b][c]]=true;
            for(int z=1;z<=d;z++) {
                if(eaten[map[b+z][c+z]]) {
                    return -1;
                }
                else {
                    eaten[map[b+z][c+z]]=true;
                }
            }
            for(int z=1;z<=e;z++) {
                if(eaten[map[b+d+z][c+d-z]]) {
                    return -1;
                }
                else {
                    eaten[map[b+d+z][c+d-z]]=true;
                }
            }
            for(int z=1;z<=d;z++) {
                if(eaten[map[b+d+e-z][c+d-e-z]]) {
                    return -1;
                }
                else {
                    eaten[map[b+d+e-z][c+d-e-z]]=true;
                }
            }
            for(int z=1;z<e;z++) {
                if(eaten[map[b+e-z][c-e+z]]) {
                    return -1;
                }
                else {
                    eaten[map[b+e-z][c-e+z]]=true;
                }
            }
            return 2*(d+e);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int a=1;a<=t;a++) {
            System.out.print("#"+a+" ");
            int n=sc.nextInt();
            int[][]map=new int[n][n];
            int answer=-1;
            for(int b=0;b<n;b++) {
                for(int c=0;c<n;c++) {
                    map[b][c]=sc.nextInt();
                }
            }
            for(int b=0;b<n;b++) {
                for(int c=0;c<n;c++) {
                    for(int d=1;d<n;d++) {
                        for(int e=1;e<n;e++) {
                            int newanswer=check(b,c,d,e,n,map);
                            answer=Math.max(answer, newanswer);
                        }
                    }
                }
            }
            System.out.println(answer);
        }
        sc.close();
    }
}


//import java.util.ArrayList;
//
//public class SWExpert.S_2105 {
//    public static ArrayList<Integer> alist = new ArrayList<>();
//    public static int arrCnt = 0;
//    public static int visited[][] = new int[7][7];
//    public static int result[][] = new int[4][5];
//    public static int path[] = new int[100];
//    public static int N = 5;
//    public static int leftC1 = 0, leftC2 = 0, rightC1 = 0, rightC2 = 0;
//    public static int leftDown = 1, rightDown = 1, rightUp = 1, leftUp = 1;
//    public static int sig = 1, max = 1;
//
////    public static int arr[][] =
////            {       {1, 2, 3, 4, 5},
////                    {6, 7, 8, 9, 10},
////                    {1, 2, 6, 3, 5},
////                    {6, 5, 7, 9, 10},
////                    {1, 2, 3, 4, 5}
////            };//4
//        public static int arr[][] =
//            {       {1,    2,   3,    4,   5},
//                    {6,    7,   8,    9,   10},
//                    {7, 12, 13, 14, 15},
//                    {16, 17, 18, 19, 20},
//                    {21, 22, 23, 24, 25}
//            };//4
//
//    public static void reset() {
//        leftC1 = 0;
//        leftC2 = 0;
//        rightC1 = 0;
//        rightC2 = 0;
//        leftDown = 1;
//        rightDown = 1;
//        rightUp = 1;
//        leftUp = 1;
//        arrCnt = 1;
//        alist.clear();
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                visited[i][j] = 0;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        for (int i = 0; i < N - 2; i++) {
//            for (int j = 1; j < N - 1; j++) {
//                max=1;
//                reset();
//                alist.add(arr[i][j]);
//                visited[i][j]=1;
//                System.out.print(arr[i][j] + "-->");
//                move(i, j);
//                System.out.println();
//                System.out.println();
//             System.out.println(max);
//            }
//        }
//
//
////            System.out.print(arr[2][3] + "-->");
////            move(2, 3);
////            System.out.println();
////            System.out.println(max);
//
//    }
//
//    public static boolean isPossible(int i, int j) {
//        if (i >= 0 && i < N && j >= 0 && j < N &&  alist.indexOf(arr[i][j]) == -1) {
//            return true;
//        }
//        return false;
//    }
//
//    public static void move(int i, int j) {
//
//      if(leftDown == 1) {
//          for (int k = 1; k < N; k++) {
//              if (!isPossible(i + k, j - k)) {
//                  leftDown = 0;
//                  //System.out.print( arr[i][j] + "-->" );
//                  move(i,j);
//              }
//              else if(visited[i+k][j-k] == 1){
//                  return;
//              }
//              else {
//                      leftC1++;
//                      max++;
//                      System.out.print(arr[i + k][j - k] + "LD -->");
//                      alist.add(arr[i + k][j - k]);
//                      visited[i + k][j - k] = 1;
//                      //leftDown = 0;
//                      move(i + k, j - k);
//                  }
//              }
//          }
//      else if(rightDown == 1) {
//            for (int k = 1; k < N; k++) {
//                if (!isPossible(i + k, j+k)) {
//                   // System.out.print( arr[i][j] +  "RDTT-->" );
//                    rightDown=0;
//                    move(i,j);
//                }
//                else if(visited[i+k][j+k] == 1){
//                    return ;
//                }
//                else {
//                    System.out.print( arr[i+k][j+k] + "RD-->") ;
//                    max++;
//                    alist.add(arr[i + k][j+k]);
//                    visited[i+k][j+k] = 1;
//                    rightC1++;
//
//                    move(i+k, j+k);
//                }
//            }
//          rightDown=0;
//
//        }
//        else if(rightUp == 1) {
//            for (int k = 1; k < N; k++) {
//                if (!isPossible(i -k, j +k) ) {
//                    rightUp = 0;
//                    move(i, j);
//                }
//                else if(visited[i-k][j+k] == 1){
//                    return;
//                }
//                else if( leftC2 < leftC1 ) {
//                    System.out.print( arr[i-k][j+k] + "RU-->" );
//                    leftC2++;
//                    max++;
//                    alist.add(arr[i - k][j + k]);
//                    visited[i-k][j+k] = 1;
//                    move(i-k,j+k);
//                }
//            }
//          rightUp = 0;
//        }
//        else if(leftUp == 1) {
//            for (int k = 1; k < N; k++) {
//                if (!isPossible(i - k, j - k) ) {
//                    leftUp = 0;
//                    //System.out.print( arr[i][j] + "-->" );
//                    move(i, j);
//                }
//                else if(visited[i-k][j-k] == 1){
//                    return;
//                }
//                else if( rightC2 < rightC1-1) {
//                    System.out.print( arr[i-k][j-k] + "-->" );
//                    rightC2++;
//                    max++;
//                    visited[i-k][j-k] = 1;
//                    alist.add(arr[i - k][j - k]);
//                    move(i-k,j-k);
//                }
//
//            }
//          leftUp = 0;
//        }
//    }
//}
//
//
