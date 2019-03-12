package main.java.commands.ls;

import java.io.FileNotFoundException;
import main.java.commands.Command;
import main.java.filesystem.FileSystem;

public class LsSorted extends Command {

    public LsSorted(FileSystem fs) {
        super(fs);
    }

    @Override
    public void execute() throws FileNotFoundException {
        fs.getCurrentDir().ls__sorted();

    }

    @Override
    public boolean execute(String f) {
        return false;
    }

    @Override
    public void execute(String fileName, int lineNumber, String[] content) {
    }

    @Override
    public void execute(String[] splittedCommand) {

    }

}