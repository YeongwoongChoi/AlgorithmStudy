/* 백준 28455 Union Maplestory(https://www.acmicpc.net/problem/28455)
레벨 기준 내림차순 정렬 후, 계산
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class PS_28455 {
    static final int[] LEVELS = {60, 100, 140, 200, 250};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(br.readLine()));
        br.close();

        list.sort(Comparator.reverseOrder());
        final var subList = list.subList(0, Math.min(N, 42));
        int totalLevel = 0, totalAbility = 0;

        for (final int x: subList) {
            totalLevel += x;
            for (final int l: LEVELS) {
                if (x >= l)
                    totalAbility++;
            }
        }
        bw.write(String.format("%d %d", totalLevel, totalAbility));
        bw.close();
    }
}
