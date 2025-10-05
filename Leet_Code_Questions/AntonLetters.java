package Leet_Code_Questions;
import java.util.*;
public class AntonLetters {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            HashSet<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    set.add(c);
                }
            }

            System.out.println(set.size());
        }

}
