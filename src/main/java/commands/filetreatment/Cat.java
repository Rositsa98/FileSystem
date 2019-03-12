package main.java.commands.filetreatment;

import java.io.FileNotFoundException;
import java.util.Iterator;

import main.java.commands.Command;
import main.java.filesystem.File;
import main.java.filesystem.FileSystem;
import main.java.filesystem.TextFile;
import main.java.filesystem.Type;

public class Cat extends Command {

    public Cat(FileSystem fs) {
        super(fs);
    }

    @Override
    public boolean execute(String fileName) throws FileNotFoundException,
        IndexOutOfBoundsException {
        if (fs.getCurrentDir().contains(fileName)) {
            if (fs.getCurrentDir().getObjectsSize() >= 0) {
                Iterator<File> iterator = fs.getCurrentDir().getDirList().iterator();

                while (iterator.hasNext()) {

                    File temp = iterator.next();
                    if (temp.getName().equals(fileName) && temp.getType() == Type.TXT) {

                        ((TextFile) temp).printTextFile();

                        return true;
                    }
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

    }

}
