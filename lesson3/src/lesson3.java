import java.util.Random;
import java.util.Scanner;

public class lesson3 {
    private static char[][] map;  //матрица игры
    private static int SIZE = 3;   // размерность поля

    private static final char DOT_EMPTY = '-';   //пустой символ - свободное поле
    private static final char DOT_X = 'X';   //крестик
    private static final char DOT_O = 'O';   //нолик
    private static final boolean SILLY_MODE = false;
    private static int[][] ratingArray = new int[SIZE][SIZE];

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn(); // ход человека
            if (isEndGame(DOT_X)) {
                break;
            }

            computerTurn(); //ход компьютера
            if (isEndGame(DOT_O)) {
                break;
            }
        }

        System.out.println("Игра закончена");
    }

    /**
     * Метод подготовки игрового поля
     */
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    /**
     * Ход человека
     */
    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты ячейки (X Y)");
            y = scanner.nextInt() - 1; // Считывание номера строки
            x = scanner.nextInt() - 1; // Считывание номера столбца
        }
        while (!isCellValid(x, y));

        map[y][x] = DOT_X;
    }

    /**
     * Ход компьютера
     */
//    private static void computerTurn() {
//        int x = -1;
//        int y = -1;
//
//        do {
//            x = random.nextInt(SIZE);
//            y = random.nextInt(SIZE);
//        } while (!isCellValid(x, y));
//
//        System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
//        map[y][x] = DOT_O;
//    }
    private static void computerTurn() {
        int x = 0;
        int y = 0;
        if (SILLY_MODE) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
            map[y][x] = DOT_O;
            System.out.println("Компьютер сделал ход с координатой " + (y + 1) + " " + (x + 1));
        } else {  //логика умного компьютера
            int count = 0;
            String str = " ";
            for (int i = 0; i < SIZE; i++) {
                if (str == "Победа компьютера")
                    break;
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) {
                        count = 0;
                        if (isWinComputer(i, j)) { //проверка победы компьютера в данной точке?
                            y = i;
                            x = j;
                            str = "Победа компьютера";
                            break;
                        } else if (isWinHuman(i, j)) {   //проверка победы человека в данной точке.
                            y = i;
                            x = j;
                            count = 10;               //рейтинг клетки ставим 10
                        } else {    /*вычислим рейтинг клетки. Максимальное значение = 8.
                        создаем массив - окружение клетки(клетку окружает максимум 8 валидных клеток) createsRatingArray(i,j)*/


                            int[][] round = {{i - 1, j - 1}, {i - 1, j}, {i - 1, j + 1},

                                    {i, j - 1}, {i, j + 1},

                                    {i + 1, j - 1}, {i + 1, j}, {i + 1, j + 1}};
                            for (int[] check : round) {
                                y = check[0];
                                x = check[1];
                                if (isCellValidForRating(x, y) && map[y][x] == DOT_O)//подсчет "О" в соседних клетках
                                    count++;
                            }
                        }

                    } else {//в случае если клетка не пустая рейтинг клетки установим -1
                        count = -1;
                    }
                    ratingArray[i][j] = count; //заполняем массив - рейтинг каждой клетки
                }
            }
            if (str == "Победа компьютера") {
                map[y][x] = DOT_O;
                System.out.println("Компьютер сделал ход с координатой " + (y + 1) + " " + (x + 1));
            } else {
                //поиск максимального значения в массиве - рейтинг клетки
                int ratingMax = 0;
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (ratingArray[i][j] >= ratingMax) {
                            ratingMax = ratingArray[i][j];
                            y = i;
                            x = j;
                        }
                    }
                }
                map[y][x] = DOT_O;
                System.out.println("Компьютер сделал ход с координатой " + (y + 1) + " " + (x + 1));
            }
        }
    }

    private static boolean isWinComputer(int i, int j) {
        boolean result = false;
        map[i][j] = DOT_O;
        if (isWin(DOT_O)) {
            result = true;
        }
        map[i][j] = DOT_EMPTY;
        return result;
    }

    private static boolean isWinHuman(int i, int j) {
        boolean result = false;
        map[i][j] = DOT_X;
        if (isWin(DOT_X)) {
            result = true;
        }
        map[i][j] = DOT_EMPTY;
        return result;
    }

    private static boolean isCellValidForRating(int x, int y) {
        boolean result = true;
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            result = false;
        }
        return result;
    }

    private static boolean isWin(char playerSymbol) {
        boolean result1 = false;
        /*if (    map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol ||
                map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol ||
                map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol ||
                map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol ||
                map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol ||
                map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol ||
                map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol ||
                map[0][2] == playerSymbol && map[1][1] == playerSymbol && map[2][0] == playerSymbol){

            result1 = true;
        }*/
        int winSting = 0;
        int winColumn = 0;
        int windDiagonal1 = 0;
        int windDiagonal2 = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                winSting += (map[i][j] == playerSymbol) ? 1 : 0;
                winColumn += (map[j][i] == playerSymbol) ? 1 : 0;
                windDiagonal1 += (map[j][j] == playerSymbol) ? 1 : 0;
                windDiagonal2 += (map[j][SIZE - 1 - j] == playerSymbol) ? 1 : 0;
            }
            if (winSting == SIZE || winColumn == SIZE || windDiagonal1 == SIZE || windDiagonal2 == SIZE) {
                result1 = true;
                return result1;
            }
            winSting = 0;
            winColumn = 0;
            windDiagonal1 = 0;
            windDiagonal2 = 0;

        }
        return result1;
    }

    public static boolean isCellValid(int x, int y) {
        boolean result = true;

        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            result = false;
        }

        if (map[y][x] != DOT_EMPTY) {
            result = false;
        }

        return result;
    }

    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;

        printMap();

        //проверяем необходимость следующего хода
        if (checkWin(playerSymbol)) {
            System.out.println("Победители " + playerSymbol);
            result = true;
        }

        if (isMapFull()) {
            System.out.println("Ничья");
            result = true;
        }

        return result;
    }

    private static boolean isMapFull() {
        boolean result = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    result = false;
            }
        }
        return result;
    }


    private static boolean checkWin(char playerSymbol) {
        boolean result = false;

        if (
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                        (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                        (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                        (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)) {
            result = true;
        }

        return result;
    }

}
