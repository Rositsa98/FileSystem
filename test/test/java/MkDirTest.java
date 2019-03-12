package test.java;

import java.io.FileNotFoundException;
import main.java.commands.MkDir;
import main.java.filesystem.FileSystem;

import org.junit.Assert;
import org.junit.Test;

public class MkDirTest {

    @Test
    public void test() throws OutOfMemoryError, FileNotFoundException {
        FileSystem fs = new FileSystem();

        MkDir mkdir = new MkDir(fs);

        mkdir.execute("d");

        Assert.assertTrue(mkdir.execute("d"));
    }

}
