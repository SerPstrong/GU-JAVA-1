import java.util.Scanner;

public class lesson2 {
    public static void main(String args[]) {

        System.out.print("1. Задать целочисленный массив, состоящий из элементов 0 и 1. " + "\n" +
                "Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;" + "\n");

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                System.out.print(arr[i] + " ");
            } else {
                arr[i] = 0;
                System.out.print(arr[i] + " ");
            }
        }

        System.out.print("\n" + "\n" + "2. Задать пустой целочисленный массив размером 8. " + "\n" +
                "С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;" + "\n");

        int[] arrEight = new int[8];

        int counter = 0;
        int i = 0;

        while (i < arrEight.length) {
            arrEight[i] += counter;
            i++;
            counter += 3;
        }

        for (int j = 0; j < arrEight.length; j++) {
            System.out.print(arrEight[j] + " ");
        }

        System.out.print("\n" + "\n" + "3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], " + "\n" +
                "пройти по нему циклом, и числа, меньшие 6, умножить на 2;" + "\n");

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i3 = 0; i3 < arr3.length; i3++) {

            if (arr3[i3] < 6) {
                arr3[i3] *= 2;
                System.out.print(arr3[i3] + " ");
            } else {
                System.out.print(arr3[i3] + " ");
            }
        }

        System.out.print("\n" + "\n" + "4. Создать квадратный двумерный целочисленный массив " + "\n" +
                "(количество строк и столбцов одинаковое)," + "\n" +
                " и с помощью цикла(-ов) заполнить его диагональные элементы единицами;" + "\n");

        int[][] table = new int[3][3];

        int counter4 = 1;
        for (int i4 = 0; i4 < 3; i4++) {
            for (int j4 = 0; j4 < 3; j4++) {
                table[i4][j4] = counter4;
                counter4++;
            }
        }
        printArr(table);

    }

    public static void printArr ( int[][] arr11){
        for (int i44 = 0; i44 < arr11.length; i44++) {
            for (int j44 = 0; j44 < arr11[i44].length; j44++) {
                System.out.println(arr11[i44][j44] + "\t");
            }
            System.out.println();
        }
    }
}
