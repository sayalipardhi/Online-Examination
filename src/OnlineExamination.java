import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class OnlineExamination {

    // ================== User Class ==================
    static class User {
        private String username;
        private String password;
        private String profile = "No profile info";

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean login(String user, String pass) {
            return username.equals(user) && password.equals(pass);
        }

        public void updateProfile(String newProfile) {
            this.profile = newProfile;
            System.out.println("Profile updated successfully!");
        }

        public void updatePassword(String newPass) {
            this.password = newPass;
            System.out.println("Password updated successfully!");
        }

        public String getProfile() {
            return profile;
        }
    }

    // ================== Question Class ==================
    static class Question {
        String question;
        String option1, option2, option3, option4;
        int correctOption;

        public Question(String question, String o1, String o2, String o3, String o4, int correctOption) {
            this.question = question;
            this.option1 = o1;
            this.option2 = o2;
            this.option3 = o3;
            this.option4 = o4;
            this.correctOption = correctOption;
        }
    }

    // ================== Exam Class ==================
    static class Exam {
        Question[] questions = new Question[5];
        int score = 0;
        int timeLimit = 30; // seconds

        public Exam() {
            questions[0] = new Question("1. Java is _____?",
                    "Platform-dependent", "Platform-independent", "Not a language", "None", 2);

            questions[1] = new Question("2. OOP stands for?",
                    "Object-Oriented Programming", "Old Operating Program", "Open Office Program", "None", 1);

            questions[2] = new Question("3. Which keyword is used to inherit a class?",
                    "super", "this", "extends", "import", 3);

            questions[3] = new Question("4. Java uses which compiler?",
                    "JIT", "GCC", "Turbo", "None", 1);

            questions[4] = new Question("5. JVM stands for?",
                    "Java Very Much", "Java Virtual Machine", "Joint Virtual Machine", "None", 2);
        }

        public void startExam(Scanner sc) {
            AtomicBoolean timeUp = new AtomicBoolean(false);

            Thread timerThread = new Thread(() -> {
                try {
                    Thread.sleep(timeLimit * 1000);
                    timeUp.set(true);
                    System.out.println("\n⏳ Time Over! Auto-submitting...");
                } catch (InterruptedException e) {
                    // timer interrupted
                }
            });

            timerThread.start();

            System.out.println("\n===== Exam Started (" + timeLimit + " sec) =====");

            for (Question q : questions) {
                if (timeUp.get()) break;

                System.out.println("\n" + q.question);
                System.out.println("1. " + q.option1);
                System.out.println("2. " + q.option2);
                System.out.println("3. " + q.option3);
                System.out.println("4. " + q.option4);

                System.out.print("Enter your answer: ");

                // Check input availability before reading to avoid blocking after timeUp
                while (!sc.hasNextInt()) {
                    if (timeUp.get()) break;
                    sc.next(); // discard invalid input
                }

                if (timeUp.get()) break;

                int answer = sc.nextInt();
                if (answer == q.correctOption) {
                    score++;
                }
            }

            System.out.println("\n===== Exam Finished =====");
            System.out.println("Your Score: " + score + "/5");

            // Stop timer if exam finished early
            timerThread.interrupt();
        }
    }

    // ================== Utils Class ==================
    static class Utils {
        public static void clearScreen() {
            System.out.println("\n\n\n\n\n");
        }
    }

    // ================== Main Method ==================
    public static void main(String[] args) {

        // Use try-with-resources to automatically close the Scanner at the end
        try (Scanner sc = new Scanner(System.in)) {

            // Updated default login
            User user = new User("Sayali Pardhi", "1627"); 
            Exam exam = new Exam();

            // Login loop
            while (true) {
                System.out.println("\n===== ONLINE EXAM SYSTEM =====");
                System.out.print("Enter Username: ");
                String u = sc.nextLine();

                System.out.print("Enter Password: ");
                String p = sc.nextLine();

                if (user.login(u, p)) {
                    System.out.println("\nLogin Successful!");
                    break;
                } else {
                    System.out.println("Invalid Login! Try again.\n");
                }
            }

            int choice = 0;

            // Menu loop
            while (choice != 4) {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Update Profile");
                System.out.println("2. Update Password");
                System.out.println("3. Start Exam");
                System.out.println("4. Logout");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter new profile info: ");
                        sc.nextLine(); // consume leftover newline
                        String profile = sc.nextLine();
                        user.updateProfile(profile);
                        break;

                    case 2:
                        System.out.print("Enter new password: ");
                        String newPass = sc.next();
                        user.updatePassword(newPass);
                        break;

                    case 3:
                        exam.startExam(sc);
                        break;

                    case 4:
                        System.out.println("\nLogged Out Successfully!");
                        break;

                    default:
                        System.out.println("Invalid Option!");
                }
            }
        } 
    }
}
