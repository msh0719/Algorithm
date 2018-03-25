package SWExpert;

import java.io.*;
import java.util.*;

/**
 * SWExpert 모의 SW 역량 테스트
 * 2477 차량정비소
 */

class Client{

    int num;
    int arrive;
    int receive;
    int repair;

    Client(int num, int arrive, int receive, int repair){
        this.num = num;
        this.arrive = arrive;
        this.receive = receive;
        this.repair = repair;
    }
}



public class SW_2477 {

    static int N; // 접수 창구의 개수
    static int M; // 정비 창구의 개수
    static int K; // 차량 정비소를 방문한 고객의 수
    static int A, B; // 지갑을 두고간 고객의 접수, 정비 창고의 번호
    static int[] a; // 접수 창구의 걸리는 시간
    static int[] a_sum;
    static int[] b; // 정비 창구의 걸리는 시간
    static int[] b_sum;
    static int[] t; // 손님이 도착한 시간
    static int min; // 시간
    static int result;
    static Queue<Client> a_q;
    static PriorityQueue<Client> b_q;


    public static void receive(){
        int temp = 0;

        while(!a_q.isEmpty()){
            Client client = a_q.poll();
            min = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                if(client.arrive >= a_sum[i]){
                    if(a_sum[i] == 0 )
                        a_sum[i] += client.arrive;
                    a_sum[i] = client.arrive;
                    client.receive = i+1;
                    a_sum[i] += a[i];
                    client.arrive = a_sum[i];
                    b_q.offer(client);
                    break;
                }
                else{
                    if(min > a_sum[i]){
                        min = a_sum[i];
                        temp = i;
                    }
                }
            }
            if(client.receive == -1){
                client.receive = temp+1;
                a_sum[temp] += a[temp];
                client.arrive = a_sum[temp];
                b_q.offer(client);
            }

        }
    }
    public static void repair(){
        int temp = 0;

        while(!b_q.isEmpty()){
            Client client = b_q.poll();
            min = Integer.MAX_VALUE;
            for(int i=0; i<M; i++){
                if(client.arrive >= b_sum[i]){
                    client.repair = i+1;
                    if(b_sum[i] == 0)
                        b_sum[i] += client.arrive;
                    b_sum[i] = client.arrive;
                    b_sum[i] += b[i];
                    if(client.receive == A && client.repair == B) {
                        result += client.num;
                    }
                    break;
                }
                else{
                    if(min > b_sum[i]){
                        min = b_sum[i];
                        temp = i;
                    }
                }
            }
            if(client.repair == -1){
                client.repair = temp + 1;
                b_sum[temp] += b[temp];
                if(client.receive == A && client.repair == B) {
                    result += client.num;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            a = new int[N];
            a_sum = new int[N];
            b = new int[M];
            b_sum = new int[M];

            result = 0;
            min = Integer.MAX_VALUE;
            Client[] clients = new Client[K];
            a_q = new LinkedList<Client>();
            /**
             * 우선순위 큐
             * 조건 두 개로 우선순위 정하기
             * arrive가 작은 순서 & arrive가 같다면 receive가 작은 순으로!
             */
            b_q = new PriorityQueue<Client>(K, new Comparator<Client>() {
                @Override
                public int compare(Client o1, Client o2) {
                    if(o1.arrive > o2.arrive)
                        return 1;
                    else if(o1.arrive < o2.arrive)
                        return -1;
                    else{
                        if(o1.receive > o2.receive)
                            return 1;
                        else if(o1.receive < o2.receive)
                            return -1;
                        else
                            return 0;
                    }
                }
            });

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++)
                a[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++)
                b[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++) {
                clients[i] = new Client(i+1, Integer.parseInt(st.nextToken()), -1, -1);
                a_q.offer(clients[i]);
            }

            receive();
            repair();

            if(result == 0) {
                result = -1;
                bw.write("#"+(tc+1)+" " + result + "\n");
            }
            else
                bw.write("#"+(tc+1)+" " + result + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
