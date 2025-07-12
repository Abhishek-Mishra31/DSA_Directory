package Domain_Camp_Questions.ADVANCE_JAVA;

     class Employee{
        int Salary = 45000;
        public void work(){
            System.out.println("Work Called from Employee Department");
        }

        public void getSalary(){
            System.out.println("Salary of Employee is " + this.Salary);
        }
    }


     class HRManager extends Employee{
        @Override
        public void work() {
            System.out.println("work called from HR Department");
        }

        public void addEmployee(){
            System.out.println("Employee Added Successfully");
        }
    }

public class Question4 {
    public void main(String[] args) {
        System.out.println("NAME - ABHISHEK KUMAR");
        System.out.println("UID - 24MCA20431");
        System.out.println("************************");
        HRManager manager = new HRManager();
        manager.work();
        manager.addEmployee();
        Employee employee = new Employee();
        employee.work();
        employee.getSalary();
    }
}


