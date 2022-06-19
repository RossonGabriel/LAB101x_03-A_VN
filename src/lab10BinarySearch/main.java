package lab10BinarySearch;

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

        //get user length of array
        int arrayLength = Math.abs(integerUtils.getIntFromUser(scanner, "Enter number of array:", "Please input a true integer"));
        int[] generatedArray = new int[arrayLength];

        //get user search value
        int searchValue = integerUtils.getIntFromUser(scanner, "Enter search value:", "Please input a true integer");

        /* generate a random number in array */
        for (int i = 0; i < arrayLength; i++) {
            generatedArray[i] = (int)Math.floor(Math.random() * (MAX_GENERATED_NUMBER - MIN_GENERATED_NUMBER) + MIN_GENERATED_NUMBER);
        }

        quickSort(generatedArray, 0, generatedArray.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(generatedArray));

        int searchValueIndex = runBinarySearch(generatedArray, searchValue, 0, generatedArray.length - 1);
        if (searchValueIndex == -1) {
            System.out.println("Can not found: " + searchValue);
        } else {
            System.out.println("Found " + searchValue + " at index: " + searchValueIndex);
        }
    }

    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
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

    public static int runBinarySearch(int[] sortedArray, int searchValue, int low, int high) {
        int middle = low  + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        if (searchValue == sortedArray[middle]) {
            return middle;
        } else if (searchValue < sortedArray[middle]) {
            return runBinarySearch(sortedArray, searchValue, low, middle - 1);
        } else {
            return runBinarySearch(sortedArray, searchValue, middle + 1, high);
        }
    }
}
