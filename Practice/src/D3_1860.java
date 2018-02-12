import java.util.Scanner;

public class D3_1860 {

    public static int n,m,k,sec;
    public static int [] client;
    public static int bread =0;
    public static int temp = 0;
    public static int ok ;
    public static int [] result ;

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int tk = sc.nextInt();

        result = new int[tk];

        for(int j =0; j<tk; j++) {
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();
            ok = 1;
            bread = 0;
            client = new int[11112];

            for (int i = 0; i < n; i++) {
                    sec = sc.nextInt();
                    client[sec]++;
            }
            for (int i = 0; i < 11112; i++) {
                    if (client[i] != 0 && k !=0 && m != 0) {
                        if(i < m) {
                            ok = 0;
                            break;
                        }
                        else {
                            bread += client[i];
                            temp = (i / m) * k - bread;
                            if (temp < 0) {
                                ok = 0;
                                break;
                            }
                        }
                    }
            }
            result[j] = ok;
         }

        for(int i=0; i<tk; i++){
            if(result[i] == 1){
                System.out.println("#" + (i+1) + " Possible");
            }
            else if(result[i] == 0)
                System.out.println("#" + (i+1) + " Impossible");
        }

    }
}
