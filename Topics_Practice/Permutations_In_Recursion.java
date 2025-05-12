package Topics_Practice;

public class Permutations_In_Recursion {

    // Approach :- The core idea behind this approach is recursive backtracking. We are breaking down the problem by choosing one character at a time and inserting it at all possible positions in the prefix string (p). Then, we recursively permute the rest of the characters in the unprocessed string (up).
    static void permutations(String p, String up) {
        // Base case: When there are no more characters to process in 'up', print the current permutation
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        // Get the first character from the unprocessed string
        char ch = up.charAt(0);

        // Loop through the current prefix string ('p') to insert the character 'ch' at every possible position
        for (int i = 0; i <= p.length(); i++) {

            // Divide the prefix string into two parts: first part before 'i' and second part after 'i'
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());

            // Recursive call: Insert the character 'ch' between 'first' and 'second'
            permutations(first + ch + second, up.substring(1));
        }
    }

    static int permutationsCount(String p, String up) {

        if (up.isEmpty()) {
            return 1;
        }

        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            count = count + permutationsCount(first + ch + second, up.substring(1));
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abcd";
        permutations("", str);
        System.out.println("total count of permutations are :- " + permutationsCount("", str));
    }


}
