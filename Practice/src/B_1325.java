import java.util.Scanner;

class Gen{
    int x;
    int y;
    boolean visited;
}

public class B_1325 {

    public static int n ;
    public static  int m;
    public static Gen[] gen;
    public static int result[];
    public static int link;
    public static int max  = 0;

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            n = sc.nextInt();
            m = sc.nextInt();

            gen = new Gen[m];
            result = new int[n+1];

            for(int i=0; i<m; i++){
                gen[i] = new Gen();
                gen[i].x = sc.nextInt();
                gen[i].y = sc.nextInt();
                gen[i].visited = true;
            }
            for(int i=1; i<=n; i++){
                result[i] = com(i);
                if(max < result[i]){
                    max = result[i];
                }
                link = 0;
            }
            for(int i=1; i<=n; i++){
                if(result[i] == max){
                    System.out.print(i + " ");
                }
            }
    }
    public static int com(int x){
        for(int i=0; i<m; i++){
            if(x == gen[i].y && gen[i].visited){
                gen[i].visited = false;
                link++;
                com(gen[i].x);
            }
        }
        return link;
    }
}

