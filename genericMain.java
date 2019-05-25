import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // int t = scanner.nextInt();
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        // String[] strings = scanner.nextLine().split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // int[] arr = new int[string.length];
        // for(int i = 0; i < arr.length; i++)
        //     arr[i] = Integer.parseInt(strings[i]);

        // int res = someFunction(arr);

        bufferedWriter.write(String.valueOf(res));

        bufferedWriter.close();
        scanner.close();
    }
}

