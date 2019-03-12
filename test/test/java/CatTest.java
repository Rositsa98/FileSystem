package test.java;

import java.io.FileNotFoundException;

import main.java.commands.filetreatment.Cat;
import main.java.commands.filetreatment.Write;
import main.java.filesystem.FileSystem;
import org.junit.Assert;
import org.junit.Test;

public class CatTest {

    @Test
    public void testIfCatAFileIsHappeningWhenWanted() 
            throws OutOfMemoryError, FileNotFoundException {

        FileSystem fs = new FileSystem();

        fs.getCurrentDir().addTxtFile("f");

        Write wr = new Write(fs);

        String[] lineContent = { " ", " ", " ", "abc" };

        wr.execute("f", 0, lineContent);

        Cat cat = new Cat(fs);

        Assert.assertTrue(cat.execute("f"));
    }

}
