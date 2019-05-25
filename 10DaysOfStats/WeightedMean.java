import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int len = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] line1 = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] line2 = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int sum = 0, divisor = 0;
        for(int i = 0; i < len; i++) {
            int num = Integer.parseInt(line1[i]), div = Integer.parseInt(line2[i]);
            sum += num * div;
            divisor += div;
        }

        double res = Math.round((sum/(double)divisor) * 10) / 10.0;
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();

    }
}