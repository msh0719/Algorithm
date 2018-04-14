package SWExpert;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SW Expert 모의 SW 역량테스트 점심식사
 * 한 번 더 풀어보기
 */

class People{
    int x;
    int y;
    int type;
    int len;
    boolean go;

    People(int x, int y, int type, int len, boolean go){
        this.x = x;
        this.y = y;
        this.type = type;
        this.len = len;
        this.go = go;
    }
}

class Stairs{
    int x;
    int y;
    int depth;

    Stairs(int x, int y, int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

public class SW_2383_1 {

    static int N;
    static int[][] map;
    static int time, result, min;
    static ArrayList<People> people;
    static Stairs[] stairs;

    public static void Move() {
        for (int cnt = 0; cnt < (1 << people.size()); cnt++) {
            for (int j = 0; j < people.size(); j++) {
                if ((cnt & (1 << j)) == 0) { // 1번 출구
                    setPeople(people.get(j), 0);
                }
                else { // 2번 출구
                    setPeople(people.get(j), 1);
                }
            }
            Queue<Integer> Entrance1 = new LinkedList<>();
            Queue<Integer> Entrance2 = new LinkedList<>();
            init();
            time = 0;
            int temp = 0;
            while(true){
                time++; // 시간 늘리기
                for(People p: people){
                    if(p.type == 0 && !p.go){ // 1번 계단
                        if(p.len == 0){
                            if(Entrance1.size() >= 3){
                                Entrance1.offer(stairs[0].depth); // 넣어만 놓고 이동 못함(대기 시간 x)
                            }
                            else
                                Entrance1.offer(stairs[0].depth+1);  // 다음 초 부터 이동해야하니까 +1 해서 저장
                            temp++;
                            p.go = true;
                        }
                        else
                            p.len--;
                    }
                    else if(p.type==1 && !p.go){
                        if(p.len==0){
                            if(Entrance2.size() >= 3)
                                Entrance2.offer(stairs[1].depth);
                            else
                                Entrance2.offer(stairs[1].depth+1);
                            temp++;
                            p.go = true;
                        }
                        else
                            p.len--;
                    }
                }
                if(!Entrance1.isEmpty()){
                    int size = Entrance1.size();
                    for(int i=0; i<size; i++){
                        int dis = Entrance1.poll();
                        if(i < 3)
                            dis = dis - 1;
                        if(dis > 0)
                            Entrance1.offer(dis);
                    }
                }
                if(!Entrance2.isEmpty()){
                    int size = Entrance2.size();
                    for(int i=0; i<size; i++){
                        int dis = Entrance2.poll();
                        if(i < 3)
                            dis = dis - 1;
                        if(dis > 0)
                            Entrance2.offer(dis);
                    }
                }
                if(Entrance1.isEmpty() && Entrance2.isEmpty() && temp==people.size()) {
                    break;
                }
            }
            min = Math.min(min, time);
        }
    }
    public static void init(){
        for(int i=0; i<people.size(); i++)
            people.get(i).go = false;
    }

    public static void setPeople(People people, int num){
        people.len = Math.abs(people.x - stairs[num].x) + Math.abs(people.y - stairs[num].y);
        people.type = num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            stairs = new Stairs[2];
            people = new ArrayList<>();

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==1)
                        people.add(new People(i,j, 0,0, false));
                    else if(map[i][j] > 1){
                        if(stairs[0] == null){
                            stairs[0] = new Stairs(i, j, map[i][j]);
                        }
                        else{
                            stairs[1] = new Stairs(i, j, map[i][j]);
                        }
                    }
                }
            }
            //입력 단계 끝
            min = Integer.MAX_VALUE;
            Move();
            bw.write("#"+(tc+1)+" " + min + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
