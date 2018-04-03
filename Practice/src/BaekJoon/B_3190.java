package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 3190 뱀
 */

class Direction{
    int time;
    String dir;

    Direction(int time, String dir){
        this.time = time;
        this.dir = dir;
    }
}

class Tail{
    int x;
    int y;

    Tail(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class B_3190 {

    static int N, K, L;
    static int[][] map;
    static int[][] snake;
    static int time = -1;
    static int[] dx = {0, 0, 1, -1}; // 오, 왼, 아래, 위
    static int[] dy = {1, -1, 0, 0};
    static Direction[] dir;
    static Queue<Tail> tail = new LinkedList<>();


    public static void move(int x, int y, int head){
        time++;
        for(int i=0; i<L; i++){ // 뱀 머리통 확인
            if(time == dir[i].time){
                if(dir[i].dir.equals("D")){
                    if(head == 0)  //오
                        head = 2;
                    else if(head == 2) //아래 --> 왼쪽
                        head = 1;

                    else if(head == 1) // 왼쪾 --> 위
                        head = 3;
                    else
                        head = 0;

                }
                else if(dir[i].dir.equals("L")){
                    if(head == 1)
                        head = 2;

                    else if(head == 2)
                        head = 0;

                    else if(head ==0)
                        head = 3;

                    else
                        head = 1;
                }
            }
        }

        int nextX = x + dx[head];
        int nextY = y + dy[head];

        if(nextX < 1 || nextX > N || nextY < 1 || nextY > N || snake[nextX][nextY] != 0)
            return;

        else{
            if(map[nextX][nextY] == 2) { // apple
                snake[nextX][nextY] = 1;
                map[nextX][nextY] = 0;
                tail.offer(new Tail(nextX, nextY));
                move(nextX, nextY, head);
            }
            else if(map[nextX][nextY] == 0){ //꼬리 자르기
                tail.offer(new Tail(nextX, nextY));
                if(!tail.isEmpty()) {
                    Tail temp = tail.poll();
                    snake[temp.x][temp.y] = 0;
                }
                snake[nextX][nextY] = 1;
                move(nextX, nextY, head);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        snake = new int[N+1][N+1];

        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2; //2는 사과
        }

        L = Integer.parseInt(br.readLine());
        dir = new Direction[L];
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            dir[i] = new Direction(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        tail.offer(new Tail(1, 1));
        snake[1][1] = 1;
        move(1,1,0);



        bw.write((time+1) + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
