package lab5BubbleSort;

import utils.integerUtils;

import java.util.Arrays;
import java.util.Scanner;

import static utils.constant.MAX_GENERATED_NUMBER;

public class main {
    public static void main(String[] args) {
        startProgram();
    }

    private static void startProgram() {
        Scanner scanner = new Scanner(System.in);

        int arrayLength = integerUtils.getIntFromUser(scanner, "Enter number of array:", "Please input a true integer");
        int[] unsortedArray = new int[arrayLength];

        /* generate a random number in array */
        for (int i = 0; i < arrayLength; i++) {
            unsortedArray[i] = (int)Math.floor(Math.random() * MAX_GENERATED_NUMBER);
        }

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));
        int[] sortedArray = bubbleSort(unsortedArray);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }

    private static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }
}
