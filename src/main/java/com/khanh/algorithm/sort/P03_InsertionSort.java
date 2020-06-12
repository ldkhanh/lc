package com.khanh.algorithm.sort;

import java.util.Arrays;

public class P03_InsertionSort {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j--];
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int arr[] = {12,11,13,5,6};
        P03_InsertionSort ob = new P03_InsertionSort();
        ob.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
