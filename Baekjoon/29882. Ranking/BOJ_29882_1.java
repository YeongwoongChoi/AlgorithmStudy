import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static final String SEPARATOR = " ";
    static final char LINE_END = '\n';

    static class Pair {
        String name;
        int totalScore;
        Pair(String name) {
            this.name = name;
            this.totalScore = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        HashMap <String, HashMap<String, Integer>> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        String [] input;

        while (N-- > 0) {
            input = br.readLine().split(SEPARATOR);
            final int x = Integer.parseInt(input[2]);
            var problemMap = map.computeIfAbsent(input[0], k -> new HashMap<>());
            var score = problemMap.computeIfAbsent(input[1], k -> x);
            problemMap.replace(input[1], Math.max(x, score));
        }
        br.close();
        ArrayList<Pair> pairList = new ArrayList<>();

        for (final var e: map.entrySet()) {
            Pair p = new Pair(e.getKey());
            e.getValue().values().forEach(x -> p.totalScore += x);
            pairList.add(p);
        }
        pairList.sort((p1, p2) -> Integer.compare(p2.totalScore, p1.totalScore));
        pairList.forEach(p -> sb.append(p.name).append(SEPARATOR).append(p.totalScore).append(LINE_END));
        bw.write(sb.toString());
        bw.close();
    }
}
