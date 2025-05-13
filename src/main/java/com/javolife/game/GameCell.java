package com.javolife.game;

import java.util.ArrayList;

/**
 * The Cell object that makes up the Cellular Automata.
 *
 * @author Zachary Pedigo
 */
public class GameCell implements IGameCell {
    private int x;
    private int y;
    private boolean state;
    private ArrayList<IGameCell> adjacentCells;

    private GameCell() {
        this.state = false;
    }

    private GameCell(boolean state) {
        this.state = state;
    }

    /**
     * Constructs the GameCell instance.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param state The state of the GameCell instance.
     */
    private GameCell(int x, int y, boolean state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    /**
     * Static method to construct a GameCell instance.
     *
     * @param x Integer x coordinate of GameCell instance.
     * @param y Integer x coordinate of GameCell instance.
     * @param state boolean state of GameCell instance.
     * @return instance of GameCell.
     */
    public static GameCell createGameCell(int x, int y, boolean state) {
        return new GameCell(x, y, state);
    }

    @Override
    public boolean getState() {
        return state;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public ArrayList<IGameCell> getAdjacentCells() {
        return adjacentCells;
    }

    public void addAdjacentCell(IGameCell cell) {
        adjacentCells.add(cell);
    }
}
