package fr.exia.aixiapacman.element.motionless;

import fr.exia.aixiapacman.element.Permeability;

/**
 * Created by Mandel on 29/05/2017.
 */
public class Wall extends MotionlessElement{
    /** The Constant SPRITE. */
    private static final char SPRITE = '|';
    private static final String IMAGE = "dirt.jpg";

    /**
     * Instantiates a new ditch.
     */
    Wall(){
        super(IMAGE, SPRITE, Permeability.BLOCKING);
    }

}
