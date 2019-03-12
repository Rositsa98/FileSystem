package main.java.filesystem;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class Directory extends File {

    private LinkedList<File> dirList;
    private int countOfObjectsInDirList;

    /**
     * Constructor.
     * 
     * @param name of file.
     */
    public Directory(String name) {
        super(name);

        dirList = new LinkedList<File>();

        countOfObjectsInDirList = 0;
        type = Type.DIR;

    }

    public LinkedList<File> getDirList() {
        return dirList;
    }

    /**
     * Selector to get file by it's name.
     * 
     * @param name - file name.
     * @return file.
     */
    public File getFileWithName(String name) throws FileNotFoundException {
        for (File f : dirList) {
            if (f.getName().equals(name)) {
                return f;
            }
        }
        return null;
    }

    public void addTxtFile(TextFile txt) throws OutOfMemoryError{
        dirList.push(txt);
        countOfObjectsInDirList++;
    }

    /**
     * Adding text file method by name.
     */
    public void addTxtFile(String fileName) throws OutOfMemoryError{
        TextFile f = new TextFile(fileName);
        dirList.push(f);
        countOfObjectsInDirList++;
    }

    /**
     * Method adding directory in the current directory.
     * 
     * @param dir - directory
     */
    public void addDir(Directory dir) throws OutOfMemoryError {
        dirList.push(dir);
        countOfObjectsInDirList++;

    }

    /**
     * Method returning the actual size of the directory according to the task
     * instructions.
     * 
     * @param ls - dirList.
     * @return - count of all letters in the directory.
     */
    public int getActualSize(LinkedList<File> ls) throws FileNotFoundException,
        IndexOutOfBoundsException {
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getType() == Type.TXT) {
                countOfAllLetters += ls.get(i).getSize();
            } else {
                getActualSize(((Directory) ls.get(i)).getDirList());
            }
        }

        return countOfAllLetters;
    }

    /**
     * List directory content method.
     */
    @SuppressWarnings("unchecked")
    public void ls(String name)  throws FileNotFoundException{
        System.out.println(name + ":");

        Collections.sort(dirList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((File) o1).getName().compareTo(((File) o2).getName());
            }

        });
        try {

            for (File f : dirList) {
                System.out.println(f.getName());
            }
        } catch (NullPointerException e) {
            System.out.println("Empty dir list!");

        }

    }

    /**
     * List directory content sorted by size method.
     */
    @SuppressWarnings("rawtypes")
    public void ls__sorted()  throws FileNotFoundException{

        Collections.sort(dirList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                try {
                    return Integer.compare(((File) o1).getSize(), ((File) o2).getSize());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
                return countOfObjectsInDirList;
            }

        });

        Collections.reverse(dirList);
        try {
            for (File f : dirList) {
                System.out.println(f.getName() + " " + f.getSize());
            }
        } catch (NullPointerException e) {
            System.out.println("Empty dir list!");

        }
    }

    /**
     * If a directory contains a File method.
     */
    public boolean contains(String fileName) {
        Iterator<File> itr = dirList.iterator();
        while (itr.hasNext()) {
            if (((File) itr.next()).getName().equals(fileName)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Type getType() {
        return type;
    }

    public int getObjectsSize() {
        return countOfObjectsInDirList;
    }

    @Override
    public int getSize() throws FileNotFoundException, IndexOutOfBoundsException {

        return getActualSize(dirList);

    }

    @Override
    public int compareTo(File o) {
        try {
            if (this.getSize() > (o).getSize()) {
                return 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        try {
            if (this.getSize() < (o).getSize()) {
                return -1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int getCountOfRows() {
        return 0;
    }

}
