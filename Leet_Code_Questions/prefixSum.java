import java.io.*;
import java.util.*;

public class prefixSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int q = Integer.parseInt(first[1]);

        long[] prefix = new long[n + 1];
        String[] nums = br.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + Long.parseLong(nums[i - 1]);
        }

        for (int i = 0; i < q; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            sb.append(prefix[b] - prefix[a - 1]).append('\n');
        }

        System.out.print(sb);
    }
}
