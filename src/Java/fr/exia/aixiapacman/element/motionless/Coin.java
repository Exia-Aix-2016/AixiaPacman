package fr.exia.aixiapacman.element.motionless;

import fr.exia.aixiapacman.element.Permeability;

public class Coin extends MotionlessElement {

    /** The Constant SPRITE. */
private static final char SPRITE = '|';
    private static final String IMAGE = "coin.png";

    /**
     * Instantiates a new ditch.
     */
    Coin(){
        super(IMAGE, SPRITE, Permeability.BLOCKING);
    }
}
