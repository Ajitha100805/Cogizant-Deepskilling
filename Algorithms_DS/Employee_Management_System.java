class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name,
             String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

public class Employee_Management_System {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        int count = 0;

        employees[count++] = new Employee(101, "John", "Manager", 50000);
        employees[count++] = new Employee(102, "Priya", "Developer", 40000);
        employees[count++] = new Employee(103, "Rahul", "Tester", 35000);

        // Traverse Employees
        System.out.println("Employee Records:");
        for(int i = 0; i < count; i++) {
            System.out.println(
                employees[i].employeeId + " " +
                employees[i].name + " " +
                employees[i].position + " " +
                employees[i].salary
            );
        }

        int searchId = 102;
        boolean found = false;

        for(int i = 0; i < count; i++) {
            if(employees[i].employeeId == searchId) {
                System.out.println("\nEmployee Found:");
                System.out.println(
                    employees[i].employeeId + " " +
                    employees[i].name + " " +
                    employees[i].position + " " +
                    employees[i].salary
                );
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Employee Not Found");
        }

        int deleteId = 102;

        for(int i = 0; i < count; i++) {
            if(employees[i].employeeId == deleteId) {

                for(int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                count--;
                System.out.println("\nEmployee Deleted");
                break;
            }
        }

         System.out.println("\nEmployee Records After Deletion:");

        for(int i = 0; i < count; i++) {
            System.out.println(
                employees[i].employeeId + " " +
                employees[i].name + " " +
                employees[i].position + " " +
                employees[i].salary
            );
        }
    }
}