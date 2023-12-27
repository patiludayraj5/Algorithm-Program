import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageCustomization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input message
        System.out.println("Enter the message:");
        String message = scanner.nextLine();

        // Replace <<name>> with first name
        message = message.replaceAll("<<name>>", "John");

        // Replace <<full name>> with user full name
        message = message.replaceAll("<<full name>>", "John Doe");

        // Replace mobile number with your contact number
        message = message.replaceAll("91-xxxxxxxxxx", "91-9876543210");

        // Replace date in the format XX/XX/XXXX with current date
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = dateFormat.format(new Date());
        message = message.replaceAll("\\d{2}/\\d{2}/\\d{4}", currentDate);

        // Print the modified message
        System.out.println("Modified Message:\n" + message);

        scanner.close();
    }
}
