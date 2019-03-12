package main.java.commands.filetreatment;

import java.io.FileNotFoundException;
import main.java.commands.Command;
import main.java.filesystem.FileSystem;

public class CreateFile extends Command {

    public CreateFile(FileSystem fs) {
        super(fs);
    }

    @Override
    public boolean execute(String fileName) throws OutOfMemoryError, FileNotFoundException {

        int saverSize = fs.getCurrentDir().getSize();

        fs.getCurrentDir().addTxtFile(fileName);

        if (fs.getCurrentDir().getSize() - 1 == saverSize) {
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
