package test.java;

import java.io.FileNotFoundException;

import main.java.commands.cd.CdHome;
import main.java.filesystem.FileSystem;

import org.junit.Assert;
import org.junit.Test;


public class CdHomeTest {

    @Test
    public void testIfCdHomeReturnsCorrectOutput() throws FileNotFoundException {

        FileSystem fs = new FileSystem();

        CdHome command = new CdHome(fs);

        Assert.assertSame("/home", command.executeHome());
    }

}
