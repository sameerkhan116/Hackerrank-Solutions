import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] s = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int sum = 0;
        double totalDeviation = 0;

        for(int i = 0; i < N; i++)
            sum += Integer.parseInt(s[i]);

        double mean = (double)sum / N;

        for(int i = 0; i < N; i++)
            totalDeviation += Math.pow(mean - Integer.parseInt(s[i]), 2);
        
        double stdDeviation = Math.sqrt(totalDeviation/N);
        double res = Math.round(stdDeviation * 10) / 10.0;
        bw.write(String.valueOf(res));
        bw.newLine();
        bw.close();
        scanner.close();
    }
}

