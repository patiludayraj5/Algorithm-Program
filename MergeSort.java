import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        // Example usage
        String[] arr = {"banana", "apple", "orange", "grape", "kiwi"};
        System.out.println("Original array: " + Arrays.toString(arr));

        mergeSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void mergeSort(String[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted
        }

        int n = arr.length;
        String[] aux = new String[n]; // Auxiliary array for merging

        mergeSort(arr, aux, 0, n - 1);
    }

    private static void mergeSort(String[] arr, String[] aux, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            // Recursive calls to sort the two halves
            mergeSort(arr, aux, lo, mid);
            mergeSort(arr, aux, mid + 1, hi);

            // Merge the sorted halves
            merge(arr, aux, lo, mid, hi);
        }
    }

    private static void merge(String[] arr, String[] aux, int lo, int mid, int hi) {
        // Copy the elements to the auxiliary array
        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }

        // Merge the two halves back into the original array
        int i = lo;
        int j = mid + 1;
        int k = lo;

        while (i <= mid && j <= hi) {
            if (aux[i].compareTo(aux[j]) <= 0) {
                arr[k] = aux[i];
                i++;
            } else {
                arr[k] = aux[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of the left half
        while (i <= mid) {
            arr[k] = aux[i];
            i++;
            k++;
        }

        // Copy any remaining elements of the right half
        while (j <= hi) {
            arr[k] = aux[j];
            j++;
            k++;
        }
    }
}
