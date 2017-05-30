package fr.exia.aixiapacman.element.motionless;


import fr.exia.aixiapacman.element.Element;
import fr.exia.aixiapacman.element.motionless.Letter;
import fr.exia.aixiapacman.element.motionless.MotionlessElementsFactory;
import fr.exia.showboard.BoardFrame;

import java.util.ArrayList;

public class Score {

    private Letter score;
    private String name;

    private ArrayList<Letter> mots;

    /**
     * @param max define max score
     * @param min define min score
     * */
    public Score(String nameOfTHisScoreBoard, final int max, final int min){
        this.score = new Letter('A', "A.png");

        this.name = nameOfTHisScoreBoard;
        this.mots = new ArrayList<>();

        this.name = this.name.toUpperCase();
        for(int i = 0; i < this.name.length(); i++){
            char c = this.name.charAt(i);
            String filename = c + ".png";
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
        this.mots.clear();
        name = name.toUpperCase();
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            String filename = c + ".png";
            Letter letter = new Letter(c,filename);
            mots.add(letter);
        }

        mots.add(score);

    }

    public void show(BoardFrame frame){
        //Print name
        for(int i = 0; i < this.getMots().size(); i++){

            frame.addSquare((Element)this.getMots().get(i), i, 0);

        }

    }
    public void hide(BoardFrame frame){
        for(int i = 0; i < this.getMots().size(); i++){

            frame.addSquare(null, i, 0);

        }
    }
    public void setScore(final char score) {
        String filename = score + ".png";
        this.score = new Letter(score, filename);
        this.mots.remove(this.mots.size() - 1);
        this.mots.add(this.score);

    }

}
