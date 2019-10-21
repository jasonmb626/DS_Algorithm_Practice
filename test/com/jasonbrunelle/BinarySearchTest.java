package com.jasonbrunelle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

   int[] initializeArray() {
        int[] arr = readIntArrayFromFile("input10.txt");
        sort(arr);
        return arr;
    }

    @Test
    void binarySearch() {
        int [] arr = initializeArray();
        int first, last, random;
        first = arr[0];
        last = arr[arr.length-1];
        random = 60;
        assertEquals(arr[0], arr[BinarySearch.binarySearch(arr, first)]);
        assertEquals(arr[arr.length-1], arr[BinarySearch.binarySearch(arr, last)]);
        assertEquals(random, arr[BinarySearch.binarySearch(arr, random)]);
    }

    @Test
    void binarySearchRecursive() {
        int [] arr = initializeArray();
        int first, last, random;
        first = arr[0];
        last = arr[arr.length-1];
        random = 60;
        assertEquals(arr[0], arr[BinarySearch.binarySearchRecursive(arr, first)]);
        assertEquals(arr[arr.length-1], arr[BinarySearch.binarySearchRecursive(arr, last)]);
        assertEquals(random, arr[BinarySearch.binarySearchRecursive(arr, random)]);
    }

    @Test
    void first() {
        int [] arr = initializeArray();
        int first = BinarySearch.first(arr, 60);
        assertEquals(60, arr[first]);
        if (first > 0)
            assertTrue(arr[first-1] < 60);
        else
            assertTrue(true);
    }

    @Test
    void last() {
        int [] arr = initializeArray();
        int last = BinarySearch.last(arr, 60);
        assertEquals(60, arr[last]);
        if (last < arr.length-1) {
            assertTrue(arr[last + 1] > 60);
        }
        else {
            assertTrue(true);
        }
    }

    static int[] readIntArrayFromFile(String localFileName) {
        List<Integer> list = new ArrayList<Integer>();
        File file = new File(localFileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                String[] strs = text.trim().split("\\s+");

                for (int i = 0; i < strs.length; i++) {
                    list.add(Integer.parseInt(strs[i]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        //print out the list
        int[] intArray = new int[list.size()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = list.get(i);
        }
        return intArray;
    }

    boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i+1] < arr[i]) return false;
        }
        return true;
    }
    // The following 3 methods facilitate the actual sorting.
    private int[] sort(int[] arr) {
        // First of recursive call
        return sort(arr, 0, arr.length-1);
    }

    private int[] sort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) { // Sort left half
            sort (arr, left, index - 1);
        }
        if (index < right) { // Sort right half
            sort(arr, index, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
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