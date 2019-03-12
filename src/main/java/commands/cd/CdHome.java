package main.java.commands.cd;

import java.io.FileNotFoundException;

import main.java.filesystem.FileSystem;

public class CdHome extends Cd implements CdCommandTypesExecution {

    public CdHome(FileSystem fs) {
        super(fs);
    }

    @Override
    public String executeHome() throws FileNotFoundException {
        fs.setCurrentDir(fs.getHomeDir());

        fs.setHeadName("/home");

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
    public String executePointPoint() {
        return null;
    }

}
