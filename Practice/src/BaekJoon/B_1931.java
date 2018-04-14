package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 1931 회의실 배정
 * 그리디 알고리즘
 */

class Meeting{
    int start;
    int end;

    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class B_1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int start_time;

        Meeting meeting[] = new Meeting[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            meeting[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meeting, new Comparator<Meeting>() {
            // 끝나는 시간 선 정렬 후 같은 경우 시작 시간으로 정렬
            @Override
            public int compare(Meeting m1, Meeting m2) {
                if (m1.end > m2.end)
                    return 1;
                else if (m1.end < m2.end)
                    return -1;
                else{
                    if(m1.start>m2.start)
                        return 1;
                    else if(m1.start < m2.start)
                        return -1;
                    else
                        return 0;
                }
            }
        });


        cnt++;
        start_time = meeting[0].end;
        for(int i=1; i<N; i++){
            if(start_time <= meeting[i].start){
                cnt++;
                start_time = meeting[i].end;
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        br.close();
    }
}
