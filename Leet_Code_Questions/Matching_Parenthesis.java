package Leet_Code_Questions;

import java.util.ArrayList;
import java.util.List;

public class Matching_Parenthesis {


    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void helper(List<String> result, StringBuilder current, int open, int close, int max) {

        if (current.length() == 2 * max) {
            result.add(current.toString());
            return;
        }

        if (open + close < max) {
            current.append('(');
            helper(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }

        if (open > 0) {
            current.append(')');
            helper(result, current, open - 1, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        int input = 3;
        List<String> result = generateParenthesis(input);
        System.out.println(result);


    }


}
