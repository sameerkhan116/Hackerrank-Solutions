import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static class Heap {
        Queue<Integer> lows ;
        Queue<Integer> highs;

        public Heap() {
            lows = new PriorityQueue<>((a, b) -> b - a);
            highs = new PriorityQueue<>();
        }

        public void add(int x) {
            Queue<Integer> target = (lows.size() <= highs.size()) ? lows : highs;
            target.offer(x);
            balance();
        }

        private void balance() {
            while(!lows.isEmpty() && !highs.isEmpty() && lows.peek() > highs.peek()) {
                int lo = lows.poll(), hi = highs.poll();
                lows.offer(hi);
                highs.offer(lo);
            }
        }

        public double median() {
            if(lows.size() == highs.size()) {
                return (lows.peek() + highs.peek()) / 2.0;
            }
            return lows.peek() / 1.0;
        }

        @Override
        public String toString() {
            return highs.toString();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Heap heap = new Heap();
        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            heap.add(aItem);
            bw.write(String.valueOf(heap.median()));
            bw.newLine();
        }
        System.out.println(heap);
        bw.close();
        scanner.close();
    }
}
