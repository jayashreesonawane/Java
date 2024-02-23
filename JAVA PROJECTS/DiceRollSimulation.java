import java.util.Random;

public class DiceRollSimulation {
    public static void main(String[] args) {
        // Create an instance of the Random class
        Random random = new Random();

        // Simulate rolling two dice
        int dice1 = random.nextInt(6) + 1; // Generates a random number between 1 and 6 for dice 1
        int dice2 = random.nextInt(6) + 1; // Generates a random number between 1 and 6 for dice 2

        int total = dice1 + dice2; // Calculate the total value of both dice

        // Display the result of each dice and the total
        System.out.println("Result of Dice 1: " + dice1);
        System.out.println("Result of Dice 2: " + dice2);
        System.out.println("Total: " + total);
    }
}
