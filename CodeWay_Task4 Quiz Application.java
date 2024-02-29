import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private static final int NUM_QUESTIONS = 5;
    private static final int TIME_LIMIT_PER_QUESTION = 30; // in seconds
    private static final String[] QUESTIONS = {
        "Number of primitive data types in Java are?\n" +
        "a) 6\n" +
        "b) 7\n" +
        "c) 8\n" +
        "d) 9",
        
        "What is the size of float and double in java'?\n" +
        "a) 32 and 64 bit\n" +
        "b) 32 and 32 bit\n" +
        "c) 64 and 64 bit\n" +
        "d) 64 and 32 bit",
        
        "When an array is passed to a method, what does the method receive?\n" +
        "a) The refernce of the array" +
        "b) A copy of the array\n" +
        "c) Length of the array\n" +
        "d) Copy of first element",
        
        "Arrays in Java are?\n" +
        "a) Object refernces\n" +
        "b) objects\n" +
        "c) Primitive data type\n" +
        "d) None",
        
        "Where does the system stores parameters and local variables whenever a method is invoked??\n" +
        "a) Heap\n" +
        "b) Stack\n" +
        "c) Array\n" +
        "d) Tree"
    };

    private static final String[] ANSWERS = {"c", "a", "a", "b", "b"};
    private static int score = 0;
    private static int currentQuestion = 0;
    private static Timer timer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        displayQuestion(currentQuestion);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.");
                nextQuestion(scanner);
            }
        }, TIME_LIMIT_PER_QUESTION * 1000);

        while (currentQuestion < NUM_QUESTIONS) {
            String answer = scanner.nextLine().trim();
            if (!answer.isEmpty()) {
                checkAnswer(answer);
                nextQuestion(scanner);
            }
        }

        System.out.println("\nQuiz completed! Your final score is: " + score + "/" + NUM_QUESTIONS);
        timer.cancel();
    }

    private static void displayQuestion(int index) {
        System.out.println("Question " + (index + 1) + ":\n" + QUESTIONS[index]);
        System.out.print("Your answer: ");
    }

    private static void checkAnswer(String answer) {
        if (answer.equalsIgnoreCase(ANSWERS[currentQuestion])) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect! The correct answer is: " + ANSWERS[currentQuestion]);
        }
    }

    private static void nextQuestion(Scanner scanner) {
        timer.cancel(); // Cancel previous timer
        currentQuestion++;
        if (currentQuestion < NUM_QUESTIONS) {
            displayQuestion(currentQuestion);
            timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.");
                    nextQuestion(scanner);
                }
            }, TIME_LIMIT_PER_QUESTION * 1000);
        }
    }
}
