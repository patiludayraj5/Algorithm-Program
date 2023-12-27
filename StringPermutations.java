import java.util.Arrays;

public class StringPermutations {

    // Iterative method to generate all permutations of a string
    public static String[] iterativePermutations(String input) {
        int n = input.length();
        int fact = factorial(n);
        String[] permutations = new String[fact];

        // Convert the string to a character array
        char[] chars = input.toCharArray();

        // Initialize the first permutation
        permutations[0] = new String(chars);

        for (int i = 1; i < fact; i++) {
            // Find the rightmost character that is smaller than its next character
            int j = n - 2;
            while (j >= 0 && chars[j] >= chars[j + 1]) {
                j--;
            }

            // Find the smallest character on the right that is greater than the above found character
            int k = n - 1;
            while (chars[k] <= chars[j]) {
                k--;
            }

            // Swap the above found two characters
            char temp = chars[j];
            chars[j] = chars[k];
            chars[k] = temp;

            // Reverse the substring after the first index
            reverse(chars, j + 1, n - 1);

            // Store the current permutation
            permutations[i] = new String(chars);
        }

        return permutations;
    }

    // Recursive method to generate all permutations of a string
    public static String[] recursivePermutations(String input) {
        int n = input.length();
        int fact = factorial(n);
        String[] permutations = new String[fact];

        char[] chars = input.toCharArray();

        // Start the recursion
        generatePermutations(chars, 0, n - 1, permutations);

        return permutations;
    }

    // Helper function for recursive permutation generation
    private static void generatePermutations(char[] chars, int left, int right, String[] permutations) {
        if (left == right) {
            permutations[0] = new String(chars);
        } else {
            for (int i = left; i <= right; i++) {
                swap(chars, left, i);
                generatePermutations(chars, left + 1, right, permutations);
                swap(chars, left, i);
            }
        }
    }

    // Helper function to swap two characters in an array
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    // Helper function to reverse a portion of an array
    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    // Helper function to calculate factorial
    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Function to check if two arrays of strings are equal
    public static boolean areArraysEqual(String[] arr1, String[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        String input = "abc";

        // Iterative permutations
        String[] iterativeResult = iterativePermutations(input);

        // Recursive permutations
        String[] recursiveResult = recursivePermutations(input);

        // Check if the arrays are equal
        boolean isEqual = areArraysEqual(iterativeResult, recursiveResult);
        System.out.println("Are the arrays equal? " + isEqual);
    }
}
