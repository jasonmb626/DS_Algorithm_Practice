package com.jasonbrunelle;

public class SelectionSort {
    public static int[] selectionSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
        return arr;
    }
}
