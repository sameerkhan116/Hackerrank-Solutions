import java.io.*;
import java.util.*;

public class Solution {

    private static void removeAndHeapify(int x, Queue<Integer> pq) {
        Set<Integer> set = new HashSet<>();
        while(!pq.isEmpty()) {
            if(pq.peek() == x) {
                pq.poll();
                break;
            }
            set.add(pq.poll());
        }
        // set.remove(x);
        for(int a : set) {
            pq.offer(a);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        for(int i = 0; i < n; i++) {
            String[] query = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            if(Integer.parseInt(query[0]) == 1) pq.offer(Integer.parseInt(query[1]));
            else if(Integer.parseInt(query[0]) == 2) removeAndHeapify(Integer.parseInt(query[1]), pq);
            else if(Integer.parseInt(query[0]) == 3) {
                bw.write(String.valueOf(pq.peek()));
                bw.newLine();
            }
        }

        bw.close();
        scanner.close();
    }
}

