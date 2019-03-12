package main.java.commands.filetreatment;

import java.io.FileNotFoundException;
import main.java.commands.Command;
import main.java.filesystem.FileSystem;

public class WcLines extends Command {

    public WcLines(FileSystem fs) {
        super(fs);
    }

    @Override
    public boolean execute(String fileName) throws FileNotFoundException {
        if (fs.getCurrentDir().contains(fileName)) {
            System.out.println(fs.getCurrentDir().getFileWithName(fileName).getCountOfRows());
            return true;
        }
        return false;
    }

    @Override
    public void execute(String[] splittedCommand) {
    }

    @Override
    public void execute() {
    }

    @Override
    public void execute(String fileName, int lineNumber, String[] content) {
    }

}
