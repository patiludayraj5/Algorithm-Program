import java.util.Arrays;
import java.util.Scanner;

public class AnagramDetection {
    public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();
        scanner.close();

        // Check for Anagrams
        if (areAnagrams(str1, str2)) {
            System.out.println("The two strings are Anagrams.");
        } else {
            System.out.println("The two strings are not Anagrams.");
        }
    }

    // Function to check if two strings are anagrams
    private static boolean areAnagrams(String str1, String str2) {
        // Remove spaces and convert to lowercase for case-insensitive comparison
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // Check if the lengths are the same
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to char arrays and sort them
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare the sorted char arrays
        return Arrays.equals(charArray1, charArray2);
    }
}
