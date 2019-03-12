package test.java;

import java.io.FileNotFoundException;

import main.java.commands.MkDir;
import main.java.commands.cd.CdLocation;
import main.java.filesystem.FileSystem;
import org.junit.Assert;
import org.junit.Test;

public class CdLocationTest {

    @Test
    public void testIfCdLocationReturnsCorrectOutput() throws FileNotFoundException {

        FileSystem fs = new FileSystem();

        MkDir mk = new MkDir(fs);
        mk.execute("d");

        CdLocation command = new CdLocation(fs);

        Assert.assertEquals("/d", command.executeLocation("d"));
    }

}
