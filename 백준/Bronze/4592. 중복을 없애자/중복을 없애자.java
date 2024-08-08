import java.io.*;
import java.util.LinkedList;

public class Main {
    static final String SEPARATOR = " ";
    static final String SUFFIX = "$\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N, x;
        String [] input;
        LinkedList <Integer> list = new LinkedList<>();

        while (true) {
            input = br.readLine().split(SEPARATOR);
            N = Integer.parseInt(input[0]);
            if (N == 0) {
                br.close();
                break;
            }
            list.add(Integer.parseInt(input[1]));

            for (int i = 2; i <= N; i++) {
                x = Integer.parseInt(input[i]);
                if (list.peekLast() == x)
                    continue;
                list.add(x);
            }

            for (final int e: list)
                sb.append(e).append(SEPARATOR);
            sb.append(SUFFIX);
            list.clear();
        }
        bw.write(sb.toString());
        bw.close();
    }
}