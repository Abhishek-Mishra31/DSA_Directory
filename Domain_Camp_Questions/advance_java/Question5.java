package Domain_Camp_Questions.ADVANCE_JAVA;
import java.util.Arrays;
import java.util.Comparator;


public class Question5 {

        public static void main(String[] args) {
            String[] names = {"Zara", "Amit", "Mohan", "Deepa"};

            String[] asc = Arrays.stream(names)
                    .sorted()
                    .toArray(String[]::new);
            System.out.println("NAME - ABHISHEK KUMAR");
            System.out.println("UID - 24MCA20431");
            System.out.println("************************");
            System.out.println("Ascending:");
            for (String name : asc) {
                System.out.println(name);
            }

            String[] desc = Arrays.stream(names)
                    .sorted(Comparator.reverseOrder())
                    .toArray(String[]::new);
            System.out.println("Descending:");
            for (String name : desc) {
                System.out.println(name);
            }

        }

}
