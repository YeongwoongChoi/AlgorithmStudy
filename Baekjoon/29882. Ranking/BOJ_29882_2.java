import java.io.*;
import java.util.HashMap;

public class Main {
    static final String SEPARATOR = " ";
    static final char LINE_END = '\n';

    static class Pair {
        int totalScore;
        HashMap<String, Integer> problemMap;

        Pair() {
            totalScore = 0;
            problemMap = new HashMap<>();
        }

        void put(final String problem, final int x) {
            final var prev = problemMap.computeIfAbsent(problem, k -> x);
            problemMap.replace(problem, Math.max(prev, x));
        }
        void setScore() { problemMap.values().forEach(x -> totalScore += x); }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        HashMap <String, Pair> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        String [] input;

        while (N-- > 0) {
            input = br.readLine().split(SEPARATOR);
            var p = map.computeIfAbsent(input[0], k -> new Pair());
            p.put(input[1], Integer.parseInt(input[2]));
        }
        br.close();
        map.values().forEach(Pair::setScore);
        map.entrySet().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getValue().totalScore, p1.getValue().totalScore))
                .forEach(p -> sb.append(p.getKey()).append(SEPARATOR).append(p.getValue().totalScore)
                        .append(LINE_END));
        bw.write(sb.toString());
        bw.close();
    }
}
