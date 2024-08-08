import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final double [] RATE = {1.35d, 1.2d, 1.05d};
    static final int [] YEAR_TYPE = {5, 3, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        var st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        br.close();

        int [] dp = new int[Y + 1];
        dp[0] = H;

        for (int i = 1; i <= Y; i++) {
            for (int j = 0; j < 3; j++) {
                if (i >= YEAR_TYPE[j])
                    dp[i] = Math.max(dp[i], (int)(dp[i - YEAR_TYPE[j]] * RATE[j]));
            }
        }
        bw.write(String.valueOf(dp[Y]));
        bw.close();
    }
}