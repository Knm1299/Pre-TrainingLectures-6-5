package com.revature;

import java.util.Arrays;
import java.util.Scanner;

/**
 * More common algorithms
 * 
 * 2 sorting
 * 
 *      Bubble
 *          O(n^2)
 *          Not usually used, very slow
 *          This sort compares each element in the array, swapping their positions if necessary
 *          Requires multiple iterations over the array to ensure that all elements are sorted
 *          sometimes a common interview question
 * 
 * 
 *      Merge
 *          O(nlog(n)) - O of n times log n, the first n is included since it is multiplicative and based on the scaling factor rather than additive
 *          slightly more common, though more complex to write
 *          works recursively
 * 
 * 
 * 
 *  Not implemented today:
 * 
 *      Quicksort
 *          commonly used, will show where it's built-in
 * 
 *      Radix
 *          O(nd) - d is the number of digits in the largest number
 *          Uses the significant digits of a number to sort it
 * 
 * 
 * 2 searching
 *      
 *      Linear
 *          O(n)
 *          Simplest search
 *          Another common interview question
 *          check if each element == the target, if so return the current index
 * 
 *      Binary 
 *          O(log n)
 *          Divide and conquer, similar idea to Merge except this is a search
 *          Splits the array in half to check each sub-array
 * 
 */
public class App 
{
    public static void main( String[] args )
    {
        //Creating and filling an array based on user input
        int[] input;
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the array size: ");
        input = new int[sc.nextInt()];
        for(int i = 0;i<input.length; i++){
            System.out.println("Please enter the next element: ");
            input[i] = sc.nextInt();
            // input[i] = (int)(Math.random() * 200);
        }


        //sorting an array in place using merge sort
        // mergeSort(input, 0, input.length - 1);
        // bubbleSort(input);
        Arrays.sort(input);
        // System.out.println(Arrays.binarySearch(input, 0, input.length, 5));


        System.out.print("[ ");
        for(int i : input){
            System.out.print(i + ", ");
        }
        System.out.print(" ]");


    }

    public static void bubbleSort(int[] input){
        boolean swapMade = false;

        for(int i = 0; i < input.length; i++){
            swapMade = false;

            for(int j = 0; j < input.length -i -1; j++){

                if(input[j] > input[j + 1]){
                    int temp = input[j+1];

                    input[j+1] = input[j];

                    input[j] = temp;

                    swapMade = true;
                }

            }

            if(!swapMade)return;
        }


    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Recursively sort the left and right sub-arrays
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Merge the sorted sub-arrays
            merge(arr, left, middle, right);
        }
    }
    
    public static void merge(int[] arr, int left, int middle, int right) {
        // Find the sizes of the left and right sub-arrays
        int n1 = middle - left + 1;
        int n2 = right - middle;
    
        // Create temporary arrays to hold the left and right sub-arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
    
        // Copy the elements of the left and right sub-arrays into the temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[middle + 1 + j];
        }
    
        // Merge the temporary arrays back into the original array
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
    
        // Copy any remaining elements from the left sub-array
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
    
        // Copy any remaining elements from the right sub-array
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static int binarySearch(int[] A, int N) {
      
        int lowestPossibleLoc = 0;
        int highestPossibleLoc = A.length - 1;
        
        while (highestPossibleLoc >= lowestPossibleLoc) {
           int middle = (lowestPossibleLoc + highestPossibleLoc) / 2;
           if (A[middle] == N) {
                     // N has been found at this index!
              return middle;
           }
           else if (A[middle] > N) {
                     // eliminate locations >= middle
              highestPossibleLoc = middle - 1;
           }
           else {
                     // eliminate locations <= middle
              lowestPossibleLoc = middle + 1;   
           }
        }
        
        // At this point, highestPossibleLoc < lowestPossibleLoc,
        // which means that N is known to be not in the array.  Return
        // a -1 to indicate that N could not be found in the array.
        return -1; 
    }

    public static int linearSearch(int[] input, int target){
        for(int i = 0; i< input.length; i++){
            if(input[i] == target){
                return i;
            }
        }
        return -1;
    }

}
