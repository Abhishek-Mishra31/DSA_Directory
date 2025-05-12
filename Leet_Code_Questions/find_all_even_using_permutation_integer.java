package CU_Practice_Programs.Leet_Code_Questions;

import java.util.*;

public class find_all_even_using_permutation_integer {

    // i got TLE error with this functions
    public static int[] findEvenNumbers(int[] digits) {
        List<Integer> up = new ArrayList<>();
        for (int num : digits) {
            up.add(num);
        }

        Set<Integer> result = new TreeSet<>();

        generatePermutations(up, new ArrayList<>(), result);

        int[] res = new int[result.size()];
        int i = 0;
        for (int val : result) {
            res[i++] = val;
        }
        return res;
    }

    public static void generatePermutations(List<Integer> up, List<Integer> p, Set<Integer> result) {
        if (p.size() == 3) {
            if (p.get(0) != 0 && p.get(2) % 2 == 0) {
                int number = p.get(0) * 100 + p.get(1) * 10 + p.get(2);
                result.add(number);
            }
            return;
        }

        for (int i = 0; i < up.size(); i++) {
            Integer ch = up.get(i);
            List<Integer> remaining = new ArrayList<>(up);
            remaining.remove(i);

            p.add(ch);
            generatePermutations(remaining, p, result);
            p.remove(p.size() - 1);
        }
    }


    // so I implemented this function according to time-complexity
    public static int[] findEvenNumbersWithOptimized(int[] digits) {
        Set<Integer> result = new TreeSet<>();

        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    if (digits[k] % 2 != 0) continue;

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    result.add(num);
                }
            }
        }

        int[] res = new int[result.size()];
        int index = 0;
        for (int val : result) {
            res[index++] = val;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,8,8,2};
        int[] output = findEvenNumbersWithOptimized(arr);
        System.out.println(Arrays.toString(output));
    }
}
