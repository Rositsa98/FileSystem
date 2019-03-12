package main.java.commands;

import java.io.FileNotFoundException;

import main.java.filesystem.Directory;
import main.java.filesystem.FileSystem;

public class MkDir extends Command {

    public MkDir(FileSystem fs) {
        super(fs);
        this.name = "mkdir";
    }

    @Override
    public boolean execute(String dirName) throws OutOfMemoryError, FileNotFoundException {

        int saverSize = getFs().getCurrentDir().getDirList().size();

        Directory dir = new Directory(dirName);

        getFs().getCurrentDir().addDir(dir);

        if (getFs().getCurrentDir().getDirList().size() - 1 == saverSize) {
            return true;
        }
        return false;
    }

    @Override
    public void execute() {
    }

    @Override
    public void execute(String fileName, int lineNumber, String[] content) {
    }

    @Override
    public void execute(String[] splittedCommand) {

    }

}
