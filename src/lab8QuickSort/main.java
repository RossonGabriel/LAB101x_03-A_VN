package lab8QuickSort;

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
        int[] sortedArray = quickSort(unsortedArray, 0, unsortedArray.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }

    public static int[] quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
        return arr;
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
