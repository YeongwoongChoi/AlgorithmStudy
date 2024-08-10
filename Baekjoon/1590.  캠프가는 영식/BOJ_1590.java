import java.io.*;
import java.util.TreeSet;

public class Main {
    static final String SEPARATOR = " ";
    static final int NOT_AVAILABLE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] input = br.readLine().split(SEPARATOR);
        int N = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]);
        int S, I, C;

        TreeSet <Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(SEPARATOR);
            S = Integer.parseInt(input[0]);
            I = Integer.parseInt(input[1]);
            C = Integer.parseInt(input[2]);
            for (int j = 0; j < C; j++)
                set.add(S + I * j);
        }
        br.close();
        bw.write(String.valueOf(set.isEmpty() || set.last() < T ? NOT_AVAILABLE: set.ceiling(T) - T));
        bw.close();
    }
}
