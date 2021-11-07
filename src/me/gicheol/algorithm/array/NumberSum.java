package me.gicheol.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberSum {

    public static void main(String[] args) {
        int[] number = {2, 3, 5, 7};
        int target = 14;

        System.out.println(Arrays.toString(solution3(number, target)));
    }

    /*
        시간복잡도 : O(n2)
        공간복잡도 : O(1)
     */
    private static int[] solution(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    /*
        시간복잡도 : O(n)
        공간복잡도 : O(n)
     */
    private static int[] solution2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int numberToFind = target - numbers[i];

            if (map.containsKey(numberToFind) && map.get(numberToFind) != i) {
                return new int[] { i, map.get(numberToFind) };
            }

            map.put(numbers[i], i);
        }

        return null;
    }


    // 배열의 3가지 수를 더해서 target 값 찾기
    /*
        시간복잡도 : O(n2)
        공간복잡도 : O(n)
     */
    private static int[] solution3(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int numberToFind = target - numbers[i] - numbers[j];

                if (map.containsKey(numberToFind) && map.get(numberToFind) != i && map.get(numberToFind) != j) {
                    return new int[]{i, j, map.get(numberToFind)};
                }
            }
            map.put(numbers[i], i);
        }

        return null;
    }

}
