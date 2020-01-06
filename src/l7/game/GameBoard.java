package l7.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {
    static final int dimension = 3; //размерность
    static int cellSize = 150; //размер одной клетки
    private char[][] gameField; //матрица игры
    private GameButton[] gameButtons; //массив кнопок

    private Game game; //ссылка на игру

    static char nullSymbol = '\u0000'; //null символ

    //элементы смарт логики
    //protected static int[][] priority;
    protected static final boolean smartMode = true;



    public GameBoard(Game currentGame) {
        this.game = currentGame;
        initField();
    }

    protected boolean getMode(){
        return smartMode;
    }
    protected char getFieldData(int x, int y){
        return gameField[x][y];
    }

    /**
     * Метод инициации и отрисовки игрового поля
     */
    private void initField() {
        //задаем основные настройки окна игры
        setBounds(cellSize * dimension, cellSize * dimension, 400, 300);
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        JPanel controlPanel = new JPanel(); //панель управления игрой
        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(newGameButton);
        controlPanel.setSize(cellSize * dimension, 150);

        JPanel gameFieldPanel = new JPanel(); //панель самой игры
        gameFieldPanel.setLayout(new GridLayout(dimension, dimension));
        gameFieldPanel.setSize(cellSize * dimension, cellSize * dimension);

        gameField = new char[dimension][dimension];
        gameButtons = new GameButton[dimension * dimension];

        //инициализируем игровое поле
        for (int i = 0; i < (dimension * dimension); i++) {
            GameButton fieldButton = new GameButton(i, this);
            gameFieldPanel.add(fieldButton);
            gameButtons[i] = fieldButton;
        }

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Метод очистки поля и матрицы игры
     */
    void emptyField() {
        for (int i = 0; i < (dimension * dimension); i++) {
            gameButtons[i].setText("");

            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;

            gameField[x][y] = nullSymbol;
        }

    }


    /**
     * что ты такое
     *
     * @return
     */
    Game getGame() {
        return game;
    }

    /**
     * Метод проверки доступности клетки для хода
     *
     * @param x по горизонтали
     * @param y по вертикали
     * @return boolean
     */
    boolean isTurnable(int x, int y) {
        boolean result = false;
        if (gameField[y][x] == nullSymbol)
            result = true;
        return result;
    }

    /**
     * Обновление матрицы игры после хода
     *
     * @param x по горизонтали
     * @param y по вертикали
     */
    void updateGameField(int x, int y) {
        gameField[y][x] = game.getCurrentPlayer().getPlayerSign();
    }
    void updateGameFieldTest(int x, int y) {
        gameField[y][x] = 'X';
    }
    void updateGameFieldTestNull(int x, int y) {
        gameField[y][x] = nullSymbol;
    }
    /**
     * Проверка победы по столбцам и линиям
     *
     * @return флаг победы
     */
    boolean checkWin() {
        boolean result = false;

        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();

        if (checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol)) {
            result = true;
        }
        return result;
    }
    boolean checkWin(char x) {
        boolean result = false;

        char playerSymbol = x;

        if (checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol)) {
            result = true;
        }
        return result;
    }


    /**
     * Метод проверки заполненности поля
     *
     * @return boolean
     */
    boolean isFull() {
        boolean result = true;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (gameField[i][j] == nullSymbol) {
                    result = false;
                    break;
                }
            }
            if (!result) {
                break;
            }
        }

        return result;
    }

    /**
     * Проверка победы по столбцам и линиям
     *
     * @return флаг победы
     */
    private boolean checkWinLines(char playerSymbol) {
        boolean cols, rows, result;

        result = false;

        for (int col = 0; col < dimension; col++) { //цикл1
            cols = true;
            rows = true;

            for (int row = 0; row < dimension; row++) { //цикл2
                cols &= (gameField[col][row] == playerSymbol);
                rows &= (gameField[row][col] == playerSymbol);
            }

            // если выигрышная комбинация найдена - прекращаем проверять
            if (cols || rows) { //
                result = true;
                //break; //зачем??
            } //проверяем наличие комбинации

            if (result) {
                break;
            }//выходим из цикла1
        }
        return result;
    }


    /**
     * Проверка победы по диагоналям
     *
     * @return флаг победы
     */
    private boolean checkWinDiagonals(char playerSymbol) {
        boolean diagonal1, diagonal2, result;
        diagonal1 = true;
        diagonal2 = true;
        result = true;

        for (int i = 0; i < dimension; i++) {
            diagonal1 &= (gameField[i][i] == playerSymbol);
            diagonal2 &= (gameField[i][dimension - 1 - i] == playerSymbol);

            if (!diagonal1 && !diagonal2) { //
                result = false;
                break;
            }
        }

        return result;
    }

    public GameButton getButton(int buttonIndex) {
        return gameButtons[buttonIndex];
    }





}