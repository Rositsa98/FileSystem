package main.java.filesystem;

import java.io.FileNotFoundException;

public abstract class File implements Comparable<File> {

    private String name;
    protected Type type;
    protected int countOfAllLetters;

    File(String name) {
        try {
            this.name = name;
        } catch (NullPointerException e) {
            System.out.println("Illegal format name!");
        }
    }

    /**
     * Selector to get file name.
     * 
     * @return name of file.
     */
    public String getName() {
        try {
            return name;
        } catch (NullPointerException e) {
            return "NullPointerException found!";
        }
    }

    public void coverNameWithBlankSpace() {
        name = " ";
    }

    public abstract int getSize() throws FileNotFoundException, IndexOutOfBoundsException;

    public abstract Type getType();

    public abstract int getCountOfRows();

}
