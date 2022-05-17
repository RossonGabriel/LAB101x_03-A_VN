package lab9MergeSort;

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
        mergeSort(generatedArray, arrayLength);
        System.out.println("Sorted array: " + Arrays.toString(generatedArray));
    }

    private static void mergeSort(int[] array, int arrayLength) {
        if (arrayLength < 2) {
            return;
        }
        int mid = arrayLength / 2;
        int[] left = new int[mid];
        int[] right = new int[arrayLength - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < arrayLength; i++) {
            right[i - mid] = array[i];
        }
        mergeSort(left, mid);
        mergeSort(right, arrayLength - mid);

        merge(array, left, right, mid, arrayLength - mid);
    }

    private static void merge(int[] array, int[] left, int[] right, int leftLength, int rightLength) {
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            }
            else {
                array[k++] = right[j++];
            }
        }
        while (i < leftLength) {
            array[k++] = left[i++];
        }
        while (j < rightLength) {
            array[k++] = right[j++];
        }
    }
}
