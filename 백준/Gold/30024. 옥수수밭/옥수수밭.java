import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static final String SEPARATOR = " ";
    static final char LINE_END = '\n';
    static final int [] DX = {-1, 0, 1, 0};
    static final int [] DY = {0, -1, 0, 1};

    static class Corn implements Comparable<Corn> {
        int x;
        int y;
        int profit;
        Corn(int x, int y, int profit) {
            this.x = x;
            this.y = y;
            this.profit = profit;
        }
        @Override
        public int compareTo(Corn c) {
            return Integer.compare(c.profit, profit);
        }
    }

    static int [][] profitArray;
    static int N, M;

    static boolean isInRange(final int x, final int y) {
        return (x >= 0 && x < M) && (y >= 0 && y < N);
    }


    static ArrayList<Corn> getCorns(final int K) {
        PriorityQueue <Corn> pq = new PriorityQueue<>();
        ArrayList<Corn> cornList = new ArrayList<>();
        boolean [][] visited = new boolean[N][M];
        int nx, ny;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                    if (!visited[i][j]) {
                        pq.offer(new Corn(j, i, profitArray[i][j]));
                        visited[i][j] = true;
                    }
                }
            }
        }

        while (!pq.isEmpty()) {
            Corn c = pq.poll();
            if (cornList.size() == K)
                break;
            for (int i = 0; i < 4; i++) {
                nx = c.x + DX[i];
                ny = c.y + DY[i];
                if (isInRange(nx, ny) && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    pq.offer(new Corn(nx, ny, profitArray[ny][nx]));
                }
            }
            cornList.add(c);
        }
        return cornList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String [] input = br.readLine().split(SEPARATOR);
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        profitArray = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(SEPARATOR);
            for (int j = 0; j < M; j++)
                profitArray[i][j] = Integer.parseInt(input[j]);
        }
        int K = Integer.parseInt(br.readLine());
        br.close();

        var cornList = getCorns(K);

        for (final Corn c: cornList)
            sb.append(c.y + 1).append(SEPARATOR).append(c.x + 1).append(LINE_END);
        bw.write(sb.toString());
        bw.close();
    }
}