package fr.exia.aixiapacman;

import fr.exia.aixiapacman.element.Element;
import fr.exia.aixiapacman.element.motionless.MotionlessElementsFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * <h1>The Class Map.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public class Map {

    /** The width. */
    private int         width;

    /** The height. */
    private int         height;

    /** The quota. */
    private int         quota;

    /** The on the Map. */
    private Element[][] onTheMap;

    /**
     * Instantiates a new Map with the content of the file fileName.
     *
     * @param fileName
     *            the file name where the map of the Map is
     * @param quota
     *            the quota
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Map(final String fileName, final int quota) throws IOException {
        this.setQuota(quota);
        this.loadFile(fileName);
    }

    /**
     * Load file.
     *
     * @param fileName
     *            the file name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void loadFile(final String fileName) throws IOException {

        InputStream in = getClass().getResourceAsStream(fileName);
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheMap = new Element[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
    }

    /**
     * Gets the width.
     *
     * @return the width
     */
    public final int getWidth() {
        return this.width;
    }

    /**
     * Sets the width.
     *
     * @param width
     *            the new width
     */
    private void setWidth(final int width) {
        this.width = width;
    }

    /**
     * Gets the height.
     *
     * @return the height
     */
    public final int getHeight() {
        return this.height;
    }

    /**
     * Sets the height.
     *
     * @param height
     *            the new height
     */
    private void setHeight(final int height) {
        this.height = height;
    }

    /**
     * Gets the quota.
     *
     * @return the quota
     */
    public final int getQuota() {
        return this.quota;
    }

    /**
     * Sets the quota.
     *
     * @param quota
     *            the new quota
     */
    private void setQuota(final int quota) {
        this.quota = quota;
    }

    /**
     * Gets the on the Map XY.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the on the Map XY
     */
    public final Element getOnTheMapXY(final int x, final int y) {
        return this.onTheMap[x][y];
    }

    /**
     * Sets the on the Map XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    public final void setOnTheMapXY(final Element element, final int x, final int y) {
        this.onTheMap[x][y] = element;
    }

}
