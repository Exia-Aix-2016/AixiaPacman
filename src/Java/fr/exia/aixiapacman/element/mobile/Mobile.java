package fr.exia.aixiapacman.element.mobile;

import fr.exia.aixiapacman.element.Element;
import fr.exia.aixiapacman.element.Permeability;
import fr.exia.showboard.IPawn;

import java.awt.*;
import java.io.IOException;

/**
 * <h1>The Class Mobile.</h1>
 *
 * @author Jade
 * @version 0.1
 */
abstract class Mobile extends Element implements IPawn {

    /**
     * The x.
     */
    private int     x;

    /**
     * The y.
     */
    private int     y;

    /** The alive. */
    private Boolean alive = true;

    /** The map. */
    private fr.exia.aixiapacman.Map map;

    Mobile(final String filename, final char sprite, final fr.exia.aixiapacman.Map map, final Permeability permeability) throws IOException{
        super(filename, sprite, permeability);
        this.setMap(map);
    }

    Mobile(final int x, final int y, final String filename, final char sprite, final fr.exia.aixiapacman.Map map, final Permeability permeability) throws IOException {
        this(filename, sprite, map, permeability);
        this.setX(x);
        this.setY(y);
    }

    /**
     * Move up.
     */
    public void moveUp() {
        this.setY(this.getY() - 1);
    }

    /**
     * Move left.
     */
    public void moveLeft() {
        this.setX(this.getX() - 1);
    }

    /**
     * Move down.
     */
    public void moveDown() {
        this.setY(this.getY() + 1);
    }

    /**
     * Move right.
     */
    public void moveRight() {
        this.setX(this.getX() + 1);
    }

    /**
     * Gets the x.
     *
     * @return the x
     */
    public final int getX() {
        return this.x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public final void setX(final int x) {
        this.x = x;
        if (this.isCrashed()) {
            this.die();
        }
    }

    /**
     * Gets the y.
     *
     * @return the y
     */
    public final int getY() {
        return this.y;
    }

    /**
     * Sets the y.
     *
     * @param y
     *            the new y, as the map is an infinite loop, there's a modulo
     *            based on the map height.
     */
    public final void setY(final int y) {
        this.y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
        if (this.isCrashed()) {
            this.die();
        }
    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    public fr.exia.aixiapacman.Map getMap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map
     *            the new map
     */
    private void setMap(final fr.exia.aixiapacman.Map map) {
        this.map = map;
    }

    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Die.
     */
    private void die() {
        this.alive = false;
    }

    /**
     * Checks if is crashed.
     *
     * @return the boolean
     */
    public Boolean isCrashed() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }

    public Point getPosition(){
        return new Point(this.getX(), this.getY());
    }
}
