class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class Task_Management_System {

    static Task head = null;

    static void addTask(int id, String name, String status) {

        Task newTask = new Task(id, name, status);

        if(head == null) {
            head = newTask;
        } else {
            Task temp = head;

            while(temp.next != null) {
                temp = temp.next;
            }

            temp.next = newTask;
        }
    }

    static void displayTasks() {

        Task temp = head;

        while(temp != null) {
            System.out.println(
                temp.taskId + " " +
                temp.taskName + " " +
                temp.status
            );
            temp = temp.next;
        }
    }

    static void searchTask(int id) {

        Task temp = head;

        while(temp != null) {

            if(temp.taskId == id) {
                System.out.println("\nTask Found:");
                System.out.println(
                    temp.taskId + " " +
                    temp.taskName + " " +
                    temp.status
                );
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found");
    }

    static void deleteTask(int id) {

        if(head == null)
            return;

        if(head.taskId == id) {
            head = head.next;
            System.out.println("\nTask Deleted");
            return;
        }

        Task temp = head;

        while(temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if(temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("\nTask Deleted");
        }
    }

    public static void main(String[] args) {

        addTask(101, "Design UI", "Pending");
        addTask(102, "Write Code", "In Progress");
        addTask(103, "Testing", "Pending");

        System.out.println("Task List:");
        displayTasks();

        searchTask(102);

        deleteTask(102);

        System.out.println("\nTask List After Deletion:");
        displayTasks();
    }
}