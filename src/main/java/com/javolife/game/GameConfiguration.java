package com.javolife.game;

import javafx.scene.paint.Color;

import java.util.Objects;

/**
 * This class contains the configuration of the Game Engine.
 *
 * @author Zachary Pedigo
 */
public class GameConfiguration {
    private Color activeCellColor;
    private Color inactiveCellColor;
    private int rows;
    private int columns;
    private int cellSize;
    private int canvasWidth;
    private int canvasHeight;
    private double randomDensity;

    /**
     * Constructs an instance of the Game Configuration (Settings).
     *
     * @param activeCellColor Color of an active GameCell.
     * @param inactiveCellColor Color of an inactive GameCell.
     * @param rows Integer number of rows in canvas.
     * @param columns Integer number of columns in canvas.
     * @param cellSize Integer size of GameCell.
     */
    public GameConfiguration(Color activeCellColor, Color inactiveCellColor, int rows, int columns,
                             int cellSize, int canvasWidth, int canvasHeight, double randomDensity) {
        this.activeCellColor = activeCellColor;
        this.inactiveCellColor = inactiveCellColor;
        this.rows = rows;
        this.columns = columns;
        this.cellSize = cellSize;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.randomDensity = randomDensity;
    }

    /**
     * @return The color of an active GameCell.
     */
    public Color getActiveCellColor() {
        return activeCellColor;
    }

    /**
     * @return The color of an inactive GameCell.
     */
    public Color getInactiveCellColor() {
        return inactiveCellColor;
    }

    /**
     * @return The number of rows in the GameBoard.
     */
    public int getRows() {
        return rows;
    }

    /**
     * @return The number of columns in the GameBoard.
     */
    public int getColumns() {
        return columns;
    }

    /**
     * @return The size of a GameCell.
     */
    public int getCellSize() {
        return cellSize;
    }

    /**
     * @return The width of the canvas.
     */
    public int getCanvasWidth() {
        return canvasWidth;
    }

    /**
     * @return The height of the canvas.
     */
    public int getCanvasHeight() {
        return canvasHeight;
    }

    public double getRandomDensity() {
        return randomDensity;
    }

    /**
     * Sets the color of an active GameCell.
     *
     * @param activeCellColor Color of an active GameCell.
     */
    public void setActiveCellColor(Color activeCellColor) {
        assert Objects.nonNull(activeCellColor);
        this.activeCellColor = activeCellColor;
    }

    /**
     * Sets the color of an inactive GameCell.
     *
     * @param inactiveCellColor Color of an inactive GameCell.
     */
    public void setInactiveCellColor(Color inactiveCellColor) {
        assert Objects.nonNull(inactiveCellColor);
        this.inactiveCellColor = inactiveCellColor;
    }

    /**
     * Sets the number of rows in the GameBoard.
     *
     * @param rows Integer number of rows in the GameBoard.
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Sets the number of columns in the GameBoard.
     *
     * @param columns Integer number of columns in the GameBoard.
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * Sets the size of a GameCell in the canvas.
     *
     * @param cellSize Integer size of a GameCell.
     */
    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    /**
     * Sets the size of the canvas.
     *
     * @param canvasWidth Integer size of the canvas.
     */
    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    /**
     * Sets the height of the canvas.
     *
     * @param canvasHeight Integer size of the canvas.
     */
    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }

    public void setRandomDensity(double randomDensity) {
        this.randomDensity = randomDensity;
    }
}
