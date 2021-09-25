package activity7;

import java.util.Random;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        // part 1
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the number of elements: ");
        int numberOfElements = sc.nextInt();
        int[] listA = new int[numberOfElements];
        int[] listB = new int[numberOfElements];
        int[] listC = new int[numberOfElements];
        Random randomGenerator = new Random();
        int high = 70;
        int low = 5;

        System.out.println("\t\tList A\t\tList B\t\tList C");
        for( int i = 0; i < numberOfElements; i++ ) {
            listA[i] = randomGenerator.nextInt(high-low) + low;
            listB[i] = randomGenerator.nextInt(high-low) + low;
            listC[i] = listA[i] * listB[i];

            System.out.println("\t\t" + listA[i] + "\t\t\t" + listB[i] + "\t\t\t" + listC[i]);
        }
    }
}
