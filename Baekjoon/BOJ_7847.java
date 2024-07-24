/* 백준 7847 Sales Report(https://www.acmicpc.net/problem/7847)

ID 기준으로 정렬된 맵(TreeMap) 이용
*/
import java.io.*;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.StringTokenizer;

public class Main {
    static final String SEPARATOR = " ";
    static final char LINE_END = '\n';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int itemId, branchId, x;

        TreeMap <Integer, HashMap<Integer, Integer>> salesMap = new TreeMap<>();
        TreeSet<Integer> itemSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            itemId = Integer.parseInt(st.nextToken());
            branchId = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            itemSet.add(itemId);

            var items = salesMap.computeIfAbsent(branchId, k -> new HashMap<>());
            var count = items.get(itemId);
            if (count == null)
                items.put(itemId, x);
            else
                items.replace(itemId, count, count + x);
        }
        br.close();
        sb.append(-1).append(SEPARATOR);
        for (final var item: itemSet)
            sb.append(item).append(SEPARATOR);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(LINE_END);

        for (final var k: salesMap.keySet()) {
            sb.append(k).append(SEPARATOR);
            for (final var item: itemSet)
                sb.append(salesMap.get(k).getOrDefault(item, 0)).append(SEPARATOR);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(LINE_END);
        }
        bw.write(sb.toString());
        bw.close();
    }
}
