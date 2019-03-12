package main.java.commands.cd;

import java.io.FileNotFoundException;

import main.java.commands.Command;
import main.java.filesystem.FileSystem;

public class Cd extends Command {

    public Cd(FileSystem fs) {
        super(fs);
        this.name = "cd";
    }

    @Override
    public boolean execute(String location) throws FileNotFoundException {

        switch (location) {

            case ".": {
                try {
                    CdPoint object = new CdPoint(fs);
                    System.out.println(object.executePoint());
                    return true;
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException thrown!");
                }
            }
            case "..": {
                try {
                    CdPointPoint obj = new CdPointPoint(fs);
                    System.out.println(obj.executePointPoint());
                    return true;
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException thrown!");
                }
            }
            case "home": {
                try {
                    CdHome obj = new CdHome(fs);
                    System.out.println(obj.executeHome());
                    return true;
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException thrown!");
                }
            }
            default: {
                try {
                    CdLocation obj = new CdLocation(fs);
                    System.out.println(obj.executeLocation(location));
                    return true;
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException thrown!");
                }
            }
        }
        
        return false;

    }

    @Override
    public void execute() {
    }

    @Override
    public void execute(String fileName, int lineNumber, String[] content) {
    }

    @Override
    public void execute(String[] splittedCommand) {

    }
}