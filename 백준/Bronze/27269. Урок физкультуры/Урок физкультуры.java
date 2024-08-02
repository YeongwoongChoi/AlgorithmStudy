import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static final int MALE = 0;
    static final int FEMALE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList <Integer> list = new ArrayList<>();
        ArrayList <Integer> femaleList = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            var st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {
                case MALE:
                    list.add(Integer.parseInt(st.nextToken()));
                    break;
                case FEMALE:
                    femaleList.add(Integer.parseInt(st.nextToken()));
                    break;
            }
        }
        br.close();

        list.sort(Collections.reverseOrder());
        femaleList.sort(Collections.reverseOrder());
        list.addAll(femaleList);

        int diff = 0;
        for (int i = 1; i < N; i++)
            diff = Math.max(diff, Math.abs(list.get(i - 1) - list.get(i)));

        bw.write(String.valueOf(diff));
        bw.close();
    }
}