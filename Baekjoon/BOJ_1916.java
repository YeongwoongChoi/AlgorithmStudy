import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.ArrayList;

class Pair implements Comparable<Pair> {
    int endCity;
    int cost;

    Pair(int endCity, int cost) {
        this.endCity = endCity;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair p) {
        return this.cost - p.cost;
    }
}

public class PS_1916 {
    static ArrayList <ArrayList <Pair>> adjacentList;
    static boolean [] isVisited;
    static int [] costArray;

    static void initializeList(int V) {
        costArray = new int[V + 1];
        Arrays.fill(costArray, Integer.MAX_VALUE);
        adjacentList = new ArrayList<>();
        isVisited = new boolean[V + 1];
        adjacentList.add(null);

        for (int i = 1; i <= V; i++)
            adjacentList.add(new ArrayList<>());
    }

    static void addEdge(int startCity, Pair p) {
        adjacentList.get(startCity).add(p);
    }

    static void dijkstra(int startCity) {
        PriorityQueue <Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(startCity, 0));
        costArray[startCity] = 0;
        Pair current;
        int calculatedCost;

        while (!pq.isEmpty()) {
            current = pq.poll();

            if (isVisited[current.endCity])
                continue;
            isVisited[current.endCity] = true;

            for (Pair next: adjacentList.get(current.endCity)) {
                calculatedCost = next.cost + costArray[current.endCity];
                if (costArray[next.endCity] > calculatedCost) {
                    costArray[next.endCity] = calculatedCost;
                    pq.offer(new Pair(next.endCity, costArray[next.endCity]));
                }
            }
        }
    }
    static final String SEPARATOR = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        initializeList(V);
        String [] info;
        int startCity, endCity, cost;

        while (E-- > 0) {
            info = br.readLine().split(SEPARATOR);
            startCity = Integer.parseInt(info[0]);
            endCity = Integer.parseInt(info[1]);
            cost = Integer.parseInt(info[2]);
            addEdge(startCity, new Pair(endCity, cost));
        }
        info = br.readLine().split(SEPARATOR);
        br.close();
        startCity = Integer.parseInt(info[0]);
        endCity = Integer.parseInt(info[1]);

        dijkstra(startCity);
        sb.append(costArray[endCity]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
