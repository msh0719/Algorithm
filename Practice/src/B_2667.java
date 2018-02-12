import java.util.*;

public class B_2667 {

    public static int n;
    public static int[][] block;
    public static int[][] visited;
    public static int count;

    public static void main(String[] args) {

       ArrayList<Integer> result = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        block = new int[n][n];
        visited = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                block[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(block[i][j] == 1 && visited[i][j] == 0){
                    count = 0;
                    result.add(dfs(i, j));
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }

    }
    public static int dfs(int x, int y){
        //오른쪽
        if(y+1 < n && block[x][y+1] == 1 && visited[x][y+1] == 0 ){
            visited[x][y+1] = 1;
            count++;
            dfs(x, y+1);
        }
        //아래로
         if( x+1 < n && block[x+1][y] == 1 && visited[x+1][y] == 0){
            visited[x+1][y] = 1;
            count++;
            dfs(x+1, y);
        }
        //위로
        if( x-1 >= 0 && block[x-1][y] == 1 && visited[x-1][y] == 0  ){
            visited[x-1][y] = 1;
            count++;
            dfs(x-1,y);
        }
        //왼쪽
        if( y-1 >= 0 && block[x][y-1] == 1 && visited[x][y-1] == 0 ) {
            visited[x][y-1] = 1;
            count++;
            dfs(x,y-1);
        }
        return count;
    }
}
