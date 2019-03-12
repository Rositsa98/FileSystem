package main.java.filesystem;

import java.util.LinkedList;

public class TextFile extends File {

    private static final int MAX_SIZE_OF_ROW = 80;

    private LinkedList<String> content;
    private int countOfRows;

    /**
     * constructor.
     */
    public TextFile(String name) {
        super(name);

        content = new LinkedList<String>();

        countOfRows = 0;

        type = Type.TXT;

    }

    @Override
    public int getCountOfRows() {
        return countOfRows;
    }

    public Type getType() {
        return type;
    }

    /**
     * Adding row in the text file method.
     */

    public void addRow(String row) {
        if (row.length() < MAX_SIZE_OF_ROW) {
            content.add(row);
            countOfRows++;
            countOfAllLetters += row.length();
        } else {
            System.out.println("Too big row!");

        }
    }

    /**
     * Writing a row in the text file method.
     */
    public void write(String fileName, int lineNumber, String lineContent)
            throws IllegalArgumentException {
        if (this.getName().equals(fileName)) {
            if (countOfRows < lineNumber) {

                for (int i = countOfRows; i < lineNumber; i++) {
                    addRow(" ");
                }

                addRow(lineContent);// it will add it on the lineNumber
            }

            if (countOfRows > lineNumber) {
                overwrite(fileName, lineNumber, lineContent);
            }

            if (countOfRows == lineNumber) {
                addRow(lineContent);

            }

        }
    }

    /**
     * Overwriting a row in the text file method.
     */
    public void overwrite(String fileName, int lineNumber, String lineContent)
            throws IllegalArgumentException {
        if (lineContent.length() < MAX_SIZE_OF_ROW) {
            content.set(lineNumber, lineContent);
        } else {
            System.out.println("Too big row!");
        }

    }

    /**
     * Printing the text file method.
     */
    public void printTextFile() {
        for (int i = 0; i < countOfRows; i++) {
            try {
                System.out.println(content.get(i).toString());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Illegal access element!");
            }
        }
    }

    @Override
    public int getSize() {
        return countOfAllLetters;
    }

    @Override
    public int compareTo(File o) {
        if (this.getSize() > ((TextFile) o).getSize()) {
            return 1;
        }

        if (this.getSize() < ((TextFile) o).getSize()) {
            return -1;
        }

        return 0;
    }

    /**
     * Counting number of words using regular expression.
     */
    public int countWord(String word) {
        if (word == null) {
            return 0;
        }
        String input = word.trim();
        int count = input.isEmpty() ? 0 : input.split("\\s+").length;
        return count;
    }

    /**
     * Count words method.
     * 
     * @return count of words in a text file.
     */
    public int wordCount() {
        int count = 0;

        for (String s : content) {
            count += countWord(s);
        }

        return count;
    }

}
