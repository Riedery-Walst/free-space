package ru.andreev;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество строк");
        int N = in.nextInt();
        in.nextLine();

        System.out.println("Введите количество столбцов");
        int M = in.nextInt();
        in.nextLine();

        char[][] array = new char[N][M];

        char[] charLine = new char[M];

        System.out.println("Введите массив символами _ для свободных и * для занятых мест черз пробелы");
        for (int i = 0; i < N; i++) {
            String[] values = in.nextLine().split("\\s+");
            addToCharLine(values, charLine);

            System.arraycopy(charLine, 0, array[i], 0, M);
        }
        System.out.println(Arrays.deepToString(array));

        System.out.println(checkPlace(array, N, M));
    }

    public static void addToCharLine(String[] values, char[] charArray) {
        if (charArray.length != values.length)
            throw new RuntimeException("Размеры массивов не совпадают");

        for (int i = 0; i < values.length; i++) {
            if (values[i].length() == 1) {
                charArray[i] = values[i].charAt(0);
            } else {
                throw new RuntimeException("Вводите только по одному символу через пробелы");
            }
        }
    }

    public static int checkPlace(char[][] array, int N, int M) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] == '_') {
                    if (checkAround(array, i, j)) {
                        total++;
                    }
                }
            }
        }
        return total;
    }

    public static boolean checkAround(char[][] array, int i, int j) {
        return checkDown(array, i, j) && checkUp(array, i, j) && checkLeft(array, i, j) && checkRight(array, i, j);
    }

    public static boolean checkUp(char[][] array, int i, int j) {
        if (i - 1 >= 0) {
            return array[i - 1][j] == '_';
        } else return true;
    }

    public static boolean checkDown(char[][] array, int i, int j) {
        if (i + 1 < array.length) {
            return array[i + 1][j] == '_';
        } else return true;
    }

    public static boolean checkRight(char[][] array, int i, int j) {
        if (j + 1 < array[i].length) {
            return array[i][j + 1] == '_';
        } else return true;
    }

    public static boolean checkLeft(char[][] array, int i, int j) {
        if (j - 1 >= 0) {
            return array[i][j - 1] == '_';
        } else return true;
    }


}