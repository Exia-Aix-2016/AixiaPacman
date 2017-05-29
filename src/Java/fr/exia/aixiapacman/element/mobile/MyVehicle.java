package fr.exia.aixiapacman.element.mobile;

import fr.exia.aixiapacman.element.Permeability;

import java.io.IOException;

/**
 * <h1>The Class MyVehicle.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public class MyVehicle extends Mobile {

    /** The Constant SPRITE. */
    private static final char SPRITE = 'H';
    private static final String IMAGE = "car.png";

    /**
     * Instantiates a new my vehicle.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param map
     *            the map
     */
    public MyVehicle(final int x, final int y, final fr.exia.aixiapacman.Map map) throws IOException{
        super(x, y, IMAGE, SPRITE, map, Permeability.BLOCKING);
    }
}
