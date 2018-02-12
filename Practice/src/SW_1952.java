import java.util.Scanner;


class Pay{

    public int[]  month = new int[13];
    public int[] dp = new int[13];
    public int[] price = new int[4];

    public int sum(){

        dp[0] = 0;

        for(int i=1; i<=12; i++){
            dp[i] = Math.min(dp[i-1] + price[0] * month[i],  dp[i-1] + price[1]);

            if(i>=3)
                dp[i] = Math.min(dp[i],  dp[i - 3] + price[2]);

            }
        if(dp[12] > price[3])
            return price[3];

         return dp[12];
        }
}

public class SW_1952 {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        Pay pay[];
        int result[];
        int testCase = sc.nextInt();

        result = new int[testCase];
        pay = new Pay[testCase];

        for(int i=0; i<testCase; i++){
                pay[i] = new Pay();
                for(int j=0; j<4; j++){
                    pay[i].price[j] = sc.nextInt();
                }
                 pay[i].month[0]  = 0;
                for(int j=1; j<=12; j++){
                    pay[i].month[j] = sc.nextInt();
                }
                result[i] = pay[i].sum();
        }

        for(int i=0; i<testCase; i++){
            System.out.println("#" + (i+1) + " " + result[i]);
        }

    }
}
