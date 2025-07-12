package Domain_Camp_Questions.ADVANCE_JAVA;

public class Question2 {
    private String className;
    private String[] students;

    public Question2(String className, String[] students) {
        this.className = className;
        this.students = students;
    }

    public void getDetails() {
        System.out.println("students details:");
        for (String student : students) {
            System.out.println(student);
        }
    }


    public static void main(String[] args) {
        System.out.println("NAME - ABHISHEK KUMAR");
        System.out.println("UID - 24MCA20431");
        System.out.println("************************");
        String[] list = {"Abhishek", "Adon", "Rohan_das"};
        Question2 object = new Question2("Section_6", list);
        object.getDetails();
    }
}
