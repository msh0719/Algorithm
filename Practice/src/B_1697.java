/*
        BFS 너비 우선 탐색
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int count;
    int value;

    Node(int count, int value){
        this.count = count;
        this.value = value;
    }
}

public class B_1697 {

    static int n;
    static int k;
    static int[] dx = {-1, 1, 0};
    static boolean[] visited = new boolean[100001];

    public static int bfs(int v){
        Queue<Node> q = new LinkedList<>();

        visited[v] = true; // 초기 N값을 방문했다고 저장 한다
        q.add(new Node(0,v)); // 큐에 0번 인 초기 N값을 저장한다.

        while(!q.isEmpty()){ //큐가 비어있지 않을 떄까지
            Node node = q.poll(); // 앞에꺼 폴
            int cnt = node.count;
            int pos = node.value;

            if(pos == k){
                return cnt;
            }
            for(int i=0; i<3; i++){
                int next;

                if(dx[i] != 0){
                    next = pos + dx[i];
                }
                else {
                    next = pos * 2;
                }
                if( 0<=next && next <=100000){
                    if(!visited[next]){
                        q.add(new Node(cnt+1, next));
                        visited[next] = true;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n >= k){
            System.out.println(n-k);
        }
        else
            System.out.println(bfs(n));

    }
}
