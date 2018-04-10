package BaekJoon;

import java.io.*;
import java.util.*;

/**
 * 백준 9328 열쇠
 */

class Man{
    int x;
    int y;

    Man(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class B_9328 {
    static int H, W, result;
    static char[][] map;
    static boolean[][] visit;
    static ArrayList<Character> key;
    static Queue<Man> q;
    static ArrayList<Man> door;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void bfs(){
        while(!q.isEmpty()) {
            Man man = q.poll();
            int x = man.x;
            int y = man.y;
            if (map[x][y] == '$')
                result++;

            if(Character.isUpperCase(map[x][y])){//문이라면
                if(key.contains(Character.toLowerCase(map[x][y]))){//열쇠가 있다면
                    map[x][y] = '.';
                    q.add(new Man(x,y));
                    continue;
                }else{ //열쇠가 없다면
                    door.add(new Man(x,y));
                    continue;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX < 0 || nextX >= H || nextY < 0 || nextY>= W)
                    continue;
                if(map[nextX][nextY]=='*' || visit[nextX][nextY])
                    continue;

                if(Character.isLowerCase(map[nextX][nextY])){
                    key.add(map[nextX][nextY]);//키 획득

                    for(Man man1 : door){ //이전까지 방문했던 문 목록
                        if(Character.toUpperCase(map[nextX][nextY])==map[man1.x][man1.y]){ //열쇠를 얻었다면
                            q.add(new Man(man1.x,man1.y));
                        }
                    }
                }
                visit[nextX][nextY] = true;
                q.add(new Man(nextX, nextY));

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            visit = new boolean[H][W];
            q = new LinkedList<>();
            key = new ArrayList<>();
            door = new ArrayList<>();
            result = 0;
            for(int i=0; i<H; i++){
                String temp = br.readLine();
                for(int j=0; j<W; j++){
                    map[i][j] = temp.charAt(j);
                    if(i==0 || i==H-1 || j==0 || j==W-1){ //가장 자리가 벽이 아니라면 큐에 추가
                        if(map[i][j] != '*'){
                            visit[i][j] = true;
                            q.offer(new Man(i, j));
                        }
                    }
                }
            }

            String temp = br.readLine();
            if(!temp.equals("0")) {
                for (int i = 0; i < temp.length(); i++)
                    key.add(temp.charAt(i));
            }

            bfs();
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
