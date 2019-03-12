package test.java;

import java.io.FileNotFoundException;
import main.java.filesystem.Directory;
import main.java.filesystem.TextFile;
import org.junit.Assert;
import org.junit.Test;


public class DirectoryTest {
    
    @Test
    public void testIfSelectorToGetFileByItsNameFromDirReturnsCorrect() 
            throws FileNotFoundException {
        Directory dir = new Directory("dir");
        
        TextFile f = new TextFile("f");

        dir.addTxtFile("f");
        
        Assert.assertSame(dir.getFileWithName("f").getName(), f.getName());
        
    }

}
