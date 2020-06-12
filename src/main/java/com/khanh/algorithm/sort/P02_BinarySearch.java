package com.khanh.algorithm.sort;

// Java implementation of recursive Binary  Search
public class P02_BinarySearch {
    // Return index of x if it is present in arr[1..r], else return -1
    int binarySearch(int[] arr, int l, int r, int x) {
        if (l <= r) {
            int mid = l + ( r - l)/2;
            // If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;

            // If the element is smaller than mid, then it can
            // only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            // Else the element can only be present
            //  in the right subarray
            return binarySearch(arr, mid + 1, r, x);
        }
        // element is not present
        return -1;
    }

    public static void main(String[] args) {
        P02_BinarySearch ob = new P02_BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

}
