import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Integer> heightList;
    static int[][] heightArray;
    static char[][] mapArray;
    static boolean[][] visited;
    static int totalHouses = 0;
    static int N;

    static final char POST_OFFICE = 'P';
    static final char HOUSE = 'K';
    static final Point[] DIRECTION = {new Point(-1, 0), new Point(-1, 1), new Point(0, 1), new Point(1, 1), new Point(1, 0), new Point(1, -1), new Point(0, -1), new Point(-1, -1)};

    static boolean canReach(int rangeStart, int rangeEnd, int x, int y) {
        return heightList.get(rangeStart) <= heightArray[y][x] && heightList.get(rangeEnd) >= heightArray[y][x];
    }

    static boolean isInRange(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }

    static boolean bfs(int rangeStart, int rangeEnd, Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.y][start.x] = true;

        int delivered = 0;
        int nx, ny;
        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (mapArray[curr.y][curr.x] == HOUSE) {
                delivered++;
                if (delivered == totalHouses)
                    return true;
            }

            for (final var d : DIRECTION) {
                nx = curr.x + d.x;
                ny = curr.y + d.y;
                if (isInRange(nx, ny) && canReach(rangeStart, rangeEnd, nx, ny) && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Point start = null;

        mapArray = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            mapArray[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                switch (mapArray[i][j]) {
                    case HOUSE:
                        totalHouses++;
                        break;
                    case POST_OFFICE:
                        start = new Point(j, i);
                        break;
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        heightArray = new int[N][N];

        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                set.add(heightArray[i][j] = Integer.parseInt(st.nextToken()));
        }
        br.close();

        heightList = new ArrayList<>(set);
        heightList.sort(Integer::compareTo);

        int minFatigue = 87654321;
        int left = 0, right = 0;

        while (left <= right && right < heightList.size()) {
            boolean flag = false;
            if (canReach(left, right, start.x, start.y)) {
                flag = bfs(left, right, start);
                for (int i = 0; i < N; i++)
                    Arrays.fill(visited[i], false);
            }

            if (flag) {
                minFatigue = Math.min(minFatigue, heightList.get(right) - heightList.get(left));
                left++;
            }
            else
                right++;
        }
        bw.write(String.valueOf(minFatigue));
        bw.close();
    }
}