import java.util.Scanner;

public class BasicCalculator 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Basic Calculator!");

        while (true) 
        {
            System.out.println("Select an operation:");

            System.out.println("1. Addition (+)");

            System.out.println("2. Subtraction (-)");

            System.out.println("3. Multiplication (*)");

            System.out.println("4. Division (/)");

            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            if (choice == 5) 
            {
                System.out.println("Exiting the calculator. Goodbye!");

                break;
            }

            System.out.println("Enter the first number: ");

            double num1 = scanner.nextDouble();

            System.out.println("Enter the second number: ");

            double num2 = scanner.nextDouble();

            switch (choice) 
            {
                case 1:
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + add(num1, num2));
                    break;

                case 2:
                    System.out.println("Result: " + num1 + " - " + num2 + " = " + subtract(num1, num2));
                    break;

                case 3:
                    System.out.println("Result: " + num1 + " * " + num2 + " = " + multiply(num1, num2));
                    break;

                case 4:
                    if (num2 == 0) 
                    {
                        System.out.println("Error! Division by zero is not allowed.");
                    } 

                    else 
                    {
                        System.out.println("Result: " + num1 + " / " + num2 + " = " + divide(num1, num2));
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid operation.");
                    break;
            }
        }

        scanner.close();
    }

    public static double add(double a, double b) 
    {
        return a + b;
    }

    public static double subtract(double a, double b) 
    {
        return a - b;
    }

    public static double multiply(double a, double b) 
    {
        return a * b;
    }

    public static double divide(double a, double b) 
    {
        return a / b;
    }
}
