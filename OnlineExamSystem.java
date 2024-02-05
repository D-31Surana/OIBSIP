package disha;
import java.util.Scanner;

class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    void updateProfile(String newUsername, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
    }
}

class Question {
    String questionText;
    String[] options;
    int correctOption;

    Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
   }
}

class Exam {
    Question[] questions;
    int totalQuestions;
    int timeLimit; // in minutes

    Exam(Question[] questions, int timeLimit) {
        this.questions = questions;
        this.totalQuestions = questions.length;
        this.timeLimit = timeLimit;
    }

    void conductExam() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Exam!");

        for (int i = 0; i < totalQuestions; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i].questionText);
            for (int j = 0; j < questions[i].options.length; j++) {
                System.out.println((char) ('A' + j) + ". " + questions[i].options[j]);
            }

            System.out.print("Your answer (A, B, C, or D): ");
            char userAnswer = Character.toUpperCase(scanner.next().charAt(0));

            if (userAnswer - 'A' == questions[i].correctOption) {
                System.out.println("Correct!\n");
 score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + (char) ('A' + questions[i].correctOption) + "\n");
            }
        }

        System.out.println("Exam completed! Your score: " + score + "/" + totalQuestions);
    }
}
public class OnlineExamSystem {
    static User currentUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        currentUser = new User(username, password);

        // Update profile and password
        System.out.print("Update your username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Update your password: ");
        String newPassword = scanner.nextLine();

        currentUser.updateProfile(newUsername, newPassword);
 // Conduct exam
        Question[] questions = {
                new Question("What is the capital of France?", new String[]{"Paris", "Berlin", "London", "Rome"}, 0),
                new Question("What is SI unit of temperature?", new String[]{"Degree Fahrenheit", "Candela", "Kelvin", "Degree Celsius"}, 2),
                new Question("Which is a reserved word in the Java programming language?", new String[]{"method", "native", "subclasses", "array"}, 1),
                new Question("By what percentage has the Indian government slashed the import duty on parts used for mobile phone manufacturing?", new String[]{"8%", "12%", "10%", "15%"}, 2),
                new Question("The pass located at the southern end of the Nilgiri Hills in south India is called ____" , new String[]{"the Palghat gap" , "the Bhorghat pass", "the Thalgat pass", "the Bolan pass"}, 0),

        };

        Exam exam = new Exam(questions, 10); // 10 minutes time limit
        exam.conductExam();
    }
}
