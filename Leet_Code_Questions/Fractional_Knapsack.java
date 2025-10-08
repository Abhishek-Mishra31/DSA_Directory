package Leet_Code_Questions;

import java.util.Arrays;

public class Fractional_Knapsack {
    static class Item {
        double value, weight, ratio;

        Item(double value, double weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = value / weight;
        }

        public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
            int n = val.length;
            Item[] items = new Item[n];

            for (int i = 0; i < n; i++) {
                items[i] = new Item(val[i], wt[i]);
            }

            Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));


            double maxValue = 0.0;

            for (Item item : items) {
                if (capacity == 0) break;

                if (item.weight <= capacity) {
                    maxValue += item.value;
                    capacity -= item.weight;
                } else {
                    maxValue += item.ratio * capacity;
                    capacity = 0;
                }
            }

            return Math.round(maxValue * 1e6) / 1e6;
        }

        public static void main(String[] args) {
            int[] val = {60, 100, 120};
             int[] weight =  {10, 20, 30};
            int capicity = 50;
            System.out.println(fractionalKnapsack(val, weight, capicity));
        }
    }
}
