package fr.exia.aixiapacman.element.motionless;

import fr.exia.aixiapacman.element.Permeability;

public class Floor extends MotionlessElement {
    /** The Constant SPRITE. */
    private static final char SPRITE = ' ';
    private static final String IMAGE = "floor.png";

    /**
     * Instantiates a new ditch.
     */
    Floor(){
        super(IMAGE, SPRITE, Permeability.BLOCKING);
    }

}
