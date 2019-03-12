package main.java.commands.cd;

import java.io.FileNotFoundException;

public interface CdCommandTypesExecution {

    public String executeLocation(String location) throws FileNotFoundException;

    public String executePoint() throws FileNotFoundException;

    public String executePointPoint() throws FileNotFoundException;

    public String executeHome() throws FileNotFoundException;

}
