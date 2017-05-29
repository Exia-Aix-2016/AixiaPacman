package fr.exia.aixiapacman.element.motionless;

import fr.exia.aixiapacman.element.Permeability;

import java.io.IOException;

/**
 * <h1>The Class Macadam.</h1>
 *
 * @author Jade
 * @version 0.1
 */
class Macadam extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final char SPRITE = ' ';
    private static final String IMAGE = "macadam.jpg";

    /**
     * Instantiates a new macadam.
     */
    Macadam() {
        super(IMAGE, SPRITE, Permeability.PENETRABLE);
    }
}
