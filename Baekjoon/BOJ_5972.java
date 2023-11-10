import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.ArrayList;

class Pair implements Comparable<Pair> {
    int endCity;
    int treats;

    Pair(int endCity, int treats) {
        this.endCity = endCity;
        this.treats = treats;
    }

    @Override
    public int compareTo(Pair p) {
        return this.treats - p.treats;
    }
}

public class PS_5972 {
    static ArrayList <ArrayList <Pair>> adjacentList;
    static boolean [] isVisited;
    static int [] treatsArray;

    static void initializeList(int V) {
        treatsArray = new int[V + 1];
        Arrays.fill(treatsArray, Integer.MAX_VALUE);
        adjacentList = new ArrayList<>();
        isVisited = new boolean[V + 1];
        adjacentList.add(null);

        for (int i = 1; i <= V; i++)
            adjacentList.add(new ArrayList<>());
    }

    static void addEdge(int startCity, int endCity, int treats) {
        adjacentList.get(startCity).add(new Pair(endCity, treats));
        adjacentList.get(endCity).add(new Pair(startCity, treats));
    }

    static void dijkstra(int startCity) {
        PriorityQueue <Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(startCity, 0));
        treatsArray[startCity] = 0;
        Pair current;
        int calculatedtreats;

        while (!pq.isEmpty()) {
            current = pq.poll();

            if (isVisited[current.endCity])
                continue;
            isVisited[current.endCity] = true;

            for (Pair next: adjacentList.get(current.endCity)) {
                calculatedtreats = next.treats + treatsArray[current.endCity];
                if (treatsArray[next.endCity] > calculatedtreats) {
                    treatsArray[next.endCity] = calculatedtreats;
                    pq.offer(new Pair(next.endCity, treatsArray[next.endCity]));
                }
            }
        }
    }
    static final String SEPARATOR = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String [] info = br.readLine().split(SEPARATOR);
        int V = Integer.parseInt(info[0]);
        int E = Integer.parseInt(info[1]);
        initializeList(V);

        int startCity, endCity, treats;

        while (E-- > 0) {
            info = br.readLine().split(SEPARATOR);
            startCity = Integer.parseInt(info[0]);
            endCity = Integer.parseInt(info[1]);
            treats = Integer.parseInt(info[2]);
            addEdge(startCity, endCity, treats);
        }
        br.close();
        dijkstra(1);
        sb.append(treatsArray[V]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
