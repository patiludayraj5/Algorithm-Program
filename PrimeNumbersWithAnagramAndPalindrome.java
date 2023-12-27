import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumbersWithAnagramAndPalindrome {
    public static void main(String[] args) {
        int startRange = 0;
        int endRange = 1000;

        System.out.println("Prime numbers, Anagrams, and Palindromes between " + startRange + " and " + endRange + ":");
        findAndPrintPrimesWithAnagramAndPalindrome(startRange, endRange);
    }

    // Method to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Method to check if two strings are anagrams
    private static boolean areAnagrams(String str1, String str2) {
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    // Method to check if a number is a palindrome
    private static boolean isPalindrome(int num) {
        String strNum = Integer.toString(num);
        String reversedStr = new StringBuilder(strNum).reverse().toString();

        return strNum.equals(reversedStr);
    }

    // Method to find and print prime numbers, anagrams, and palindromes in a given range
    private static void findAndPrintPrimesWithAnagramAndPalindrome(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");

                // Check for anagrams
                List<Integer> anagrams = findAnagrams(i, start, end);
                if (!anagrams.isEmpty()) {
                    System.out.print("(Anagrams: ");
                    for (int anagram : anagrams) {
                        System.out.print(anagram + " ");
                    }
                    System.out.print(")");
                }

                // Check for palindromes
                if (isPalindrome(i)) {
                    System.out.print("(Palindrome)");
                }

                System.out.println(); // Move to the next line for the next prime number
            }
        }
    }

    // Method to find anagrams of a given number within a range
    private static List<Integer> findAnagrams(int num, int start, int end) {
        List<Integer> anagrams = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (i != num && areAnagrams(Integer.toString(num), Integer.toString(i))) {
                anagrams.add(i);
            }
        }

        return anagrams;
    }
}
