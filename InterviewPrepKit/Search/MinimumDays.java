import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        long min = Long.MAX_VALUE;
        for(long machine : machines)
            min = Math.min(machine, min);
        long maxDays = min * goal;
        long lo = 0, hi = maxDays;
        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long towardsGoal = inDays(mid, machines);
            if(towardsGoal == goal) {
                hi = mid;
                break;
            }
            else if(towardsGoal < goal) lo = mid + 1;
            else hi = mid - 1;
        }

        while(inDays(hi, machines) == goal) hi--;

        return hi + 1;
    }

    private static long inDays(long totalDays, long[] machines) {
        long res = 0L;
        for(long machine : machines) {
            res += totalDays / machine;
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
