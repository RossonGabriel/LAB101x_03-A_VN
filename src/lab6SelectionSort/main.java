package lab6SelectionSort;

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
        int[] unsortedArray = new int[arrayLength];

        /* generate a random number in array */
        for (int i = 0; i < arrayLength; i++) {
            unsortedArray[i] = (int)Math.floor(Math.random() * (MAX_GENERATED_NUMBER - MIN_GENERATED_NUMBER) + MIN_GENERATED_NUMBER);
        }

        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));
        int[] sortedArray = selectionSort(unsortedArray);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }

    public static int[] selectionSort(int[] array){
        for (int i = 0; i < array.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
        return array;
    }
}
