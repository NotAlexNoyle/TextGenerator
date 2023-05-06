package de.philw.textgenerator.letters;

public enum Size {

    TWOBYTWO(new TwoByTwoLetters(), 2, 2),
    THREEBYTHREE(new ThreeByThreeLetters(), 3, 3);

    private Letters letters;
    private int neededHorizontalBlocks;
    private int neededVerticalBlocks;

    Size(Letters letters, int neededHorizontalBlocks, int neededVerticalBlocks) {
        this.letters = letters;
        this.neededHorizontalBlocks = neededHorizontalBlocks;
        this.neededVerticalBlocks = neededVerticalBlocks;
    }

    public Letters getLetters() {
        return letters;
    }

    public int getNeededHorizontalBlocks() {
        return neededHorizontalBlocks;
    }

    public int getNeededVerticalBlocks() {
        return neededVerticalBlocks;
    }
}
