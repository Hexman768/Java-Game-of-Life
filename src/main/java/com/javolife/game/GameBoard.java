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
    private IGameCell[][] nextMatrix;

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
            for (int j = 0; j < cols; j++) {
                board[i][j] = GameCell.createGameCell(j, i, false);
            }
        }
        matrix = board;
    }

    /**
     * Creates a random GameBoard by constructing each GameCell instance with a random state.
     */
    public void randomize(double density) {
        IGameCell[][] board = new IGameCell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double value = density / 100d;
                board[i][j] = GameCell.createGameCell(j, i, Math.random() < value);
            }
        }
        matrix = board;
    }

    private void prepare() {
        nextMatrix = new IGameCell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nextMatrix[i][j] = GameCell.createGameCell(j, i, getNewCellState(matrix[i][j]));
            }
        }
    }

    /**
     * Core game loop.
     * Calls prepare method to create next generation matrix.
     * Then calls commit to commit those changes to memory.
     */
    public void update() {
        prepare();
        commit();
    }

    private void commit() {
        matrix = nextMatrix;
        nextMatrix = null;
    }

    private boolean getNewCellState(IGameCell cell) {
        int numberOfNeighbors = getLiveNeighbors(cell);
        if (numberOfNeighbors < 2) { return false; }
        else if (numberOfNeighbors > 3) { return false; }
        else if (numberOfNeighbors == 3) { return true; }
        else {
            // stay the same
            return cell.getState();
        }
    }

    private int getLiveNeighbors(IGameCell cell) {
        int sum=0;

        int row = cell.getY();
        int col = cell.getX();

        if (row != 0 && col != 0) {    //top left
            if(isAlive(row-1,col-1)) {
                sum++;
            }
        }

        if (row != 0) {
            if(isAlive(row-1,col)) { //top
                sum++;
            }
        }

        if (row != 0 && col != cols-1) {//top right
            if(isAlive(row-1,col+1)) {
                sum++;
            }
        }
        if (col != 0) {
            if(isAlive(row,col-1)) { //left
                sum++;
            }
        }

        if (col != cols-1) {
            if(isAlive(row,col+1)) { //right
                sum++;
            }
        }

        if (row != rows-1 && col != 0) {
            if(isAlive(row+1,col-1)) { //bottom left
                sum++;
            }
        }

        if (row != rows-1) {
            if(isAlive(row+1,col)) { //8
                sum++;
            }
        }

        if (row != rows-1 && col != cols-1) {
            if(isAlive(row+1,col+1)) { //9
                sum++;
            }
        }

        return sum;
    }

    private boolean isAlive(int row, int col) {
        return matrix[row][col].getState();
    }
}
