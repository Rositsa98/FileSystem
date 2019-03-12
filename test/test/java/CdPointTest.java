package test.java;

import java.io.FileNotFoundException;

import main.java.commands.cd.CdPoint;
import main.java.filesystem.FileSystem;
import org.junit.Assert;
import org.junit.Test;

public class CdPointTest {

    @Test
    public void testIfCdPointReturnsCorrectOutput() throws FileNotFoundException {

        FileSystem fs = new FileSystem();

        CdPoint command = new CdPoint(fs);

        Assert.assertSame("/home", command.executePoint());
    }

}
