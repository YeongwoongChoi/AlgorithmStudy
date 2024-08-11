import java.io.*;
import java.util.TreeSet;

public class Main {
    static final int MAX_RANGE = 1000000;

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

        TreeSet <Integer> set = new TreeSet<>();
        for (int i = 4; i <= MAX_RANGE; i++) {
            if (isTarget(String.valueOf(i)))
                set.add(i);
        }
        int N = Integer.parseInt(br.readLine());
        br.close();
        bw.write(String.valueOf(set.floor(N)));
        bw.close();
    }
}