package test.java;

import java.io.FileNotFoundException;

import main.java.commands.filetreatment.WcLines;
import main.java.commands.filetreatment.WordCount;
import main.java.filesystem.FileSystem;
import org.junit.Assert;
import org.junit.Test;

public class WcTest {

    @Test
    public void testIfWordCountWorksCorrectly() throws OutOfMemoryError, FileNotFoundException {
        FileSystem fs = new FileSystem();
        fs.getCurrentDir().addTxtFile("f");
        WordCount wc = new WordCount(fs);

        Assert.assertTrue(wc.execute("f"));
    }

    @Test
    public void testIfWordCountLinesWorksCorrectly() 
            throws OutOfMemoryError, FileNotFoundException {
        FileSystem fs = new FileSystem();
        fs.getCurrentDir().addTxtFile("f");
        WcLines wc = new WcLines(fs);

        Assert.assertTrue(wc.execute("f"));
    }

}
