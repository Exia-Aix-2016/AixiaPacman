package fr.exia.aixiapacman;

import fr.exia.aixiapacman.element.Element;
import fr.exia.aixiapacman.element.mobile.Coin;
import fr.exia.aixiapacman.element.mobile.PacMan;
import fr.exia.aixiapacman.element.motionless.Score;
import fr.exia.showboard.BoardFrame;

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
    private static final int startX     = 1;

    /** The Constant startY. */
    private static final int startY     = 22;

    /** The Map. */
    private Map             Map;

    /** The my vehicle. */
    private PacMan pacman;

    /** The view. */
    private int              view;

    private BoardFrame frame;
    private Score score;



    /**
     * Instantiates a new insane vehicles games.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public AixiaPacmanGame() {
        this.setView(MapView);
        try {
            this.setMap(new Map("map.txt", MapQuota));
            this.setMyPacman(new PacMan(startX, startY, this.getMap()));
        } catch (IOException e){}

        //Creation du score
        this.score = new Score("sc", 'A');
        this.score.setMots("score");
        //Invoke
        SwingUtilities.invokeLater(this);

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

    public final PacMan getMyPacman() {
        return this.pacman;
    }

    public final void setMyPacman(final PacMan pacman) {
        this.pacman = pacman;
    }

    public final int getView() {
        return this.view;
    }

    private void setView(final int view) {
        this.view = view;
    }

    public void run(){
        //Creation de la fenetre
        this.frame = new BoardFrame("Pacman", true);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
        this.frame.setDisplayFrame(new Rectangle(0 , 0,this.getMap().getWidth()*2, this.getMap().getHeight()));
        this.frameConfigure(frame);

        PacMan pacpac = this.getMyPacman();
        AixiaPacmanGame self = this;


        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                //if (pacpac.isAlive()) {
                    switch (keyCode) {
                        case KeyEvent.VK_LEFT:
                            System.out.println("left");
                            if (pacpac.canGoLeft()){
                                pacpac.setDirection('w');
                            }
                            pacpac.moveLeft();
                            self.setChanged();
                            self.notifyObservers();
                            break;
                        case KeyEvent.VK_UP:
                            System.out.println("up");
                            if (pacpac.canGoUp()){
                                pacpac.setDirection('n');
                            }
                            pacpac.moveUp();
                            self.setChanged();
                            self.notifyObservers();
                            break;
                        case KeyEvent.VK_RIGHT:
                            System.out.println("Right");
                            if (pacpac.canGoRight()){
                                pacpac.setDirection('e');
                            }
                            pacpac.moveRight();
                            self.setChanged();
                            self.notifyObservers();
                            break;
                        case KeyEvent.VK_DOWN:
                            System.out.println("Down");
                            if (pacpac.canGoDown()){
                                pacpac.setDirection('s');
                            }
                            pacpac.moveDown();
                            self.setChanged();
                            self.notifyObservers();
                            break;

                    }
                    //while(KeyEvent() == ){
                    //    pacpac.moveRight();
                    //}

                //}
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

        this.score.setScore('B');
        this.frameRefresh(this.frame);
    }

    public final void move() throws InterruptedException {
        while (true) {

            if (this.getMyPacman().isAlive()){
                this.getMyPacman().moveRight();

                this.setChanged();
                this.notifyObservers();

                if (this.getMyPacman().isCrashed()){
                    break;
                }

            }
        }
    }
    /**
     * Permet de configurer la fenetre
     * @param frame fenetre du jeu
     * */
    public final void frameConfigure(final BoardFrame frame) {
        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                Element e = this.getMap().getOnTheMapXY(x,y);
                frame.addSquare(e, x, y);

                if (e.getSprite() == ' '){
                    try {
                        frame.addPawn(new Coin(x, y, this.getMap()));
                    } catch (Exception ex){
                        System.err.println(ex);
                    }
                }
            }
        }
        frame.addPawn(this.getMyPacman());
        this.addObserver(frame.getObserver());
        this.setChanged();
        this.notifyObservers();
        frame.setVisible(true);
    }

    private final void frameRefresh(final BoardFrame frame){

        this.score.show(frame);
        this.setChanged();
        this.notifyObservers();
    }
}
