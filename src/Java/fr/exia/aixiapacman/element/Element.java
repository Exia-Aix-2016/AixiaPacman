package fr.exia.aixiapacman.element;

import fr.exia.showboard.ISquare;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * <h1>The Class Element.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public abstract class Element implements ISquare{

    /** The sprite. *///
    private char         sprite;

    private Image  image;
    private String imageName;

    /** The permeability. */
    private Permeability permeability;

    /**
     * Instantiates a new element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
    public Element(final String imageName, final char sprite, final Permeability permeability) {
        this.setSprite(sprite);
        this.setImageName(imageName);
        this.setPermeability(permeability);
        try {
            this.loadImage();
        } catch (IOException e){}
    }

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    public final char getSprite() {
        return this.sprite;
    }

    /**
     * Sets the sprite.
     *
     * @param sprite
     *            the new sprite
     */
    private void setSprite(final char sprite) {
        this.sprite = sprite;
    }

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    public final Permeability getPermeability() {
        return this.permeability;
    }

    /**
     * Sets the permeability.
     *
     * @param permeability
     *            the new permeability
     */
    private void setPermeability(final Permeability permeability) {
        this.permeability = permeability;
    }

    public Image getImage(){
        return this.image;
    }

    public void setImage(Image image){
        this.image = image;
    }

    public final void loadImage() throws IOException {
        InputStream in = getClass().getResourceAsStream(this.getImageName());
        this.setImage(ImageIO.read(in));
    }


    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
