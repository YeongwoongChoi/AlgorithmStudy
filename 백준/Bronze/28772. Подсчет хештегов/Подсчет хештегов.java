import java.io.*;
import java.util.HashMap;

public class Main {
    static final char HASH_CODE = '#';
    static final String SEPARATOR = " ";
    static final char LINE_END = '\n';

    static boolean isHashTag(final String s) {
        final int len = s.length();
        if (len < 2) return false;
        if (s.charAt(0) != HASH_CODE) return false;

        for (int i = 1; i < len; i++)
            if (s.charAt(i) == HASH_CODE) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        HashMap <String, Integer> map = new HashMap<>();
        String [] input = br.readLine().split(SEPARATOR);
        br.close();

        for (String s: input) {
            if (isHashTag(s)) {
                var count = map.computeIfAbsent(s, k -> 0);
                map.replace(s, count, count + 1);
            }
        }

        sb.append(map.size()).append(LINE_END);
        for (final var e: map.entrySet())
            sb.append(e.getKey()).append(SEPARATOR).append(e.getValue()).append(LINE_END);
        bw.write(sb.toString());
        bw.close();
    }
}