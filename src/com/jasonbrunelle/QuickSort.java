package com.jasonbrunelle;

public class QuickSort {
    public static int[] quickSort(int[] arr) {
        // First of recursive call
        return quickSort(arr, 0, arr.length-1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) { // Sort left half
            quickSort (arr, left, index - 1);
        }
        if (index < right) { // Sort right half
            quickSort(arr, index, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2]; // Pick a pivot point
        while (left <= right) {
            // Find element on the lft that should be on the right
            while (arr[left] < pivot) left++;

            //Find element on the right that should be on the left
            while (arr[right] > pivot) right--;

            // Swap elements, and move left and right indices
            if (left <= right) {
                // Swap elements
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                // Move indices
                left++;
                right--;
            }
        }
        return left;
    }
}
