package com.khanh.algorithm.sort;

import java.util.Arrays;

public class P01_MergeSort {

    // Merge two sorted sub-arrays arr[low .. mid] and arr[mid + 1 .. high]
    public static void merge(int[] arr, int[] aux, int low, int mid, int high) {
        int k = low, i = low, j = mid + 1;
        // While there are elements in the left and right runs
        while (i <= mid && j <=  high) {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
            }
        }
        // copy remaining elements
        while (i <= mid) {
            aux[k++] = arr[i++];
        }
        // No  need to copy the second half
        // copy back to the original array to reflect sorted order
        for (i = low; i <= high; i++) {
            arr[i] = aux[i];
        }
    }
    // Function to check if arr is sorted in ascending order or not
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] > arr[i]) {
                System.out.println("MergeSort Fail");
                return false;
            }
        }
        return true;
    }

    // Sort array arr [low..high] using auxiliary array aux
    public static void mergeSort(int[] arr, int[] aux, int low, int high) {
        // Base case
        if (high == low) {      // if run size == 1
            return;
        }
        // find mid point
        int mid = (low + ((high - low) >> 1));

        // recursively split runs into two halves until run size == 1,
        // then merge them and return back up the call chain
        mergeSort(arr, aux, low, mid);      // split / merge left half
        mergeSort(arr, aux, mid + 1, high); // split / merge righ half
        merge(arr, aux, low, mid, high );       // merge the two half run
    }

    // Implementation of Merge Sort Algorithm in Java
    public static void main(String[] args) {
        int[] arr = {12,3,18,24,0,5,-2};
        int[] aux = Arrays.copyOf(arr, arr.length);
        // sort array 'arr' using auxiliary array 'aux'
        mergeSort(arr, aux, 0, arr.length - 1);
        if (isSorted(arr)) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
