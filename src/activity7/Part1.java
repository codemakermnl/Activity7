package activity7;

import java.util.Random;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        // part 1
        // initialize scanner
        Scanner sc = new Scanner(System.in);
        // prompt the user for the number of elements
        System.out.print("Input the number of elements: ");

        // get the number of elements from the user
        int numberOfElements = sc.nextInt();

        // initialize listA as a 1-D array, with size of the number of elements entered
        int[] listA = new int[numberOfElements];

        // // initialize listB as a 1-D array, with size of the number of elements entered
        int[] listB = new int[numberOfElements];

        // initialize listC as a 1-D array, with size of the number of elements entered
        int[] listC = new int[numberOfElements];

        // initialize Random class
        Random randomGenerator = new Random();

        // initialize upper bound (max+1) since it's exclusive
        int high = 70;

        // initialize lower bound
        int low = 5;

        // print headers
        System.out.println("\t\tList A\t\tList B\t\tList C");

        // loop through the number of elements
        for( int i = 0; i < numberOfElements; i++ ) {

            // get random number using the upper and lower bounds and assign to each element of listA
            listA[i] = randomGenerator.nextInt(high-low) + low;

            // get random number using the upper and lower bounds and assign to each element of listB
            listB[i] = randomGenerator.nextInt(high-low) + low;

            // get the product of current element of listA and listB respectively, and store to element of listC
            listC[i] = listA[i] * listB[i];

            // print the three elements from the three arrays separated by tabs
            System.out.println("\t\t" + listA[i] + "\t\t\t" + listB[i] + "\t\t\t" + listC[i]);
        }
    }
}
