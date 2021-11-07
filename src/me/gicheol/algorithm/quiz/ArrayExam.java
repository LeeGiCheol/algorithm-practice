package me.gicheol.algorithm.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayExam {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 2, 3, 3, 4, 4};

        System.out.println(solution3(numbers));
    }

    private static Integer solution(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
            //map.merge(number, 1, Integer::sum);
        }

        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1) {
                return integer;
            }
        }
        return -1;
    }

    private static Integer solution2(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for (int number : numbers) {
            if (list.contains(number)) {
                list.remove((Integer) number);
            } else {
                list.add(number);
            }
        }

        return list.get(0);
    }

    private static Integer solution3(int[] numbers) {
        int uniqueNum = 0;

        for (int number : numbers) {
            uniqueNum ^= number;
        }

        return uniqueNum;
    }

}