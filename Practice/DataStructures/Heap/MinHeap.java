import java.io.*;
import java.util.*;

public class Solution {
    
    static class Heap {
        int capacity;
        int[] items;
        
        public Heap(int cap, String[] unordered) {
            capacity = cap;
            items = new int[cap];
            for(int i = 0; i < unordered.length; i++) {
                items[i] = Integer.parseInt(unordered[i]);
            }
            heapify();
        }
        
        private void heapify() {
            for(int i = capacity / 2 - 1; i >= 0; i--) {
                heapify(capacity, i);
            }
            
            for(int i = capacity - 1; i >= 0; i--) {
                swap(i, 0);
                heapify(i, 0);
            }
        }
        
        private void heapify(int n, int curr) {
            int parent = curr, left = (2 * curr) + 1, right = (2 * curr) + 2;
            if(left < n && items[left] > items[parent])
                parent = left;
            
            if(right < n && items[right] > items[parent])
                parent = right;
            
            if(parent != curr) {
                swap(parent, curr);
                heapify(n, parent);
            }
        }
        
        private void swap(int i1, int i2) {
            int temp = items[i1];
            items[i1] = items[i2];
            items[i2] = temp;
        }
            
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[" + items[0]);
            for(int i = 1; i < items.length; i++) {
                sb.append(",").append(items[i]);
            }
            sb.append("]");
            return sb.toString();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] items = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Heap heap = new Heap(n, items);
        bw.write(String.valueOf(heap));
        bw.newLine();
        bw.close();
        scanner.close();
    }
}