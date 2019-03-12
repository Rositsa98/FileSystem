package main.java.commands;

import java.io.FileNotFoundException;

import main.java.filesystem.FileSystem;

public abstract class Command {

    protected String name;
    protected FileSystem fs;

    protected Command(FileSystem fs) {
        this.fs = fs;
    }

    public String getName() {
        return name;
    }

    public FileSystem getFs() {
        return fs;
    }

    public abstract boolean execute(String f) throws FileNotFoundException;

    public abstract void execute(String[] splittedCommand) throws IndexOutOfBoundsException,
        FileNotFoundException;

    public abstract void execute() throws FileNotFoundException;

    public abstract void execute(String fileName, int lineNumber, String[] content)
            throws IllegalArgumentException, FileNotFoundException;

}
