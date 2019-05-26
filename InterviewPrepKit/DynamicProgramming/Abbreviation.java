import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        int m = a.length(), n = b.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1; i <= m; i++) {
            char ch = a.charAt(i - 1);
            if(Character.isLowerCase(ch))
                dp[i][0] = dp[i - 1][0];
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                char x = a.charAt(i - 1), y = b.charAt(j - 1);
                if(x >= 'A' && x <= 'Z') {
                    if(x == y)
                        dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    x = Character.toUpperCase(x);
                    if(x == y)
                        dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j];
                    else dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n] ? "YES" : "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
