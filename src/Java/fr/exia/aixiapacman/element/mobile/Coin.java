package fr.exia.aixiapacman.element.mobile;

import fr.exia.aixiapacman.Map;
import fr.exia.aixiapacman.element.Permeability;

import java.io.IOException;

public class Coin extends Mobile {

    /** The Constant SPRITE. */
private static final char SPRITE = '|';
    private static final String IMAGE = "coin.png";

    /**
     * Instantiates a new ditch.
     */
    public Coin(final int x, final int y, final Map map) throws IOException{
        super(x, y, IMAGE, SPRITE, map, Permeability.FETCHABLE);
    }
}
