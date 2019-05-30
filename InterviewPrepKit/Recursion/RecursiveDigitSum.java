import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
        int res = superDigitsHelper(n);
        res *= k % 9;
        while(res/10 != 0) {
            res = superDigitsHelper(String.valueOf(res));
        } 
        return res;
    }

    private static int superDigitsHelper(String s) {
        int res = 0, i = 0;
        while(i < s.length())
            res += s.charAt(i++) - '0';
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
