package Domain_Camp_Questions.ADVANCE_JAVA;

import java.io.*;
import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        try {
            File myObj = new File("Domain_Camp_Questions/ADVANCE_JAVA/TextFile.txt");
            System.out.println("Looking for file at: " + myObj.getAbsolutePath());

            if (!myObj.exists()) {
                throw new FileNotFoundException("File not found.");
            }

            if (myObj.length() == 0) {
                throw new RuntimeException("The file is empty.");
            }

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred. " + e);
        }
    }
}
