import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 빠른 입출력을 위한 도구 소환
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // 2. 회전하는 큐
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        
        // 3. 백준 전용 출력 포맷 (<3, 6, ...>) 세팅
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while (!q.isEmpty()) {
            // K-1번 회전
            for (int i = 0; i < k - 1; i++) {
                q.offer(q.poll());
            }
            
            // K번째 이탈 및 기록
            sb.append(q.poll());
            
            if (!q.isEmpty()) {
                sb.append(", ");
            }
        }
        
        sb.append(">");
        
        // 4. 최종 결과 일괄 출력 (StringBuilder가 더 빠름!)
        System.out.println(sb.toString());
    }
}
