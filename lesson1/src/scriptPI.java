package src;

import sun.awt.geom.AreaOp;

import java.util.Scanner;

public class scriptPI {
    public static void main(String args[]) {

        byte a = 127;
        short b = 32767;
        int c = 2147483647;
        long d = 922 * 24 * 608 * 60;
        float e = 66.66f;
        double f = 3.14159;
        char g = 'G';
        boolean h = true;
        String k = "string";

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(k);

        System.out.println(getSum(2, 55, 5, 6));

        System.out.println(getNumber(3, 15));

        System.out.println(getNum(-73534));

        System.out.println(getBoolNumber(-256));

        System.out.println(getString("Sergey"));

        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите год >>>");
        int yearInput = userInput.nextInt();
        System.out.println(getYear(yearInput));
    }

    static int getSum(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    static boolean getNumber(int num1, int num2) {
        int numS = num1 + num2;
        if (numS >= 10 && numS <= 20) {
            return true;
        } else {
            return false;
        }
    }

    static String getNum(int nunB) {
        if (nunB >= 0) {
            return nunB + " положительное число";
        } else {
            return nunB + " отрицательное число";
        }
    }

    static boolean getBoolNumber(int boolNumber) {
        if (boolNumber < 0) {
            return true;
        } else {
            return false;
        }
    }

    static String getString(String getName) {
        return "Привет " + getName;
    }

    static String getYear(int yearLeap) {
        if (((yearLeap % 4 == 0) && !(yearLeap % 100 == 0)) || (yearLeap % 400 == 0))
            return yearLeap + " год, является високосным";
        else
            return yearLeap + " год, не является високосным";
    }
}