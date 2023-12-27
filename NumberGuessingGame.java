import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java NumberGuessingGame <N>");
            System.exit(1);
        }

        int N = Integer.parseInt(args[0]);
        int low = 0;
        int high = N - 1;

        System.out.println("Think of a number between 0 and " + (N - 1) + " and I will guess it!");

        int guessCount = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("Is your number between " + low + " and " + mid + "? (true/false)");
            boolean response = getUserResponse();

            if (response) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

            guessCount++;
        }

        System.out.println("Your number is: " + low);
        System.out.println("Number of guesses: " + guessCount);
    }

    private static boolean getUserResponse() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true")) {
                return true;
            } else if (input.equals("false")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
    }
}
