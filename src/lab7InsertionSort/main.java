package lab7InsertionSort;

import utils.integerUtils;

import java.util.Arrays;
import java.util.Scanner;

import static utils.constant.MAX_GENERATED_NUMBER;
import static utils.constant.MIN_GENERATED_NUMBER;

public class main {
    public static void main(String[] args) {
        startProgram();
    }

    private static void startProgram() {
        Scanner scanner = new Scanner(System.in);

        int arrayLength = Math.abs(integerUtils.getIntFromUser(scanner, "Enter number of array:", "Please input a true integer"));
        int[] generatedArray = new int[arrayLength];

        /* generate a random number in array */
        for (int i = 0; i < arrayLength; i++) {
            generatedArray[i] = (int)Math.floor(Math.random() * (MAX_GENERATED_NUMBER - MIN_GENERATED_NUMBER) + MIN_GENERATED_NUMBER);
        }

        System.out.println("Unsorted array: " + Arrays.toString(generatedArray));
        insertionSort(generatedArray);
        System.out.println("Sorted array: " + Arrays.toString(generatedArray));
    }

    public static void insertionSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j-1;
            while ((i > -1) && (array[i] > key)) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }
}
