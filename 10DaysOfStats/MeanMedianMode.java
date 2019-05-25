import java.io.*;
import java.util.*;

public class Solution {
    private static void mergesort(int[] arr, int lo, int hi) {
        if(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergesort(arr, lo, mid);
            mergesort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int n1 = mid - lo + 1, n2 = hi - mid;
        int[] L = new int[n1], R = new int[n2];
        for(int i = 0; i < n1; i++) L[i] = arr[lo + i];
        for(int i = 0; i < n2; i++) R[i] = arr[mid + i + 1];

        int i = 0, j = 0, k = lo;

        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while(i < n1) arr[k++] = L[i++];
        while(j < n2) arr[k++] = R[j++];
    }

    private static double mean(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / (double)arr.length;
    }

    private static double median(int[] arr) {
        int mid = arr.length / 2;
        if(arr.length % 2 == 0) {
            return (arr[mid] + arr[mid - 1]) / 2.0;
        }
        return arr[mid];
    }

    private static double mode(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            max = Math.max(map.get(x), max);
        }
        for(int x : arr) {
            if(map.get(x) == max) return x;
        }
        throw new IllegalArgumentException();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] strings = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[strings.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(strings[i]);

        mergesort(arr, 0, arr.length - 1);

        // System.out.println(Arrays.toString(arr));

        double mean = mean(arr);
        double median = median(arr);
        double mode = mode(arr);

        bufferedWriter.write(String.valueOf(mean));
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(median));
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(mode));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }
}

