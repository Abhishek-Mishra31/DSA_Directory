package Leet_Code_Questions;
import java.util.*;
public class TeamsForming {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);
            int total = 0;
            for (int i = 0; i < n; i += 2) {
                total += (a[i + 1] - a[i]);
            }

            System.out.println(total);
        }

}
