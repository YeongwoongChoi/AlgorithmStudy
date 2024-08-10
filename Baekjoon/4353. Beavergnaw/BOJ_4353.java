/* BOJ 4353(Beavergnaw) https://www.acmicpc.net/problem/4353
    수학 공식 이용하여 d에 대한 식 유도
*/

import java.io.*;
import java.util.Arrays;

public class PS_4353 {
    static final String SEPARATOR = " ";
    static final double DECIMAL_PLACES = 1000.0d;
    static final String [] INPUT_END = {"0", "0"};

    static double getValue(final double D, final double V) {
        return Math.round(Math.cbrt(Math.pow(D, 3) - 6.0d * V / Math.PI) * DECIMAL_PLACES) / DECIMAL_PLACES;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String [] input;

        while (!Arrays.equals(input = br.readLine().split(SEPARATOR), INPUT_END)) {
            double D = Double.parseDouble(input[0]);
            double V = Double.parseDouble(input[1]);
            sb.append(String.format("%.3f\n", getValue(D, V)));
        }
        br.close();
        bw.write(sb.toString());
        bw.close();
    }
}
