package com.javolife.game;

/**
 * This class defines the GameCell object that is used in the main game grid.
 *
 * @author Zachary Pedigo
 */
public interface IGameCell {
    /**
     * @return The boolean state of the GameCell.
     */
    public boolean getState();

    /**
     * @return The x coordinate of the GameCell.
     */
    public int getX() ;

    /**
     * @return The y coordinate of the GameCell.
     */
    public int getY();
}
