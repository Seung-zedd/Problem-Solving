import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger moveCount = new BigInteger("2").pow(N).subtract(BigInteger.ONE);

        // 1. 이동 횟수를 먼저 출력
        System.out.println(moveCount);

        // 2. N이 20 이하일 때만 이동 과정을 출력
        if (N <= 20) {
            hanoi(N, 1, 3, 2);
            System.out.print(sb);
        }
    }

    public static void hanoi(int n, int start, int to, int via) {
        if (n == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, start, via, to);
        sb.append(start).append(" ").append(to).append("\n");
        hanoi(n - 1, via, to, start);
    }
}