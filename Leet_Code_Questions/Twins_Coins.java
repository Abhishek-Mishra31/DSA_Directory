package Leet_Code_Questions;
import java.util.*;
public class Twins_Coins {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] coins = new int[n];

            int total = 0;
            for (int i = 0; i < n; i++) {
                coins[i] = sc.nextInt();
                total += coins[i];
            }

            Arrays.sort(coins);
            int mySum = 0, count = 0;

            for (int i = n - 1; i >= 0; i--) {
                mySum += coins[i];
                count++;
                if (mySum > total - mySum) {
                    break;
                }
            }

            System.out.println(count);
        }

}
