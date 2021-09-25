package activity7;

import java.util.Random;

public class Part2 {

    // initialize constant variable and set to 5
    private static final int SIZE = 5;

    public static void main(String[] args) {
        // initialize Random class
        Random randomGenerator = new Random();

        // initialize upper bound (max+1) since it's exclusive
        int high = 76;

        // initialize lower bound
        int low = 10;

        // initialize 2D array using SIZE constant variable to make a 5x5 array
        int[][] numbers = new int[SIZE][SIZE];

        // initialize 1D array to store the diagonals of the 2D array (this is always the SIZE) or n where nxn is the 2D array
        int[] diagonals = new int[SIZE];

        // initialize an integer to contain the sum of the numbers above the diagonal of the 2D array
        int upperTriangularSum = 0;

        // initialize an integer to contain the sum of the numbers below the diagonal of the 2D array
        int lowerTriangularSum = 0;

        // initialize a String to contain the even numbers above the diagonal of the 2D array
        String evenUpperTriangularNumbers = "";

        // initialize a String to contain the odd numbers below the diagonal of the 2D array
        String oddLowerTriangularNumbers = "";

        // Print the first output
        System.out.println("1) Output the array elements");

        // Initialize an integer to contain the sum of prime numbers of the 2D array
        int sumOfPrimeNumbers = 0;

        // Initialize outer loop to loop through the rows of the 2D array
        for( int i = 0; i < SIZE; i++ ) {

            // Initialize inner loop to loop through the columns of each row
            for(int j = 0; j < SIZE; j++) {

                // Get a random number between the two bounds and store to the current ith and jth element of the 2D array
                numbers[i][j] = randomGenerator.nextInt(high-low) + low;

                // Print the number
                System.out.print(numbers[i][j] + "\t");

                // Check if the current number is prime, if so, then add it to the sumOfPrimeNumbers integer, otherwise add 0
                sumOfPrimeNumbers += isPrime( numbers[i][j] ) ? numbers[i][j] : 0;

                // If the ith index is equal with the jth index, then we know that it's a diagonal, so store it to the diagonals array
                if( i == j ) diagonals[i] = numbers[i][j];

                // if the ith index is less than the jth index then we know this current number is part of the numbers above the diagonal
                if( i < j ) {

                    // Add it to the upper triangular sum
                    upperTriangularSum += numbers[i][j];

                    // Check if it's even
                    if( numbers[i][j] % 2 == 0 ) {

                        // If so, add it to the string that contains the even numbers of the upper triangle
                        evenUpperTriangularNumbers += numbers[i][j] + " ";
                    }
                }

                // if the ith index is greater than the jth index then we know this current number is part of the numbers below the diagonal
                if( i > j ) {

                    // Add it to the lower triangular sum
                    lowerTriangularSum += numbers[i][j];

                    // Check if it's odd
                    if( numbers[i][j] % 2 != 0 ) {

                        // If so, add it to the string that contains the odd numbers of the lower triangle
                        oddLowerTriangularNumbers += numbers[i][j] + " ";
                    }
                }
            }

            // Print for newline
            System.out.println();
        }

        // Print the output of the sum of prime numbers in the array
        System.out.println("2) Output the sum of prime numbers in the array.");
        System.out.println(sumOfPrimeNumbers);

        // Print the elements of the 1D array that contains the diagonals using the arrayToString() utility function
        System.out.println("3) Output the elements in the main diagonal.");
        System.out.println(arrayToString(diagonals));

        // Print the sum of the elements below the diagonal
        System.out.println("4) Output the sum of the elements below the diagonal.");
        System.out.println( lowerTriangularSum );

        // Print the sum of the numbers above the diagonal
        System.out.println("5) Output the sum of the elements above the diagonal.");
        System.out.println( upperTriangularSum );

        // Print the odd numbers found below the diagonal
        System.out.println("6) Output the odd numbers below the diagonal.");
        System.out.println(oddLowerTriangularNumbers);

        // Print the even numbers found above the diagonal
        System.out.println("7) Output the even numbers above the diagonal.");
        System.out.println(evenUpperTriangularNumbers);
    }

    // Utility function that checks if the number given is a prime number
    public static boolean isPrime( int number ) {

        // list of prime numbers between 11 and 73
        int[] primes = {11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73};

        // for each of the prime, if the given number is equal to the prime number, then return true
        for (int prime : primes) {
            if (number == prime) return true;
        }

        // otherwise it's not a prime number so return false
        return false;
    }

    // utility function that converts an array of integers into a string
    private static String arrayToString( int[] array ) {

        // Initialize result variable as String
        String result = "";

        // loop through the array
        for (int j : array) {
            // Add to result as string and add a space after
            result += j + " ";
        }

        // return the output string
        return result;
    }
}
