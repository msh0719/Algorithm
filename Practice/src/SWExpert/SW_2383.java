package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 2383. [모의 SW 역량테스트] 점심 식사시간
 * */
public class SW_2383 {
    static int          N;                   // NxN 셀
    static List<People> list;
    static int[][]      arr;
    static Stair[]      stair;               // 1번, 2번 계단
    static int[]        dx = { 1, 0, -1, 0 };
    static int[]        dy = { 0, 1, 0, -1 };

    public static void init() {
        arr = new int[N][N];
        stair = new Stair[2];
        list = new ArrayList<People>();
    }

    public static void init_list() {
        // list 에 넣기 Poeple : type, len1, len2
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < N; m++) {
                if (arr[n][m] == 1) {
                    int len1 = Math.abs(n - stair[0].i) + Math.abs(m - stair[0].j);
                    int len2 = Math.abs(n - stair[1].i) + Math.abs(m - stair[1].j);
                    list.add(new People(len1, len2));
                }
            }
        }
    }

    static class Stair {
        int i;
        int j;
        int depth;

        Stair(int i, int j, int depth) {
            this.i = i;
            this.j = j;
            this.depth = depth;
        }
    }

    static class People {
        int type; // 이용할 입구 타입
        int len1; // 계단 입구1 까지의 길이
        int len2; // 계단 입구2 까지의 길이

        People(int len1, int len2) {
            this.len1 = len1;
            this.len2 = len2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int TC = Integer.parseInt(br.readLine());
        for (int test = 1; test <= TC; test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            init();
            int peopleCnt = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1) {
                        peopleCnt++;
                    } else if (arr[i][j] != 0) {
                        if (stair[0] == null) {
                            stair[0] = new Stair(i, j, arr[i][j]);
                        } else {
                            stair[1] = new Stair(i, j, arr[i][j]);
                        }
                    }
                }
            }

            int result = Integer.MAX_VALUE;
            // 모두 1번출구를 이용할 때 ~ 모두 2번 출구를 이용할 때
            // 비트마스킹. 사람 수 만큼의 모든 경우의 수
            for (int i = 0; i < (1 << peopleCnt); i++) {
                // System.out.println("# 비트마스킹 i : "+i);
                init_list();
                for (int j = 0; j < peopleCnt; j++) {
                    if ((i & (1 << j)) != 0)
                        // 0: len1
                        list.get(j).type = 0;
                    else
                        // 1: len2
                        list.get(j).type = 1;
                }
                int time = 0;
                Queue<Integer> door1 = new LinkedList<Integer>();
                Queue<Integer> door2 = new LinkedList<Integer>();
                do {
                    time++;
                    // list에서 삭제할 index 뒤의 값부터 쓰기 위해 stack 사용
                    Stack<Integer> removeStack = new Stack<Integer>();
                    int idx = -1;
                    for (People p : list) {
                        idx++;
                        // if len = 0 이면 door에 넣고(door.add(doorVal)) list에서 빼기
                        if (p.type == 0) { // len1
                            if (p.len1 == 0) {
                                if (door1.size() >= 3)
                                    door1.add(stair[0].depth);
                                else
                                    door1.add(stair[0].depth + 1);
                                // list.remove(p);
                                removeStack.push(idx); // idx번째 list 값 for문 밖에서 삭제할 것
                            } else {
                                p.len1--;
                            }
                        } else { // len2
                            if (p.len2 == 0) {
                                if (door2.size() >= 3)
                                    door2.add(stair[1].depth);
                                else
                                    door2.add(stair[1].depth + 1);
                                // list.remove(p);
                                removeStack.push(idx); // idx번째 list 값 for문 밖에서 삭제할 것
                            } else {
                                p.len2--;
                            }
                        }
                    }
                    // 삭제할 데이터 idx문제 없도록 뒤에서부터 삭제
                    while (!removeStack.isEmpty()) {
                        int index = removeStack.pop();
                        list.remove(index);
                    }

                    // door에 값이 있으면 하나씩 줄이기
                    if (!door1.isEmpty()) {
                        for (int k = 0; k < door1.size(); k++) {
                            int temp = door1.poll();
                            if (k < 3) {
                                temp--;
                            }
                            door1.add(temp);
                        }
                        // 0이면 계단을 다 내려왔으므로 지운다
                        while (!door1.isEmpty() && door1.peek() <= 0) {
                            door1.poll();
                        }
                    }
                    if (!door2.isEmpty()) {
                        for (int k = 0; k < door2.size(); k++) {
                            int temp = door2.poll();
                            if (k < 3) {
                                temp--;
                            }
                            door2.add(temp);
                        }
                        // 0이면 계단을 다 내려왔으므로 지운다
                        while (!door2.isEmpty() && door2.peek() <= 0) {
                            door2.poll();
                        }
                    }
                } while (!(list.isEmpty() && door1.isEmpty() && door2.isEmpty()));
                result = time < result ? time : result;
            }
            System.out.println("#" + test + " " + result);
        }
    }
}