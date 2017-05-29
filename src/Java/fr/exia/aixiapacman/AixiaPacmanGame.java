package fr.exia.aixiapacman;

import fr.exia.aixiapacman.element.Element;
import fr.exia.aixiapacman.element.mobile.PacMan;
import fr.exia.showboard.BoardFrame;
import jdk.internal.util.xml.impl.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Observable;

/**
 * <h1>The Class AixiaPacmanGame.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public class AixiaPacmanGame extends Observable implements Runnable{
    /** The Constant MapWidth. */
    public static final int  MapWidth  = 9;

    /** The Constant MapHeight. */
    public static final int  MapHeight = 40;

    /** The Constant MapView. */
    public static final int  MapView   = 9;

    /** The Constant MapQuota. */
    public static final int  MapQuota  = 20;

    /** The Constant startX. */
    private static final int startX     = 5;

    /** The Constant startY. */
    private static final int startY     = 0;

    /** The Constant keyRight. */
    private static final int keyRight   = 51;

    /** The Constant keyUp. */
    private static final int keyUp      = 50;

    /** The Constant keyLeft. */
    private static final int keyLeft    = 49;

    /** The Constant keyDown. */
    private static final int keyDown    = 52;


    /** The Map. */
    private Map             Map;

    /** The my vehicle. */
    private PacMan pacman;

    /** The view. */
    private int              view;

    /**
     * Instantiates a new insane vehicles games.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public AixiaPacmanGame() {
        // this.setMap(new Map(Map_WIDTH, Map_HEIGHT, Map_VIEW,
        // Map_QUOTA));
        this.setView(MapView);
        try {
            this.setMap(new Map("map.txt", MapQuota));
            this.setMyPacman(new PacMan(startX, startY, this.getMap()));
        } catch (IOException e){}

        SwingUtilities.invokeLater(this);
    }

    /**
     * Print the Map and the player's vehicle in the console.
     *
     * @param yStart
     *            the y start
     */
    public final void show(final int yStart) {
        int y = yStart % this.getMap().getHeight();
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < this.getMap().getWidth(); x++) {
                if ((x == this.getMyPacman().getX()) && (y == yStart)) {
                    System.out.print(this.getMyPacman().getSprite());
                } else {
                    System.out.print(this.getMap().getOnTheMapXY(x, y).getSprite());
                }
            }
            y = (y + 1) % this.getMap().getHeight();
            System.out.print("\n");
        }
    }

    /**
     * Gets the Map.
     *
     * @return the Map
     */
    public final Map getMap() {
        return this.Map;
    }

    /**
     * Sets the Map.
     *
     * @param Map
     *            the new Map
     */
    private void setMap(final Map Map) {
        this.Map = Map;
    }

    /**
     * Gets the my vehicle.
     *
     * @return the my vehicle
     */
    public final PacMan getMyPacman() {
        return this.pacman;
    }

    /**
     * Sets the my vehicle.
     *
     * @param pacman
     *            the new my vehicle
     */
    public final void setMyPacman(final PacMan pacman) {
        this.pacman = pacman;
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public final int getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the new view
     */
    private void setView(final int view) {
        this.view = view;
    }

    public void run(){
        final BoardFrame frame = new BoardFrame("Pacman");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
        frame.setDisplayFrame(new Rectangle(0 , 0,this.getMap().getWidth()*2, this.getMap().getHeight()));

        this.frameConfigure(frame);

        PacMan pacpac = this.getMyPacman();
        AixiaPacmanGame self = this;

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (pacpac.isAlive()){
                    switch( keyCode ) {
                        case KeyEvent.VK_LEFT:
                            pacpac.moveLeft();
                            self.setChanged();
                            self.notifyObservers();
                            break;
                        case KeyEvent.VK_UP:
                            pacpac.moveUp();
                            self.setChanged();
                            self.notifyObservers();
                            break;
                        case KeyEvent.VK_RIGHT :
                            pacpac.moveRight();
                            self.setChanged();
                            self.notifyObservers();
                            break;
                        case KeyEvent.VK_DOWN :
                            pacpac.moveDown();
                            self.setChanged();
                            self.notifyObservers();
                            break;
                    }
                    if (pacpac.isCrashed()){
                        System.out.println("CRASH !");
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    public final void move() throws InterruptedException {
        while (true) {
            if (this.getMyPacman().isAlive()){
                this.getMyPacman().moveDown();

                this.setChanged();
                this.notifyObservers();

                if (this.getMyPacman().isCrashed()){
                    break;
                }

                Thread.sleep(500);
            }
        }
    }

    public final void frameConfigure(final BoardFrame frame) {

        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                Element e = this.getMap().getOnTheMapXY(x,y);
                frame.addSquare(e, x, y);

            }
        }
        frame.addPawn(this.getMyPacman());
        this.addObserver(frame.getObserver());

        frame.setVisible(true);
    }
}
