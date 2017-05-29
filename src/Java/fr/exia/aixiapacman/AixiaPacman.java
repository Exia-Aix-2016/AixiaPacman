package fr.exia.aixiapacman;

import java.io.IOException;

/**
 * <h1>The Class AixiaPacman.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public abstract class AixiaPacman {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public static void main(final String[] args) throws IOException, InterruptedException {
        final AixiaPacmanGame insaneVehiclesGame = new AixiaPacmanGame();
        insaneVehiclesGame.move();
    }
}
