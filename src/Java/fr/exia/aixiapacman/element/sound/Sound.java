package fr.exia.aixiapacman.element.sound;

import java.io.*;
import sun.audio.*;

public class Sound {

    public void playSound(final String filename) {

        try {
            InputStream in = getClass().getResourceAsStream(filename + ".wav");
            AudioStream audioStream = new AudioStream(in);

            AudioPlayer.player.start(audioStream);
        }catch (Exception e){

        }

    }
}