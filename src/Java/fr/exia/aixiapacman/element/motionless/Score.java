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
     * @param nameOfTHisScoreBoard Name scoreboard
     * @param score Char; set first score
     * */
    public Score(String nameOfTHisScoreBoard, final char score){
        String fileName = String.valueOf(score).toUpperCase() + ".png";
        this.score = new Letter(score, fileName);

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
    /**
     * @return The Array letters.
     * */
    public ArrayList getMots() {
        return mots;
    }
    /**
     * @return name of this scoreboard
     * */
    public String getName() {
        return name;
    }

    public void setMots(String name) {
        this.mots.clear();
        name = name.toUpperCase();
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            String filename = String.valueOf(c).toUpperCase() + ".png";
            Letter letter = new Letter(c,filename);
            mots.add(letter);
        }
        mots.add(score);
    }
    /**
     * Allow Show the score
     * @param frame Put a Frame where you want show this score
     * */
    public void show(BoardFrame frame){
        //Print name
        for(int i = 0; i < this.getMots().size(); i++){
            frame.addSquare((Element)this.getMots().get(i), i, 0);

        }
    }
    /**
     * Allow to change Score
     * @param score set letter to change score
     * */
    public void setScore(final char score) {
        String fileName = String.valueOf(score).toUpperCase() + ".png";
        this.score = new Letter(score, fileName);
        this.mots.remove(this.mots.size() - 1);
        this.mots.add(this.score);

    }

}
