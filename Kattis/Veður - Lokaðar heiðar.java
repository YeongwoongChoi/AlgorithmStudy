import java.io.*;

public class Main {
    static final String SEPARATOR = " ";
    static final String [] RESULTS = { "lokud\n", "opin\n" };

    static int isSafe(int velocity, int maximum) {
        return maximum >= velocity ? 1: 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int velocity = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        String [] roadInfo;

        while (n-- > 0) {
            roadInfo = br.readLine().split(SEPARATOR);
            sb.append(roadInfo[0]).append(SEPARATOR).append(RESULTS[isSafe(velocity, Integer.parseInt(roadInfo[1]))]);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
