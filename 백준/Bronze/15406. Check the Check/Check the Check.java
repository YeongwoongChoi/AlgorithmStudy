import java.io.*;

public class Main {
    static final String END = "TOTAL";
    static final String SEPARATOR = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        String [] input;

        long expected = 0L, total;

        while (!(s = br.readLine()).equals(END)) {
            input = br.readLine().split(SEPARATOR);
            expected += Long.parseLong(input[0]) * Long.parseLong(input[1]);
        }
        total = Long.parseLong(br.readLine());
        br.close();

        bw.write(total <= expected ? "PAY": "PROTEST");
        bw.close();
    }
}