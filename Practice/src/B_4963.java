import java.util.Scanner;

public class B_4963 {

    static int W, H;
    static int[][] map = new int[51][51];
    static int[] dx = {1, -1, 1, -1, 0, 0, 1, -1}; // 오대위, 왼대아래, 오대아래, 왼대위 위, 아래, 오, 왼
    static int[] dy = {1, -1,-1, 1, -1, 1, 0, 0};
    static int island = 0;

    public static void check(int x, int y){
        map[x][y] = 0;

        for(int i=0; i<8; i++){
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if(moveX >= 0 && moveY >= 0 && moveX < H && moveY < W && map[moveX][moveY] == 1){
                check(moveX, moveY);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(;;){
            W = sc.nextInt();
            H = sc.nextInt();

            island = 0;
            if( W == 0 && H ==0)
                break;

            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(map[i][j] == 1){ // 땅이라면
                        island++;
                        check(i, j);
                    }
                }
            }
            System.out.println(island);
        }
    }
}
