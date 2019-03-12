package main.java.filesystem;

import java.io.FileNotFoundException;

public class FileSystem {

    private Directory home;
    private String headName;

    private Directory currentDir;

    private Directory backDir;

    /**
     * Constructor.
     */
    public FileSystem() {
        home = new Directory("/home");

        headName = home.getName();

        currentDir = home;

        backDir = new Directory("");

    }

    public Directory getCurrentDir() throws FileNotFoundException {
        return currentDir;
    }

    public Directory getBackDir() throws FileNotFoundException {
        return backDir;
    }

    public String getHeadName() throws FileNotFoundException {
        return headName;
    }

    public Directory getHomeDir() throws FileNotFoundException {
        return home;
    }

    public void setCurrentDir(Directory dir) {
        this.currentDir = dir;
    }

    public void setBackDir(Directory dir) {
        this.backDir = dir;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

}
