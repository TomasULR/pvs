package oop.sorting;

import java.util.Arrays;
import java.util.Random;


interface ISortingAlgorithm {

    public void sort(int[] data);

}

class QuickSort implements ISortingAlgorithm {

    int split(int[] data, int left, int right) {
        int pivot = data[right];
        while
        (true) {
            while ((pivot > data[left]) && (left < right))
                left++;
            if (left < right) {
                data[right] = data[left];
                right--;
            } else break;
            while ((pivot < data[right]) && (left < right))
                right--;
            if (left < right) {
                data[left] = data[right];
                left++;
            } else break;
        }
        data[left] = pivot;
        return (left);
    }


    @Override
    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }


    public void quickSort(int[] data, int start, int end) {
        if (end <= start) return;
        int i = split(data, start, end);
        quickSort(data, start, i - 1);
        quickSort(data, i + 1, end);
    }

}

class InsertSort implements ISortingAlgorithm {

    @Override
    public void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int v = data[i];
            int j = i - 1;
            while ((j >= 0) && data[j] > v) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = v;
        }
    }

}

class BubbleSort implements ISortingAlgorithm {

    @Override
    public void sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}

class SelectionSort implements ISortingAlgorithm {

    @Override
    public void sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
    }
}


public class SortingTest {

    static int[] generateArray(int lenght){

        int[] arr = new int[lenght];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()* 1000000);
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] another = generateArray(100000);
        int[] an = Arrays.copyOf(another,100000);

        long t = System.currentTimeMillis();
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(another);
        long s = System.currentTimeMillis();
        System.out.println("cas " + (s - t) + " ms");

        t = System.currentTimeMillis();
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(an);
        s = System.currentTimeMillis();
        System.out.println("cas " + (s - t) + " ms");

    }
}
