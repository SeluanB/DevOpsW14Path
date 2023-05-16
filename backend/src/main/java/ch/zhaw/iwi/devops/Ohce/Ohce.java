package ch.zhaw.iwi.devops.Ohce;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ohce {
    private String name;

    public Ohce(String name) {
        this.name = name;
    }

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public boolean isPalindrome(String input) {
        return input.equals(reverse(input));
    }

    public String greet() {
        int hour = getCurrentHour();
        String greeting;
        if (hour >= 20 || hour < 6) {
            greeting = "¡Buenas noches " + name + "!";
        } else if (hour >= 6 && hour < 12) {
            greeting = "¡Buenos días " + name + "!";
        } else {
            greeting = "¡Buenas tardes " + name + "!";
        }
        return greeting;
    }

    public int getCurrentHour() {
        return LocalDateTime.now().getHour();
    }

    public void processInput() {
        Scanner scanner = getScanner();
        String input;
        System.out.println(greet());
    
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (isStopCommand(input)) {
                System.out.println("Adios " + name);
                break;
            } else {
                respond(input);
            }
        }
    
        scanner.close();
    }

    public boolean isStopCommand(String input) {
        return "Stop!".equalsIgnoreCase(input);
    }

    public void respond(String input) {
        String reversed = reverse(input);
        System.out.println(reversed);

        if (isPalindrome(input)) {
            System.out.println("¡Bonita palabra!");
        }
    }

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide your name as an argument.");
            return;
        }

        String name = args[0];
        Ohce ohce = new Ohce(name);
        ohce.processInput();
    }
}

