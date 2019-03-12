package main.java.commands.cd;

import java.io.FileNotFoundException;

import main.java.filesystem.FileSystem;

public class CdPoint extends Cd implements CdCommandTypesExecution {

    public CdPoint(FileSystem fs) {
        super(fs);
    }

    @Override
    public String executeLocation(String location) {
        return null;
    }

    @Override
    public String executePoint() throws FileNotFoundException {

        return fs.getHeadName();
    }

    @Override
    public String executePointPoint() {
        return null;
    }

    @Override
    public String executeHome() {
        return null;
    }

}
