import java.util.Scanner;

public class MultipleChoiceQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Questions and answers
        String[] questions = {
            "1. What is the capital of France?",
            "2. Which planet is known as the Red Planet?",
            "3. Who painted the Mona Lisa?",
            // Add more questions as needed
        };
        
        String[] options = {
            "A. London\tB. Paris\tC. Rome\tD. Madrid",
            "A. Mars\tB. Jupiter\tC. Venus\tD. Earth",
            "A. Vincent van Gogh\tB. Leonardo da Vinci\tC. Pablo Picasso\tD. Michelangelo",
            // Add options for the corresponding questions
        };
        
        char[] correctAnswers = {'B', 'A', 'B'}; // Add the correct answers
        
        int score = 0;
        
        // Display questions and get user answers
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println(options[i]);
            System.out.print("Enter your answer (A, B, C, or D): ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);
            
            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + correctAnswers[i]);
            }
        }
        
        // Display final score
        System.out.println("\nQuiz complete! Your score is: " + score + " out of " + questions.length);
    }
}
