package CU_Practice_Programs;

public class practice {
    public static String revString(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            output.append(input.charAt(i));
        }

        return output.toString();
    }

    public static void main(String[] args) {
        String input = "madam";
        System.out.println(revString(input));

        if(input.equals(revString(input))){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }


    }
}
