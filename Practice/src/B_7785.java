import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
    Set<String> set = new HashSet<>();
         String [] arr = set.toArray(new String[set.size()]);
        Arrays.sort(arr);
 */
public class B_7785 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] stArr = new String[2];

        Set<String> set = new HashSet<>();

        for(int i=0; i<N; i++){
            stArr = br.readLine().split(" ");
            if(stArr[1].equals("enter")){
                set.add(stArr[0]);
            }
            else
                set.remove(stArr[0]);
        }
        String [] arr = set.toArray(new String[set.size()]);
        Arrays.sort(arr);

        for(int i=arr.length-1; i>=0; --i){
            System.out.println(arr[i]);
        }
    }
}
