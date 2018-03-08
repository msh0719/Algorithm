package SWExpert;

import java.util.ArrayList;
import java.util.Scanner;

public class D4_3289 {

    static int n, m;
    static int cal, a, b;
    static int[] Root;
    static int[] Ele;

    public static void init(){
        for(int i=0; i<= n; i++){
            Root[i] = i;
            Ele[i] = 0;
        }
    }

    public static int Find_Root(int x){
        if(Root[x] == x)
            return x;
        else
            return Find_Root(Root[x]);

    }

    public static void union(int a, int b){
        a = Find_Root(a);
        b = Find_Root(b);

        if(Ele[a] < Ele[b])
            Root[a] = b;
        else {
            Root[b] = a;
            if(Ele[a] == Ele[b])
                Ele[a]++;
        }
    }
    public static boolean Check(int a, int b){
        a = Find_Root(a);
        b = Find_Root(b);

        if( a == b)
            return true;
        else
            return false;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();


        for(int tc = 0; tc < T; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();

            Root = new int[n+1];
            Ele = new int[n+1];

            ArrayList<Integer> result = new ArrayList<>();
            init();

            for(int i=0; i<m; i++){
                cal = sc.nextInt();
                a = sc.nextInt();
                b = sc.nextInt();

                if(cal == 0)
                    union(a, b);
                else{
                    if(Check(a,b))
                        result.add(1);
                    else
                        result.add(0);
                }
            }

            System.out.print("#" + (tc+1) + " ");
            for(int i=0; i<result.size(); i++)
                System.out.print(result.get(i));
            System.out.println();

        }
    }
}
