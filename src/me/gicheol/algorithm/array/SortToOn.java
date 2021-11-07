package me.gicheol.algorithm.array;

import java.util.Arrays;

public class SortToOn {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {2, 5, 6, 9, 7, 1, 4, 3, 8, 0})));
    }

    private static int[] solution(int[] array) {
        boolean[] result = new boolean[100];

        for (int num : array) {
            result[num] = true;
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i]) {
                array[i] = i;
            }
        }
        return array;
    }

}
