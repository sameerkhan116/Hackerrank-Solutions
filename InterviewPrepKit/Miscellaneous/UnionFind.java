import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static class UnionFind {
        Map<Integer, Integer> parents;
        Map<Integer, Integer> sizes;
        int max;

        public UnionFind() {
            parents = new HashMap<>();
            sizes = new HashMap<>();
            max = 0;
        }

        public void union(int a, int b) {
            if(!parents.containsKey(a)) {
                parents.put(a, a);
                sizes.put(a, 1);
            }

            if(!parents.containsKey(b)) {
                parents.put(b, b);
                sizes.put(b, 1);
            }

            int p1 = find(a), p2 = find(b);
            if(p1 == p2) return;
            int s1 = sizes.get(p1), s2 = sizes.get(p2);

            if(s1 < s2) {
                parents.put(p1, p2);
                sizes.put(p2, s1 + s2);
            } else {
                parents.put(p2, p1);
                sizes.put(p1, s1 + s2);
            }

            max = Math.max(max, s1 + s2);
        }

        private int find(int x) {
            while(parents.get(x) != x) {
                parents.put(x, parents.get(x));
                x = parents.get(x);
            }
            return x;
        }
    }

    static int[] maxCircle(int[][] queries) {
        int[] res = new int[queries.length];
        UnionFind union = new UnionFind();
        for(int i = 0; i < queries.length; i++) {
            union.union(queries[i][0], queries[i][1]);
            res[i] = union.max;
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] queries = new int[q][2];

        for (int i = 0; i < q; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        int[] ans = maxCircle(queries);

        for (int i = 0; i < ans.length; i++) {
            bufferedWriter.write(String.valueOf(ans[i]));

            if (i != ans.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
