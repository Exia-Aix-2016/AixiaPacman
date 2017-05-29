package fr.exia.aixiapacman.element.mobile;

import fr.exia.aixiapacman.element.Element;
import fr.exia.aixiapacman.element.Permeability;
import fr.exia.showboard.IPawn;

import java.io.IOException;

/**
 * Created by Mandel on 29/05/2017.
 */
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
    public Ghost(final int x, final int y, final fr.exia.aixiapacman.Map map) throws IOException {
        super(x, y, IMAGE, SPRITE, map, Permeability.BLOCKING);
    }

}
