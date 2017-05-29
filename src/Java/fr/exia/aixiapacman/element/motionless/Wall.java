package fr.exia.aixiapacman.element.motionless;

import fr.exia.aixiapacman.element.Permeability;

public class Wall extends MotionlessElement{
    /** The Constant SPRITE. */
    private static final char SPRITE = 'X';
    private static final String IMAGE = "wall.png";

    /**
     * Instantiates a new ditch.
     */
    Wall(){
        super(IMAGE, SPRITE, Permeability.BLOCKING);
    }

}
