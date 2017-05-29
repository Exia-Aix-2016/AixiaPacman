package fr.exia.aixiapacman.element.motionless;


import fr.exia.aixiapacman.element.Element;
import fr.exia.aixiapacman.element.motionless.Letter;
import fr.exia.aixiapacman.element.motionless.MotionlessElementsFactory;

import java.util.ArrayList;

public class Score {

    private int value;
    private int max;
    private int min;
    private String name;

    private ArrayList<Letter> mots;

    /**
     * @param max define max score
     * @param min define min score
     * */
    public Score(String nameOfTHisScoreBoard, final int max, final int min){

        this.value = 0;
        this.setMax(max);
        this.setMin(min);

        this.name = nameOfTHisScoreBoard;
        this.mots = new ArrayList<>();

        this.name = this.name.toUpperCase();
        for(int i = 0; i < this.name.length(); i++){
            char c = this.name.charAt(i);
            String filename = c + ".png";
            //Element letter = new Letter(c, c + filename);
            Letter letter = new Letter(c,filename);
            mots.add(letter);
        }
    }

    public ArrayList getMots() {
        return mots;
    }

    public String getName() {
        return name;
    }

    public void setMots(String name) {



    }

    /**
     * @param max set max score
     * */
    public void setMax(int max) {
        this.max = max;
    }
    /**
     * @param min set min score
     * */
    public void setMin(int min) {
        this.min = min;
    }
    /**
     * @param value set score
     * */
    public void setValue(int value) {
        this.value = value;
    }
    /**
     * @return max score
     * */
    public int getMax() {
        return max;
    }
    /**
     * @return min score
     * */
    public int getMin() {
        return min;
    }
    /**
     * @return score
     * */
    public int getValue() {
        return value;
    }
}
