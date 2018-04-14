package Test;


import java.util.Scanner;

public class OverloadTest {

    public static void main(String[] argv) {


        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[5][5];


        for(int i=0; i<5; i++){
            String str = sc.next();
            for(int j=0; j<5; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }



    }
}



//
//        Collections.sort(num, new Comparator<XY>(){
//            @Override
//            public int compare(XY o1, XY o2){
//                if(o1.x>o2.x){
//                    return 1;
//                }else if(o1.x<o2.x){
//                    return -1;
//                }
//                else{
//                    if ( o1.y > o2.y ){
//                        return 1;
//                    }
//                    else if (o1.y < o2.y ){
//                        return -1;
//                    }
//                    else {
//                        return 0;
//                    }
//                }
//            }
//        });