import java.io.*;

public class Main {
    static boolean isTarget(String s) {
        final int length = s.length();
        boolean flag = true;
        for (int i = 0; i < length; i++)
            flag = flag && (s.charAt(i) == '4' || s.charAt(i) == '7');
        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();

        String s;
        while (N > 0) {
            s = String.valueOf(N);
            if (isTarget(s)) {
                bw.write(s);
                break;
            }
            N--;
        }
        bw.close();
    }
}