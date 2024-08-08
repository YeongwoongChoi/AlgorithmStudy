import java.io.*;

public class Main {
    static final String SEPARATOR = " ";
    static final String SUFFIX = "$\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N, prev, x;
        String [] input;

        while (true) {
            input = br.readLine().split(SEPARATOR);
            N = Integer.parseInt(input[0]);
            if (N == 0) {
                br.close();
                break;
            }
            sb.append(prev = Integer.parseInt(input[1])).append(SEPARATOR);
            for (int i = 2; i <= N; i++) {
                x = Integer.parseInt(input[i]);
                if (prev == x)
                    continue;
                sb.append(x).append(SEPARATOR);
                prev = x;
            }
            sb.append(SUFFIX);
        }
        bw.write(sb.toString());
        bw.close();
    }
}