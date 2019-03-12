package main.java.commands.filetreatment;

import java.io.FileNotFoundException;
import java.util.Iterator;
import main.java.commands.Command;
import main.java.filesystem.File;
import main.java.filesystem.FileSystem;
import main.java.filesystem.TextFile;
import main.java.filesystem.Type;

public class WordCount extends Command {

    public WordCount(FileSystem fs) {
        super(fs);
    }

    @Override
    public boolean execute(String fileName) throws FileNotFoundException {
        if (fs.getCurrentDir().contains(fileName)) {
            Iterator<File> iterator = fs.getCurrentDir().getDirList().iterator();

            while (iterator.hasNext()) {

                File temp = iterator.next();
                if (temp.getName().equals(fileName) && temp.getType() == Type.TXT) {

                    System.out.println(((TextFile) temp).wordCount());
                    return true;
                }
            }

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

        System.out.println(splittedCommand.length - 1);

    }

}
