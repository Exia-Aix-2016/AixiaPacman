package fr.exia.aixiapacman.element.mobile;

import fr.exia.aixiapacman.AixiaPacmanGame;
import fr.exia.aixiapacman.element.Permeability;

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
}
