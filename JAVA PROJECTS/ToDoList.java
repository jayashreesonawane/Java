import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        ArrayList<String> toDoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTo-Do List Options:");
            System.out.println("1. Add an item");
            System.out.println("2. Remove an item");
            System.out.println("3. View to-do list");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the item to add: ");
                    String newItem = scanner.nextLine();
                    toDoList.add(newItem);
                    System.out.println("Item added to the to-do list.");
                    break;

                case 2:
                    if (toDoList.isEmpty()) {
                        System.out.println("The to-do list is empty. Nothing to remove.");
                    } else {
                        System.out.println("Current To-Do List:");
                        displayToDoList(toDoList);
                        System.out.print("Enter the index of the item to remove: ");
                        int index = scanner.nextInt();
                        if (index >= 0 && index < toDoList.size()) {
                            toDoList.remove(index);
                            System.out.println("Item removed from the to-do list.");
                        } else {
                            System.out.println("Invalid index. Please enter a valid index.");
                        }
                    }
                    break;

                case 3:
                    if (toDoList.isEmpty()) {
                        System.out.println("The to-do list is empty.");
                    } else {
                        System.out.println("Current To-Do List:");
                        displayToDoList(toDoList);
                    }
                    break;

                case 4:
                    System.out.println("Exiting the to-do list application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }

    public static void displayToDoList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ". " + list.get(i));
        }
    }
}
