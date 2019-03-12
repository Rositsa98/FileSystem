package test.java;

import java.io.FileNotFoundException;

import main.java.commands.filetreatment.CreateFile;
import main.java.filesystem.FileSystem;

import org.junit.Assert;
import org.junit.Test;

public class CreateFileTest {
    
    @Test
    public void testIfCreatesFileCorrectly() throws OutOfMemoryError, FileNotFoundException {
        FileSystem fs = new FileSystem();
        CreateFile f = new CreateFile(fs);
        
        Assert.assertFalse(f.execute("f"));
    }

}
