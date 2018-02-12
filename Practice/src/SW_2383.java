//       점심 식사 시간~~
//        2. 방의 한 변의 길이 N은 4 이상 10 이하의 정수이다. (4 ≤ N ≤ 10)
//        3. 사람의 수는 1 이상 10 이하의 정수이다. (1 ≤ 사람의 수 ≤ 10)
//        4. 계단의 입구는 반드시 2개이며, 서로 위치가 겹치지 않는다.
//        5. 계단의 길이는 2 이상 10 이하의 정수이다. (2 ≤ 계단의 길이 ≤ 10)
//        6. 초기에 입력으로 주어지는 사람의 위치와 계단 입구의 위치는 서로 겹치지 않는다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Man{
    int I;
    int J;
    int dis;
}
class Stair{
    int I;
    int J;
    int depth;
}
class Case {
    int N;
    int map[][];
    int dis[][];//i 번째 사람과 j 번째 계단의 거리 저장
    ArrayList<Man> ml = new ArrayList<>();
    ArrayList<Stair> sl = new ArrayList<>();
    ArrayList<Integer> Entrance1 = new ArrayList<>();
    ArrayList<Integer> Entrance2 = new ArrayList<>();

    public void move(Man m, Stair s){
            m.dis = Math.abs(m.I - s.I) + Math.abs(m.J - s.J);
    }

    public void init() {
        //사람이랑 계단 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    Man m = new Man();
                    m.I = i;
                    m.J = j;
                    ml.add(m);
                } else if (map[i][j] >= 2 && map[i][j] <= 10) {
                    Stair s = new Stair();
                    s.I = i;
                    s.J = j;
                    s.depth = map[i][j];
                    sl.add(s);
                }
            }
        }
    }
    public int run(){
        init();
        int time = 0;
        int result = 100000000;
        for (int num = 0; num < 1 << ml.size(); ++num) {
            for (int i = 0; i < ml.size(); ++i) {
                if ((num & (1 << i)) == 0) {  // 1번 계단
                    move(ml.get(i), sl.get(0));
                    Entrance1.add(ml.get(i).dis);
                } else { // 2번 계단단
                    move(ml.get(i), sl.get(1));
                    Entrance1.add(ml.get(i).dis);
                }
                int time1 = 0;
                int S1 = sl.get(0).depth;
                ArrayList<Integer> E1 = new ArrayList<>();
                for (int e = 0; e < Entrance1.size(); e++) {
                    time1++;
                    Entrance1.set(e, Entrance1.get(e) - 1);
                    if (Entrance1.get(e) == 0) {
                        if (E1.size() < 3)
                            E1.add(S1);
                        else {
                            E1.add(S1 + 1);
                        }
                    }
                }
                while(true){
                    if(E1.isEmpty()){
                        break;
                    }
                    else{
                        ++time1;
                        for(int j=0; j<E1.size(); j++){
                            E1.set(j, E1.get(j)-1);
                            if(E1.get(j) == 0){
                                E1.remove(j);
                            }
                        }
                    }
                }
                // 2번 계단으로 출동
                int time2 = 0;
                int S2 = sl.get(1).depth;
                ArrayList<Integer> E2 = new ArrayList<>();
                for (int e = 0; e < Entrance2.size(); e++) {
                    ++time2;
                    Entrance2.set(e, Entrance2.get(e) - 1);
                    if (Entrance2.get(e) == 0) {
                        if (E2.size() < 3)
                            E2.add(S2);
                        else
                            E2.add(S2 + 1);
                    }
                }
                while(true){
                    if(E2.isEmpty()){
                        break;
                    }
                    else{
                        ++time2;
                        for(int j=0; j<E2.size(); j++){
                            time2++;
                            E2.set(j, E2.get(j)-1);
                            if(E2.get(j) == 0){
                                E2.remove(j);
                            }
                        }
                    }
                }
                time = Math.max(time1, time2);
            }
            result = Math.min(result, time);
        }
        return result;
    }
}

public class SW_2383 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        Case c[] = new Case[tc];
        int result[] = new int[tc];

        for (int i = 0; i < tc; i++) {
            c[i] = new Case();
            c[i].N = Integer.parseInt(br.readLine());
            c[i].map = new int[c[i].N][c[i].N];
            for (int j = 0; j < c[i].N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < c[i].N; k++) {
                    c[i].map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#" + (i+1) + " " + c[i].run());
        }

    }
}

