import java.util.Scanner;

public class D3_2805
{
    public static int tc;
    public static int num;
    public static int[] result;
    public static String benefit;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        tc = sc.nextInt();

        result = new int[tc];
        for(int i = 0; i<tc; i++){

            num =  sc.nextInt();

           int max = num / 2;
            for(int j = 0; j<num ; j++){
                benefit = sc.next();
                for(int k=0; k<num ; k++){
                    if(Math.abs(j-max) + Math.abs(k-max) <= max) {
                        result[i] += Integer.parseInt(benefit.substring(k, k + 1));
                    }
                }
            }
        }
        for(int i=0; i<tc; i++){
            System.out.println("#" + (i+1) + " "+ result[i]);
        }

    }
}
