package me.gicheol.algorithm.array;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println(solution3("hello world".toCharArray()));
    }

    /*
        시간복잡도 : O(n)
        공간복잡도 : O(n)
     */
    private static char[] solution(char[] array) {
        char[] reversedMessage = new char[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            reversedMessage[array.length - 1 - i] = array[i];
        }

        return reversedMessage;
    }

    /*
        시간복잡도 : O(n)
        공간복잡도 : O(1)
     */
    private static char[] solution2(char[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        return array;
    }

    private static char[] solution3(char[] array) {
        StringBuilder sb = new StringBuilder(new String(array));
        return sb.reverse().toString().toCharArray();
    }

}