//
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.ArrayList;
//        import java.util.LinkedList;
//        import java.util.List;
//        import java.util.Queue;
//        import java.util.Stack;
//        import java.util.StringTokenizer;
//
///*
// * 2383. [모의 SW 역량테스트] 점심 식사시간
// * */
//public class Solution {
//    static int          N;                   // NxN 셀
//    static List<People> list;
//    static int[][]      arr;
//    static Stair[]      stair;               // 1번, 2번 계단
//    static int[]        dx = { 1, 0, -1, 0 };
//    static int[]        dy = { 0, 1, 0, -1 };
//
//    public static void init() {
//        arr = new int[N][N];
//        stair = new Stair[2];
//        list = new ArrayList<People>();
//    }
//
//    public static void init_list() {
//        // list 에 넣기 Poeple : type, len1, len2
//        for (int n = 0; n < N; n++) {
//            for (int m = 0; m < N; m++) {
//                if (arr[n][m] == 1) {
//                    int len1 = Math.abs(n - stair[0].i) + Math.abs(m - stair[0].j);
//                    int len2 = Math.abs(n - stair[1].i) + Math.abs(m - stair[1].j);
//                    list.add(new People(len1, len2));
//                }
//            }
//        }
//    }
//
//    static class Stair {
//        int i;
//        int j;
//        int depth;
//
//        Stair(int i, int j, int depth) {
//            this.i = i;
//            this.j = j;
//            this.depth = depth;
//        }
//    }
//
//    static class People {
//        int type; // 이용할 입구 타입
//        int len1; // 계단 입구1 까지의 길이
//        int len2; // 계단 입구2 까지의 길이
//
//        People(int len1, int len2) {
//            this.len1 = len1;
//            this.len2 = len2;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = null;
//        int TC = Integer.parseInt(br.readLine());
//        for (int test = 1; test <= TC; test++) {
//            st = new StringTokenizer(br.readLine());
//            N = Integer.parseInt(st.nextToken());
//            init();
//            int peopleCnt = 0;
//            for (int i = 0; i < N; i++) {
//                st = new StringTokenizer(br.readLine());
//                for (int j = 0; j < N; j++) {
//                    arr[i][j] = Integer.parseInt(st.nextToken());
//                    if (arr[i][j] == 1) {
//                        peopleCnt++;
//                    } else if (arr[i][j] != 0) {
//                        if (stair[0] == null) {
//                            stair[0] = new Stair(i, j, arr[i][j]);
//                        } else {
//                            stair[1] = new Stair(i, j, arr[i][j]);
//                        }
//                    }
//                }
//            }
//
//            int result = Integer.MAX_VALUE;
//            // 모두 1번출구를 이용할 때 ~ 모두 2번 출구를 이용할 때
//            // 비트마스킹. 사람 수 만큼의 모든 경우의 수
//            for (int i = 0; i < (1 << peopleCnt); i++) {
//                // System.out.println("# 비트마스킹 i : "+i);
//                init_list();
//                for (int j = 0; j < peopleCnt; j++) {
//                    if ((i & (1 << j)) != 0)
//                        // 0: len1
//                        list.get(j).type = 0;
//                    else
//                        // 1: len2
//                        list.get(j).type = 1;
//                }
//                int time = 0;
//                Queue<Integer> door1 = new LinkedList<Integer>();
//                Queue<Integer> door2 = new LinkedList<Integer>();
//                do {
//                    time++;
//                    // list에서 삭제할 index 뒤의 값부터 쓰기 위해 stack 사용
//                    Stack<Integer> removeStack = new Stack<Integer>();
//                    int idx = -1;
//                    for (People p : list) {
//                        idx++;
//                        // if len = 0 이면 door에 넣고(door.add(doorVal)) list에서 빼기
//                        if (p.type == 0) { // len1
//                            if (p.len1 == 0) {
//                                if (door1.size() >= 3)
//                                    door1.add(stair[0].depth);
//                                else
//                                    door1.add(stair[0].depth + 1);
//                                // list.remove(p);
//                                removeStack.push(idx); // idx번째 list 값 for문 밖에서 삭제할 것
//                            } else {
//                                p.len1--;
//                            }
//                        } else { // len2
//                            if (p.len2 == 0) {
//                                if (door2.size() >= 3)
//                                    door2.add(stair[1].depth);
//                                else
//                                    door2.add(stair[1].depth + 1);
//                                // list.remove(p);
//                                removeStack.push(idx); // idx번째 list 값 for문 밖에서 삭제할 것
//                            } else {
//                                p.len2--;
//                            }
//                        }
//                    }
//                    // 삭제할 데이터 idx문제 없도록 뒤에서부터 삭제
//                    while (!removeStack.isEmpty()) {
//                        int index = removeStack.pop();
//                        list.remove(index);
//                    }
//
//                    // door에 값이 있으면 하나씩 줄이기
//                    if (!door1.isEmpty()) {
//                        for (int k = 0; k < door1.size(); k++) {
//                            int temp = door1.poll();
//                            if (k < 3) {
//                                temp--;
//                            }
//                            door1.add(temp);
//                        }
//                        // 0이면 계단을 다 내려왔으므로 지운다
//                        while (!door1.isEmpty() && door1.peek() <= 0) {
//                            door1.poll();
//                        }
//                    }
//                    if (!door2.isEmpty()) {
//                        for (int k = 0; k < door2.size(); k++) {
//                            int temp = door2.poll();
//                            if (k < 3) {
//                                temp--;
//                            }
//                            door2.add(temp);
//                        }
//                        // 0이면 계단을 다 내려왔으므로 지운다
//                        while (!door2.isEmpty() && door2.peek() <= 0) {
//                            door2.poll();
//                        }
//                    }
//                } while (!(list.isEmpty() && door1.isEmpty() && door2.isEmpty()));
//                result = time < result ? time : result;
//            }
//            System.out.println("#" + test + " " + result);
//        }
//    }
//}