package fr.exia.aixiapacman.element.mobile;

import fr.exia.aixiapacman.element.Permeability;

import java.awt.*;
import java.io.IOException;

/**
 * <h1>PacMan.</h1>
 *
 * @author Mandel Vaubourg
 * @version 0.1
 */
public class PacMan extends Mobile {

    /** The Constant SPRITE. */
    private static final char SPRITE = 'H';
    private static final String IMAGE = "Pacman.png";
    private char direction = 'e';

    /**
     * Instantiates a new PacMan.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param map
     *            the map
     */
    public PacMan(final int x, final int y, final fr.exia.aixiapacman.Map map) throws IOException{
        super(x, y, IMAGE, SPRITE, map, Permeability.BLOCKING);
    }

    @Override
    public Image getImage() {
        this.setImageName("pacman_" + this.direction + ".png");
        try {
            this.loadImage();
        } catch (Exception e){

        }
        return super.getImage();
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }
}
