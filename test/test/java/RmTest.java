package test.java;

import java.io.FileNotFoundException;
import main.java.commands.filetreatment.Rm;
import main.java.filesystem.FileSystem;
import org.junit.Assert;
import org.junit.Test;

public class RmTest {

    @Test
    public void testIfRemovesFileCorrectly() throws OutOfMemoryError, FileNotFoundException {
        FileSystem fs = new FileSystem();
        fs.getCurrentDir().addTxtFile("f");
        Rm rm = new Rm(fs);

        Assert.assertTrue(rm.execute("f"));
    }

}
