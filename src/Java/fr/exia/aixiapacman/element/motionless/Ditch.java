package fr.exia.aixiapacman.element.motionless;

import fr.exia.aixiapacman.element.Permeability;

import java.io.IOException;

/**
 * <h1>The Class Ditch.</h1>
 *
 * @author Jade
 * @version 0.1
 */
class Ditch extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final char SPRITE = '|';
    private static final String IMAGE = "dirt.jpg";

    /**
     * Instantiates a new ditch.
     */
    Ditch(){
        super(IMAGE, SPRITE, Permeability.BLOCKING);
    }
}
