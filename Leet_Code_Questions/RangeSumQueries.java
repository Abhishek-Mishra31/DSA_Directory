package Leet_Code_Questions;
import java.io.*;
import java.util.*;

public class RangeSumQueries {


    public class Main {

        static class FenwickTree {
            int n;
            long[] bit;

            FenwickTree(int n) {
                this.n = n;
                bit = new long[n + 1];
            }

            void add(int idx, long val) {
                for (; idx <= n; idx += idx & -idx)
                    bit[idx] += val;
            }

            long sum(int idx) {
                long res = 0;
                for (; idx > 0; idx -= idx & -idx)
                    res += bit[idx];
                return res;
            }

            long rangeSum(int l, int r) {
                return sum(r) - sum(l - 1);
            }
        }

        public static void main(String[] args) throws IOException {
            FastReader fr = new FastReader();
            StringBuilder sb = new StringBuilder();

            int n = fr.nextInt();
            int q = fr.nextInt();

            FenwickTree fw = new FenwickTree(n);
            long[] arr = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = fr.nextLong();
                fw.add(i, arr[i]);
            }

            while (q-- > 0) {
                int type = fr.nextInt();
                if (type == 1) {
                    int k = fr.nextInt();
                    long u = fr.nextLong();
                    fw.add(k, u - arr[k]);  // update difference
                    arr[k] = u;
                } else {
                    int a = fr.nextInt();
                    int b = fr.nextInt();
                    sb.append(fw.rangeSum(a, b)).append('\n');
                }
            }

            System.out.print(sb);
        }


//        static class FastReader {
//            BufferedReader br;
//            StringTokenizer st;
//
//            FastReader() {
//                br = new BufferedReader(new InputStreamReader(System.in));
//            }
//
//            String next() throws IOException {
//                while (st == null || !st.hasMoreTokens())
//                    st = new StringTokenizer(br.readLine());
//                return st.nextToken();
//            }
//
//            int nextInt() throws IOException {
//                return Integer.parseInt(next());
//            }
//
//            long nextLong() throws IOException {
//                return Long.parseLong(next());
//            }
//        }
    }

}
