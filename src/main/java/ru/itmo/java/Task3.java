package ru.itmo.java;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null){
            return new int[0];
        }

        int[] result = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            result[(i + 1) % inputArray.length] = inputArray[i];
        }

        return result;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }

        if (inputArray.length == 1) {
            return inputArray[0];
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int value : inputArray) {
            if (value > firstMax) {
                secondMax = firstMax;
                firstMax = value;
            } else if (value > secondMax) {
                secondMax = value;
            }
        }

        return firstMax * secondMax;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.isBlank() || input.isEmpty()) {
            return 0;
        }

        int countAB = 0;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == 'A' || symbol == 'a' || symbol == 'B' || symbol == 'b') {
                countAB++;
            }
        }

        return (int)((double)countAB/input.length() * 100);
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }

        for (int i = 0, j = input.length()-1; i < j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        char prevLetter = 0;
        int counter = 0;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == prevLetter) {
                counter++;
            }
            else {
                if (counter > 0) {
                    stringBuilder.append(counter);
                }
                stringBuilder.append(symbol);
                counter = 1;
                prevLetter = symbol;
            }
        }

        if (counter > 0) {
            stringBuilder.append(counter);
        }

        return stringBuilder.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() == 0 || two.length() == 0 || one.length() != two.length()) {
            return false;
        }

        char[] oneArr = one.toCharArray();

        char[] twoArr = two.toCharArray();

        Arrays.sort(oneArr);
        Arrays.sort(twoArr);

        return Arrays.equals(oneArr, twoArr);
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);

        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] == sArr[i-1]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null) {
            return new int[][] {{}, {}
            };
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = i + 1; j < m[i].length; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0) {
            return "";
        }
        if (separator == null) {
            separator = ' ';
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputStrings.length - 1; i++) {
            stringBuilder.append(inputStrings[i]);
            stringBuilder.append(separator);
        }
        stringBuilder.append(inputStrings[inputStrings.length-1]);

        return stringBuilder.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) {
            return 0;
        }

        int count = 0;

        outer:for (String value: inputStrings) {
            for (int i = 0; i < Math.min(value.length(), prefix.length()); i++) {
                if (value.charAt(i) != prefix.charAt(i)) {
                    continue outer;
                }
            }
            count++;
        }

        return count;
    }
}
