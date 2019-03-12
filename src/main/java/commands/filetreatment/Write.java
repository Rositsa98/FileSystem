package main.java.commands.filetreatment;

import java.io.FileNotFoundException;
import java.util.Iterator;
import main.java.commands.Command;
import main.java.filesystem.File;
import main.java.filesystem.FileSystem;
import main.java.filesystem.TextFile;
import main.java.filesystem.Type;

public class Write extends Command {

    public Write(FileSystem fs) {
        super(fs);
    }

    @Override
    public void execute(String fileName, int lineNumber, String[] lineContent)
            throws IllegalArgumentException, FileNotFoundException {
        if (fs.getCurrentDir().contains(fileName)) {
            if (fs.getCurrentDir().getObjectsSize() >= 0) {

                String lineContentConverted = null;
                try {
                    lineContentConverted = lineContent[3] + " ";
                    for (int i = 4; i < lineContent.length; i++) {
                        lineContentConverted += lineContent[i] + " ";
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid try to get array element.");
                }
                Iterator<File> iterator = fs.getCurrentDir().getDirList().iterator();

                while (iterator.hasNext()) {

                    File temp = iterator.next();

                    if (temp.getType() == Type.TXT) {
                        ((TextFile) temp).write(fileName, lineNumber, lineContentConverted);

                    }

                }
            }
        }

    }

    @Override
    public boolean execute(String f) {
        return false;
    }

    @Override
    public void execute() {
    }

    @Override
    public void execute(String[] splittedCommand) {
    }

}
