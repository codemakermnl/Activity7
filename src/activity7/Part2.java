package activity7;

import java.util.Arrays;
import java.util.Random;

public class Part2 {

    private static final int SIZE = 5;

    ///
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        int high = 76;
        int low = 10;

        int[][] numbers = new int[SIZE][SIZE];
        int[] diagonals = new int[SIZE];
        int upperTriangularSum = 0;
        int lowerTriangularSum = 0;
        String evenUpperTriangularNumbers = "";
        String oddLowerTriangularNumbers = "";

        System.out.println("1) Output the array elements");
        int sumOfPrimeNumbers = 0;
        for( int i = 0; i < SIZE; i++ ) {
            for(int j = 0; j < SIZE; j++) {
                numbers[i][j] = randomGenerator.nextInt(high-low) + low;
                System.out.print(numbers[i][j] + "\t");
                sumOfPrimeNumbers += isPrime( numbers[i][j] ) ? numbers[i][j] : 0;

                if( i == j ) diagonals[i] = numbers[i][j];

                // upper triangular
                if( i < j ) {
                    upperTriangularSum += numbers[i][j];
                    if( numbers[i][j] % 2 == 0 ) {
                        evenUpperTriangularNumbers += numbers[i][j] + " ";
                    }
                }

                // lower triangular
                if( i > j ) {
                    lowerTriangularSum += numbers[i][j];
                    if( numbers[i][j] % 2 != 0 ) {
                        oddLowerTriangularNumbers += numbers[i][j] + " ";
                    }
                }
            }
            System.out.println();
        }

        System.out.println("2) Output the sum of prime numbers in the array.");
        System.out.println(sumOfPrimeNumbers);

        System.out.println("3) Output the elements in the main diagonal.");
        System.out.println(arrayToString(diagonals));

        System.out.println("4) Output the sum of the elements below the diagonal.");
        System.out.println( lowerTriangularSum );

        System.out.println("5) Output the sum of the elements above the diagonal.");
        System.out.println( upperTriangularSum );

        System.out.println("6) Output the odd numbers below the diagonal.");
        System.out.println(oddLowerTriangularNumbers);

        System.out.println("7) Output the even numbers above the diagonal.");
        System.out.println(evenUpperTriangularNumbers);
    }

    public static boolean isPrime( int number ) {
        int[] primes = {11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73};
        for (int prime : primes) {
            if (number == prime) return true;
        }

        return false;
    }

    private static String arrayToString( int[] array ) {
        String result = "";
        for (int j : array) {
            result += j + " ";
        }

        return result;
    }
}
