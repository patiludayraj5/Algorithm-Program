public class PrimeNumberFinder {

    public static void main(String[] args) {
        int lowerRange = 0;
        int upperRange = 1000;

        System.out.println("Prime numbers in the range " + lowerRange + " to " + upperRange + ":");
        findAndPrintPrimes(lowerRange, upperRange);
    }

    private static void findAndPrintPrimes(int lower, int upper) {
        for (int number = lower; number <= upper; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
