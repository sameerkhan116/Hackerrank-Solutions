import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] items = scanner.nextLine().split(" ");
        int[] arr = new int[items.length];
        for(int i = 0; i < items.length; i++) {
            arr[i] = Integer.parseInt(items[i]);
        }
        Arrays.sort(arr);
        bw.write(String.valueOf(median(arr, 0, n / 2 - 1)));
        bw.newLine();
        bw.write(String.valueOf(median(arr, 0, n - 1)));
        bw.newLine();
        if (n % 2 == 0) {
            bw.write(String.valueOf(median(arr, n / 2, n - 1)));
            bw.newLine();
        } else {
            bw.write(String.valueOf(median(arr, n / 2 + 1, n - 1)));
            bw.newLine();
        }

        bw.close();
        scanner.close();
    }

    private static int median(int[] arr, int start, int end) {
        int length = end - start + 1;
        int median = 0;
        if (length % 2 != 0) {
            median = arr[start + length / 2];
        } else {
            median = (arr[start + length / 2 - 1] + arr[start + length / 2]) / 2;
        }
        return median;
    }
}

