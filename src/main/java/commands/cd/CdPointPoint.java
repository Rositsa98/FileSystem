package main.java.commands.cd;

import java.io.FileNotFoundException;

import main.java.filesystem.FileSystem;

public class CdPointPoint extends Cd implements CdCommandTypesExecution {

    public CdPointPoint(FileSystem fs) {
        super(fs);
    }

    @Override
    public String executePointPoint() throws FileNotFoundException {
        fs.setCurrentDir(fs.getBackDir());

        fs.setHeadName(fs.getBackDir().getName());

        return fs.getHeadName();
    }

    @Override
    public String executeLocation(String location) {
        return null;
    }

    @Override
    public String executePoint() {
        return null;
    }

    @Override
    public String executeHome() {
        return null;
    }

}
