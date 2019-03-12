package main.java.commands.filetreatment;

import java.io.FileNotFoundException;

import main.java.filesystem.FileSystem;
import main.java.filesystem.TextFile;
import main.java.commands.Command;

public class Remove extends Command {

    public Remove(FileSystem fs) {
        super(fs);
    }

    @Override
    public boolean execute(String f) {
        return false;
    }

    @Override
    public void execute(String[] splittedCommand) throws IndexOutOfBoundsException, FileNotFoundException {

        String fileName = splittedCommand[1];
        if (fs.getCurrentDir().contains(fileName)) {
            if (fs.getCurrentDir().getObjectsSize() >= 0) {
                int fromLine = Integer.parseInt(splittedCommand[2]);
                int toLine = Integer.parseInt(splittedCommand[3]);

                for (int i = fromLine; i <= toLine; i++) {
                    ((TextFile) fs.getCurrentDir().getFileWithName(fileName)).overwrite(fileName, i, " ");
                }

            }
        }

    }

    @Override
    public void execute() {

    }

    @Override
    public void execute(String fileName, int lineNumber, String[] content) {

    }

}
