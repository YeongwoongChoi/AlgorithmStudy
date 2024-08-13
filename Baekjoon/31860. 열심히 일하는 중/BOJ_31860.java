import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static final char LINE_END = '\n';
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int satisfaction = 0;
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++)
            pq.offer(Integer.parseInt(br.readLine()));
        br.close();

        ArrayList<Integer> list = new ArrayList<>();
        int x;
        while (!pq.isEmpty()) {
            if ((x = pq.poll()) > K) {
                list.add(satisfaction = (satisfaction / 2) + x);
                pq.offer(x - M);
            }
        }

        sb.append(list.size()).append(LINE_END);
        for (final int s: list)
            sb.append(s).append(LINE_END);
        bw.write(sb.toString());
        bw.close();
    }
}
