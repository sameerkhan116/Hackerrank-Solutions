import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // class implementation of edge to start node number and cost to get to it
    // also compareTo for adding to priorityQueue
    static class Edge implements Comparable<Edge> {
        int node, cost;
        public Edge(int n, int c) {
            node = n;
            cost = c;
        }

        public int compareTo(Edge e1) {
            return this.cost - e1.cost;
        }

        @Override
        public String toString() {
            return this.node + ":" + this.cost;
        }
    }

    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, int[] ids, int val) {
        
        int[] res = new int[graphNodes + 1]; // distance for each node from start
        Arrays.fill(res, Integer.MAX_VALUE); // fill with max
        int start = 0;

        for(int i = 0; i < ids.length; i++) {
            // get first node that matches val
            if(ids[i] == val) {
                start = i + 1;
                break;
            }
        }


        res[start] = 0; // set the cost for getting to itself as 0
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i <= graphNodes; i++)
            adjList.add(new ArrayList<Integer>());

        // create adjList for each node
        for(int i = 0; i < graphFrom.length; i++) {
            int from = graphFrom[i], to = graphTo[i];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        pq.add(new Edge(start, 0)); // Add start node to pq

        // BFS
        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            for(int e : adjList.get(curr.node)) {
                int pathCost = res[curr.node] + 1;
                if(pathCost >= res[e]) continue;
                res[e] = pathCost;
                pq.add(new Edge(e, pathCost));
            }
        }

        // get list of nodes with same ids
        for(int i = 0; i < ids.length; i++)
            if(ids[i] == val) 
                list.add(res[i + 1]);

        if(list.size() <= 1) return -1; // if less than one node no other path
        Collections.sort(list);

        // return the difference between the lowest two cost
        return list.get(1) - list.get(0);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        int[] ids = new int[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            int idsItem = Integer.parseInt(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}