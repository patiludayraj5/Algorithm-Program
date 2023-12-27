import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BinarySearchWord {

    public static void main(String[] args) {
        try {
            // Read the list of words from a file
            String[] wordList = readWordListFromFile();

            // Sort the word list
            Arrays.sort(wordList);

            // Prompt the user to enter a word to search
            String searchWord = getUserInput("Enter a word to search: ");

            // Perform binary search
            boolean found = binarySearch(wordList, searchWord);

            // Print the result
            if (found) {
                System.out.println(searchWord + " found in the list.");
            } else {
                System.out.println(searchWord + " not found in the list.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the word list from file: " + e.getMessage());
        }
    }

    private static String[] readWordListFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("wordlist.txt"));
        String line = reader.readLine();
        reader.close();

        // Split the comma-separated words into an array
        return line.split(", ");
    }

    private static String getUserInput(String prompt) throws IOException {
        System.out.print(prompt);
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        return reader.readLine();
    }

    private static boolean binarySearch(String[] array, String key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = key.compareTo(array[mid]);

            if (comparison == 0) {
                return true; // Key found
            } else if (comparison < 0) {
                high = mid - 1; // Search in the left half
            } else {
                low = mid + 1; // Search in the right half
            }
        }

        return false; // Key not found
    }
}
