package fr.exia.aixiapacman.element.motionless;

/**
 * <h1>A factory for creating MotionlessElements objects.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public abstract class MotionlessElementsFactory {

    /** The Constant DITCH. */
    private static final Ditch         DITCH              = new Ditch();

    /** The Constant DITCH_RIGHT. */
    private static final DitchRight    DITCH_RIGHT        = new DitchRight();

    /** The Constant DITCH_LEFT. */
    private static final DitchLeft     DITCH_LEFT         = new DitchLeft();

    /** The Constant TREE. */
    private static final Tree          TREE               = new Tree();

    /** The Constant MACADAM. */
    private static final Macadam       MACADAM            = new Macadam();

    /** The Constant OBSTACLE. */
    private static final Obstacle      OBSTACLE           = new Obstacle();

    /**
     * The motionless elements is an array of all possible MotionlessElement.
     */
    private static MotionlessElement[] motionlessElements = { DITCH, DITCH_RIGHT, DITCH_LEFT, MACADAM, OBSTACLE, TREE };

    /**
     * }
     * Creates a new ditch object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitch() {
        return DITCH;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchRight() {
        return DITCH_RIGHT;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitchLeft() {
        return DITCH_LEFT;
    }

    /**
     * Creates a new macadam object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createMacadam() {
        return MACADAM;
    }

    /**
     * Creates a new obstacle object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createObstacle() {
        return OBSTACLE;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createTree() {
        return TREE;
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
        return MACADAM;
    }
}
