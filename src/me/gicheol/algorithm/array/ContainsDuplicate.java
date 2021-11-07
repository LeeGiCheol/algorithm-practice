package me.gicheol.algorithm.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6 };
//        int[] array = { 1, 1, 2, 2, 3, 1 };
        System.out.println(solution3(array));
    }

    /*
        시간복잡도 : O(n2)
        공간복잡도 : O(1)
     */
    private static boolean solution(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    /*
        시간복잡도 : O(NlogN)
        공간복잡도 : O(logN)
     */
    private static boolean solution2(int[] array) {
        quickSort(array, 0, array.length - 1);

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] == array[i]) {
                return true;
            }
        }

        return false;
    }

    /*
        시간복잡도 : O(n)
        공간복잡도 : O(n)
     */
    private static boolean solution3(int[] array) {
        Set<Integer> numberSet = new HashSet<>();

        for (int i : array) {
            if (numberSet.contains(i)) {
                return true;
            } else {
                numberSet.add(i);
            }
        }
        return false;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = partition(arr, start, end);

            quickSort(arr, start, mid - 1);
            quickSort(arr, mid + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int index = start;
        int pivot = end;

        for (int i = start; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }

        swap(arr, index, pivot);

        return index;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
