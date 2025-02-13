package com.javolife.game;

/**
 * This class implements the board for the Game.
 *
 * @author Zachary Pedigo
 */
public class GameBoard {
    private int rows;
    private int cols;
    private IGameCell[][] matrix;

    /**
     * Constructs an instance of GameBoard with given values.
     *
     * @param rows Integer number of rows in board.
     * @param cols Integer number of columns in board.
     */
    public GameBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        clear();
    }

    /**
     * Constructs an instance of GameBoard with given values.
     *
     * @param rows   Integer number of rows in matrix.
     * @param cols   Integer number of cols in matrix.
     * @param matrix Two-dimensional ArrayList of GameCell instances.
     */
    public GameBoard(int rows, int cols, IGameCell[][] matrix) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = matrix;
    }

    /**
     * @param row Integer value of desired row in GameBoard.
     * @return The desired row in the GameBoard.
     */
    public IGameCell[] getRow(int row) {
        return matrix[row];
    }

    /**
     * Clears the GameBoard by setting the state of all GameCell instances to inactive.
     */
    public void clear() {
        IGameCell[][] board = new IGameCell[rows][cols];
        for (int i = 0; i < rows; i++) {
            IGameCell[] column = new IGameCell[cols];
            for (int j = 0; j < cols; j++) {
                column[j] = GameCell.createGameCell(false);
            }
            board[i] = column;
        }
        matrix = board;
    }

    /**
     * Creates a random GameBoard by constructing each GameCell instance with a random state.
     */
    public void randomize(double density) {
        IGameCell[][] board = new IGameCell[rows][cols];
        for (int i = 0; i < rows; i++) {
            IGameCell[] column = new IGameCell[cols];
            for (int j = 0; j < cols; j++) {
                double value = density / 100d;
                column[j] = GameCell.createGameCell(Math.random() < value);
            }
            board[i] = column;
        }
        matrix = board;
    }
}
