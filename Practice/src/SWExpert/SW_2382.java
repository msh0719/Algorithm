package SWExpert;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * SW expert 모의SW 2382 미생물 격리
 */

class Micro implements Comparable<Micro>{
    int x;
    int y;
    int num;
    int dir;

    Micro(int x, int y, int num, int dir){
        this.x = x;
        this.y = y;
        this.num = num;
        this.dir = dir;
    }

    @Override
    public int compareTo(Micro o) {
        if (this.num > o.num) {
            return -1;
        } else if (this.num < o.num) {
            return 1;
        }
        return 0;
    }
    @Override
    public boolean equals(Object o) {
        Micro g = (Micro) o;
        return this.x == g.x && this.y == g.y;
    }
}
public class SW_2382 {

    static int N, M, K, result;
    static LinkedList<Micro> list;
    static int[] dx = {-1, -1, 1, 0, 0}; // null, 상, 하, 좌, 우
    static int[] dy = {-1, 0, 0, -1, 1};

    public static void move(){

        for(Micro micro: list) {
            int x = micro.x;
            int y = micro.y;
            int dir = micro.dir;
            int num = micro.num;

            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            if (nextX == 0 || nextX == N - 1 || nextY == 0 || nextY == N - 1) {
                //약품 구역에 들어올 경우
                micro.x = nextX;
                micro.y = nextY;
                micro.dir = (int) (dir - Math.pow(-1, dir));
                micro.num = num / 2;
            }
            else {
                micro.x = nextX;
                micro.y = nextY;
            }
        }
        for(int i=0; i<list.size(); i++){
            Micro micro = list.get(i);
            if(micro.num == 0) {
                list.remove(micro);
                i--;
            }
        }
    }
    public static void confirm(){
        Collections.sort(list);

        LinkedList<Micro> tempList = new LinkedList<>();
        tempList.addAll(list);
        list.clear();

        int size = tempList.size();
        for(int i=0; i<size; i++){
            Micro micro = tempList.get(i);

            if(list.contains(micro)){
                for(Micro micro1: list){
                    if(micro.x == micro1.x && micro.y == micro1.y){
                        micro1.num += micro.num;
                        break;
                    }
                }
            }
            else
                list.add(micro);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 셀의 수
            M = Integer.parseInt(st.nextToken()); // 격리 시간
            K = Integer.parseInt(st.nextToken()); // 미생물 군집 수

            list = new LinkedList<>();
            result = 0;

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                Micro micro= new Micro(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                list.add(micro);
            }

            for(int i=0; i<M; i++){
                move();
                confirm();
            }

            for(Micro micro: list){
                result += micro.num;
            }

            bw.write("#"+(tc+1)+ " " + result + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
