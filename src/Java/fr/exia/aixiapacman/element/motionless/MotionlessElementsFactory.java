package fr.exia.aixiapacman.element.motionless;

import fr.exia.aixiapacman.element.mobile.Coin;

/**
 * <h1>A factory for creating MotionlessElements objects.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public abstract class MotionlessElementsFactory {

    /** The Constant WALL. */
    private static final Wall         WALL            = new Wall();

    /** The Constant FLOOR. */
    private static final Floor    FLOOR        = new Floor();


    /**
     * The motionless elements is an array of all possible MotionlessElement.
     */
    private static MotionlessElement[] motionlessElements = { WALL, FLOOR};

    /**
     * }
     * Creates a new ditch object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createWall() {
        return WALL;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createFloor() {
        return FLOOR;
    }

    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite() == fileSymbol) {

                return motionlessElement;
            }
        }
        return FLOOR;
    }
}
