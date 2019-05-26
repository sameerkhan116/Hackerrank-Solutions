import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the separateNumbers function below.
    static String separateNumbers(String s) {
        String start = "";
        boolean valid = false;

        for(int i = 1; i <= s.length() / 2; i++) {
            start = s.substring(0, i);
            String test = start;
            long val = Long.parseLong(start);

            while(test.length() < s.length()) {
                test += Long.toString(++val);
            }

            if(test.equals(s)) {
                valid = true;
                break;
            }
        }
        
        return valid ? start : "";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String res = separateNumbers(s);

            bw.write(res != "" ? "YES " + res : "NO");
            bw.newLine();
        }
        bw.close();
        scanner.close();
    }
}
