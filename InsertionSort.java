import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Read in the list of words
        System.out.print("Enter the number of words: ");
        int n = scanner.nextInt();
        String[] words = new String[n];

        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }

        // Sorting using Insertion Sort
        insertionSort(words);

        // Output: Print the Sorted List
        System.out.println("\nSorted List:");
        for (String word : words) {
            System.out.print(word + " ");
        }

        scanner.close();
    }

    // Insertion Sort Algorithm
    private static void insertionSort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            String key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key to one position ahead of their current position
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
