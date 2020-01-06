package l7.game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;
    //элементы смарт логики
    private static int[][] priority = new int [GameBoard.dimension][GameBoard.dimension];

    public GameActionListener(int row, int cell, GameButton gButton){
        this.row = row;
        this.cell = cell;
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        GameBoard board = button.getBoard();

        if(board.isTurnable(row, cell)){
            updateByPlayersData(board);

            if(board.isFull()){
                board.getGame().showMessage("Ничья!");
                board.emptyField();
                board.getGame().passTurn();

            }
            else if(!board.getGame().getCurrentPlayer().isRealPlayer()){
                updateByAIData(board);
            }
        }
        else {
            board.getGame().showMessage("Некорректный ход");
        }
    }


    /**
     * Ход человека
     * @param board GameBoard - ссылка на игровое поле
     */
    private void updateByPlayersData(GameBoard board){

        //обновить матрицу игры
        board.updateGameField(row, cell);

        //обновить содержимое кнопки
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if(board.checkWin()){
            button.getBoard().getGame().showMessage("Вы выиграли!");
            board.emptyField();
            //board.getGame().passTurn();// это?

        } else {
            board.getGame().passTurn();
        }
    }

    private void updateByAIData(GameBoard board){
        if(board.getMode()){
           smartAI(board);
        } else{
            randomAI(board);
        }


        //проверить победу
        if(board.checkWin()){
            button.getBoard().getGame().showMessage("Компьютер выиграл!");
            board.emptyField();
            //board.getGame().passTurn();// ???
        } else if(board.isFull()){
                board.getGame().showMessage("Ничья!");
                board.emptyField();
                //board.getGame().passTurn();
        }
        /*else{
            //передать ход
            board.getGame().passTurn();
        }*/
        board.getGame().passTurn();
    }

    private void randomAI(GameBoard board){
        //генерация координат хода компьютера
        int x, y;
        Random rnd = new Random();

        do{
            y = rnd.nextInt(GameBoard.dimension);
            x = rnd.nextInt(GameBoard.dimension);
        }
        while (!board.isTurnable(x, y));

        //обновить матрицу игры
        board.updateGameField(x, y);

        //обновить содержимое кнопки
        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
    }








    // Алгоритм умного компьютера
    public void smartAI(GameBoard board){
        int coY = 0;
        int coX = 0;
        clearPriority();
        int max = priority[coY][coX];

        // Проверка на соседей
        for(int i = 0; i < board.dimension; i++) {
            for (int j = 0; j < board.dimension; j++) {
                if (board.isTurnable(i, j)) {
                    priority[i][j] = 0;
                    priority[i][j] = checkNear(i, j, board);
                    if (nextTry(board.getGame().getCurrentPlayer().getPlayerSign(), i, j, board) == true){
                        priority[i][j] =+ 20;
                    }

                }
            }
        }
        for(int i = 0; i < GameBoard.dimension; i++) {
            for (int j = 0; j < GameBoard.dimension; j++){
                if(priority[i][j] > max && board.isTurnable(i, j)){
                    max = priority[i][j];
                    coY = i;
                    coX = j;
                }
            }
        }
        if(priority[coY][coX] == 0){
            randomAI(board);
        }else{
            board.updateGameField(coY, coX);
            //обновить содержимое кнопки
            int cellIndex = GameBoard.dimension * coY + coX;
            board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        }
    }

    /**
     * Очистка поля приоритета
     */

    private static void clearPriority() {
        priority = new int[GameBoard.dimension][GameBoard.dimension];
        for (int i = 0; i < GameBoard.dimension; i++) {
            for (int j = 0; j < GameBoard.dimension; j++) {
                priority[i][j] = 0;
            }
        }
    }

    // Проверка следующего хода на победу
    public static boolean nextTry (char playerSym, int i, int j, GameBoard board){
        board.updateGameFieldTest(i, j);

        if(board.checkWin('X') == true){
            board.updateGameFieldTestNull(i, j);
            return true;
        }
        board.updateGameFieldTestNull(i, j);
        return false;
    }


    // Проверка соседних ячеек на символы ИИ и заполнение массива статистики
    public static int checkNear(int i, int j, GameBoard board){
        int param = 0;
        for(int a = i-1; a < 2; a++){
            for(int b = j-1; b < 2; b++){
                if(a < 0 || b < 0 || a > GameBoard.dimension-1 || b > GameBoard.dimension-1){
                    break;
                }else if(board.getFieldData(a, b) == 'O'){
                    param ++;
                }
            }
        }
        return param;
    }
}
