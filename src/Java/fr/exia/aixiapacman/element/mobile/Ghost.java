package fr.exia.aixiapacman.element.mobile;

import fr.exia.aixiapacman.Map;
import fr.exia.aixiapacman.element.Permeability;

import java.io.IOException;

public class Ghost extends Mobile {
    /** The Constant SPRITE. */
    private static final char SPRITE = 'H';
    private static final String IMAGE = "ghost.png";

    /**
     * Instantiates a new Ghost.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param map
     *            the map
     */
    public Ghost(final int x, final int y, final Map map) throws IOException {
        super(x, y, IMAGE, SPRITE, map, Permeability.BLOCKING);
    }

}
