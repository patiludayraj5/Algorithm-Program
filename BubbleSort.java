import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements in the array
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Read the elements into an array
        int[] arr = new int[n];
        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Perform Bubble Sort
        bubbleSort(arr);

        // Print the sorted array
        System.out.println("Sorted List:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }

    // Bubble Sort implementation
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
}
