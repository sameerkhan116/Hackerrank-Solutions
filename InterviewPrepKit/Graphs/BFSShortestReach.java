import java.io.*;
import java.util.*;

public class Solution {
    static class Edge implements Comparable<Edge> {
        int val, cost;
        public Edge(int v, int c) {
            val = v;
            cost = c;
        }

        public int compareTo(Edge e1) {
            return this.cost - e1.cost;
        }
    }

    private static int[] getDistances(int n, int m, int[][] queries, int start) {
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[start] = 0;
        List<List<Edge>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for(int[] query : queries) {
            adj.get(query[0]).add(new Edge(query[1], 6));
            adj.get(query[1]).add(new Edge(query[0], 6));
        }

        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            int val = curr.val;
            for(Edge edge : adj.get(val)) {
                if(res[edge.val] > res[val] + 6) {
                    res[edge.val] = res[val] + 6;
                    pq.offer(new Edge(edge.val, res[val] + 6));
                }
            }
        }

        System.out.println(Arrays.toString(res));

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int x = 0; x < q; x++) {
            String[] nodesAndEdges = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int n = Integer.parseInt(nodesAndEdges[0]);
            int m = Integer.parseInt(nodesAndEdges[1]);
            int[][] queries = new int[m][2];
            for(int i = 0; i < m; i++) {
                String[] query = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                queries[i] = new int[]{Integer.parseInt(query[0]), Integer.parseInt(query[1])};
            }
            int start = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] res = getDistances(n, m, queries, start);
            for(int i = 1; i < res.length; i++) {
                if(i == start) continue;
                bw.write(res[i] == Integer.MAX_VALUE ? "-1 " : String.valueOf(res[i])+ " ");
            }
            bw.newLine();
        }

        bw.close();
        scanner.close();
    }
}

