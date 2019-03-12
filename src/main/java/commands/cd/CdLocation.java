package main.java.commands.cd;

import java.io.FileNotFoundException;

import main.java.filesystem.Directory;
import main.java.filesystem.FileSystem;

public class CdLocation extends Cd implements CdCommandTypesExecution {

    public CdLocation(FileSystem fs) {
        super(fs);
    }

    @Override
    public String executeLocation(String location) throws FileNotFoundException {
        
        for (int i = 0; i < getFs().getCurrentDir().getObjectsSize(); i++) {

            if (getFs().getCurrentDir().getDirList().get(i).getName().equals(location)) {
                String dirName1 = "/" + location;

                fs.setHeadName(dirName1);

                fs.setBackDir(getFs().getCurrentDir());

                fs.setCurrentDir((Directory) getFs().getCurrentDir().getDirList().get(i));
            }
        }

        return fs.getHeadName();
    }

    @Override
    public String executePoint() {
        return null;
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
