package lab13Fibonacci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class main {
    static int n1 = 0, n2 = 1;

    public static void main(String[] args) {
        int count = 46;
        System.out.printf("The %d sequence fibonacci:\n", count - 1);

        printFibonacci(count);
    }

    static void printFibonacci(int count){
        if (count > 1) {
            System.out.print(n1 + ", ");
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;

            printFibonacci(count-1);
        } else if (count == 1) {
            System.out.print(n1);
        }
    }
}
