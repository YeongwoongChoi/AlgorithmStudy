import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int FEET_TO_INCHES = 12;
    static final int ADJUSTER = 5;
    static final int RANGE = 8;
    static final String BOY = "B";

    static int getInches(final String s) {
        String [] input = s.split("['\"]");
        int feet = Integer.parseInt(input[0]);
        int inches = Integer.parseInt(input[1]);
        return feet * FEET_TO_INCHES + inches;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int total, minRange, maxRange;

        for (int i = 1; i <= T; i++) {
            var st = new StringTokenizer(br.readLine());
            final var sex = st.nextToken();
            total = getInches(st.nextToken()) + getInches(st.nextToken());
            total += (sex.equals(BOY) ? ADJUSTER: -ADJUSTER);
            minRange = (int) Math.ceil((total - RANGE) / 2.0d);
            maxRange = (int) Math.floor((total + RANGE) / 2.0d);
            sb.append(String.format("Case #%d: %d'%d\" to %d'%d\"\n", i, minRange / FEET_TO_INCHES,
                    minRange % FEET_TO_INCHES, maxRange / FEET_TO_INCHES, maxRange % FEET_TO_INCHES));
        }
        br.close();
        bw.write(sb.toString());
        bw.close();
    }
}