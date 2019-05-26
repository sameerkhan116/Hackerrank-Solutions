import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        long res = 0;
        int m = arr.length;
        int[] dp = new int[m];
        dp[0] = 1;
        int i = 1, j = m - 2;
        while(i < m) {
            if(arr[i] > arr[i - 1]) dp[i] = 1 + dp[i - 1];
            else dp[i] = 1;
            i++;
        }
        while(j >= 0) {
            if(arr[j] > arr[j + 1]) dp[j] = Math.max(1 + dp[j + 1], dp[j]);
            j--;
        }

        System.out.println(Arrays.toString(dp));

        for(int x : dp) {
            res += x;
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
