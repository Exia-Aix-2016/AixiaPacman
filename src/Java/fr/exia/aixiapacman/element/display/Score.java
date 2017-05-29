package fr.exia.aixiapacman.element.display;


public class Score {

    private int value;
    private int max;
    private int min;

    /**
     * @param max define max score
     * @param min define min score
     * */
    Score(final int max, final int min){

        this.value = 0;
        this.setMax(max);
        this.setMin(min);
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
