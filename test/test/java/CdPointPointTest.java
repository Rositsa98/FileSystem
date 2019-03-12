package test.java;

import java.io.FileNotFoundException;
import main.java.commands.MkDir;
import main.java.commands.cd.CdLocation;
import main.java.commands.cd.CdPointPoint;
import main.java.filesystem.FileSystem;
import org.junit.Assert;
import org.junit.Test;

public class CdPointPointTest {

    @Test
    public void testIfCdPointPointReturnsCorrectOutput() throws FileNotFoundException {

        FileSystem fs = new FileSystem();

        CdPointPoint command = new CdPointPoint(fs);

        MkDir mk = new MkDir(fs);
        mk.execute("d");

        CdLocation com = new CdLocation(fs);
        com.executeLocation("d");

        Assert.assertEquals("/home", command.executePointPoint());
    }

}
