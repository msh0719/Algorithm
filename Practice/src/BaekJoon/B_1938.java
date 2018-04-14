package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 1938 통나무 옮기기
 */

class Tree{
    int x;
    int y;
    int dir;
    int num;

    Tree(int x, int y, int dir, int num){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.num = num;
    }
}

public class B_1938 {

    static int N;
    static int bcnt, ecnt, treeNum = 0, eNum = 0, result = Integer.MAX_VALUE;
    static String[][] map;
    static boolean[][][] visit;
    static int[] dx = {-1, 1, 0, 0}; //상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static Queue<Tree> q = new LinkedList<>();
    static Tree etree;

    public static void bfs(){
        while(!q.isEmpty()){
            Tree tree = q.poll();

            int mx = tree.x;
            int my = tree.y;
            int dir = tree.dir;
            int num = tree.num;

            if(mx == etree.x && my==etree.y && dir == etree.dir) {
                result = Math.min(result, num);
            }

            for(int i=0; i<4; i++){
                int nmx = mx + dx[i];
                int nmy = my + dy[i];

                if(!possible(nmx, nmy))
                    continue;
                if(dir==1){ // 통나무 수직
                    if(!possible(nmx-1, nmy) || !possible(nmx+1, nmy))
                        continue;
                    if(visit[dir][nmx][nmy])
                        continue;

                    q.offer(new Tree(nmx, nmy, dir, num+1));
                    visit[dir][nmx][nmy] = true;
                }

                else if(dir == 2) { //통나무 수평
                    if(!possible(nmx, nmy - 1) || !possible(nmx, nmy + 1))
                        continue;
                    if(visit[dir][nmx][nmy])
                        continue;

                    q.offer(new Tree(nmx, nmy, dir, num+1));
                    visit[dir][nmx][nmy] = true;
                }
            }
            if(!nearby(mx, my))
                continue;

            int temp = (int) Math.pow(-1, dir);
            if(visit[dir-temp][mx][my])
                continue;

            q.offer(new Tree(mx, my, dir-temp, num+1));
            visit[dir][mx][my] = true;
        }
    }

    public static boolean nearby(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N)
            return false;
        if(x-1 < 0 || x+1 >= N || y-1 < 0 || y+1 >= N)
            return false;
        if(map[x][y].equals("1") || map[x-1][y].equals("1") || map[x+1][y].equals("1") || map[x][y-1].equals("1") ||
                map[x][y+1].equals("1") || map[x-1][y-1].equals("1") || map[x+1][y+1].equals("1") || map[x-1][y+1].equals("1") ||
                map[x+1][y-1].equals("1"))
            return false;

        return true;
    }

    public static boolean possible(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N || map[x][y].equals("1"))
            return false;
        else
            return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visit = new boolean[3][N][N];

        for(int i=0; i<N; i++){
            bcnt = 0;
            ecnt = 0;
            String temp = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = temp.substring(j, j+1);
                if(map[i][j].equals("B")) {
                    bcnt++;
                    treeNum++;
                    if(treeNum==2){
                        if(bcnt==2) {
                            q.offer(new Tree(i, j, 2, 0));
                            visit[2][i][j] = true;
                        }
                        else {
                            q.offer(new Tree(i, j, 1, 0));
                            visit[1][i][j] = true;
                        }

                    }
                }
                else if(map[i][j].equals("E")) {
                    ecnt++;
                    eNum++;
                    if(eNum==2){
                        if(ecnt==2) {
                           etree = new Tree(i, j, 2, 0);
                        }
                        else {
                            etree = new Tree(i, j, 1, 0);
                        }

                    }
                }
            }
        }
        bfs();
        if(result != Integer.MAX_VALUE)
            bw.write(result + "\n");
        else
            bw.write(0 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
