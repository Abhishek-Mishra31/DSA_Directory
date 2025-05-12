public class Strings_Questions {

    // question was that find if given string is palindrome or not
    static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);
            if (start != end) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String input = "abcdcba";
        System.out.println(isPalindrome(input));

    }
}
