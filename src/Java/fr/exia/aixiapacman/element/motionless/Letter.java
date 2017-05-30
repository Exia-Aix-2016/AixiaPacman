package fr.exia.aixiapacman.element.motionless;


import fr.exia.aixiapacman.element.Element;
import fr.exia.aixiapacman.element.Permeability;

public class Letter extends MotionlessElement{

    /**
     * Instantiates a new ditch.
     */
    public Letter(final char sprite, final String imageName){
        super(imageName, sprite, Permeability.PENETRABLE);
    }

}