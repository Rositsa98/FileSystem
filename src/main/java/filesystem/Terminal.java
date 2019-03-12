package main.java.filesystem;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import main.java.commands.cd.Cd;
import main.java.commands.filetreatment.Cat;
import main.java.commands.filetreatment.CreateFile;
import main.java.commands.filetreatment.Overwrite;
import main.java.commands.filetreatment.Rm;
import main.java.commands.filetreatment.Remove;
import main.java.commands.filetreatment.WcLines;
import main.java.commands.filetreatment.WordCount;
import main.java.commands.filetreatment.Write;
import main.java.commands.ls.Ls;
import main.java.commands.ls.LsSorted;
import main.java.commands.Command;
import main.java.commands.MkDir;

public class Terminal {

    private HashMap<String, Command> terminal;

    private FileSystem filesys;

    private String command;

    Terminal() {

        filesys = new FileSystem();

        terminal = new HashMap<String, Command>();
        terminal.put("mkdir", new MkDir(filesys));
        terminal.put("cd", new Cd(filesys));
        terminal.put("ls", new Ls(filesys));
        terminal.put("ls--sorted-desc", new LsSorted(filesys));
        terminal.put("create_file", new CreateFile(filesys));
        terminal.put("cat", new Cat(filesys));
        terminal.put("wc", new WordCount(filesys));
        terminal.put("wc-l", new WcLines(filesys));
        terminal.put("write", new Write(filesys));
        terminal.put("overwrite", new Overwrite(filesys));
        terminal.put("rm", new Rm(filesys));
        terminal.put("remove", new Remove(filesys));

    }

    /**
     * Terminal execution.
     */
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        int index = 0;

        while (index != -1) {
            System.out.println("Enter command: ");

            command = scanner.nextLine();

            String[] splittedCommand = command.split(" ");

            if (splittedCommand[0].equals("mkdir") || splittedCommand[0].equals("cd")
                    || splittedCommand[0].equals("create_file") || splittedCommand[0].equals("cat")) {
                try {
                    terminal.get(splittedCommand[0]).execute(splittedCommand[1]);
                } catch (FileNotFoundException | IndexOutOfBoundsException s) {
                    System.out.println("Exception thrown");
                }
            } else if (splittedCommand[0].equals("ls") || splittedCommand[0].equals("ls--sorted-desc")) {
                try {
                    terminal.get(splittedCommand[0]).execute();
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException thrown");
                }
            } else if (splittedCommand[0].equals("write") || splittedCommand[0].equals("overwrite")) {
                try {
                    terminal.get(splittedCommand[0]).execute(splittedCommand[1], Integer.parseInt(splittedCommand[2]),
                            splittedCommand);
                } catch (IllegalArgumentException | FileNotFoundException e) {
                    System.out.println("Exception thrown");
                    e.printStackTrace();
                }
            } else if (splittedCommand[0].equals("wc")) {
                if (splittedCommand.length < 3) {
                    try {
                        terminal.get(splittedCommand[0]).execute(splittedCommand[1]);
                    } catch (FileNotFoundException e) {
                        System.out.println("FileNotFoundException thrown");
                    }
                } else {
                    try {
                        terminal.get(splittedCommand[0]).execute(splittedCommand);
                    } catch (IndexOutOfBoundsException | FileNotFoundException e) {
                        System.out.println("Exception thrown");
                        e.printStackTrace();
                    }
                }
            } else if (splittedCommand[0].equals("wc-l")) {
                try {
                    terminal.get(splittedCommand[0]).execute(splittedCommand[1]);
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException thrown");
                }
            } else if (splittedCommand[0].equals("rm") || splittedCommand[0].equals("remove")) {
                if (splittedCommand.length < 3) {
                    try {
                        terminal.get(splittedCommand[0]).execute(splittedCommand[1]);
                    } catch (FileNotFoundException e) {
                        System.out.println("FileNotFoundException thrown");
                    }
                } else {
                    try {
                        terminal.get(splittedCommand[0]).execute(splittedCommand);
                    } catch (IndexOutOfBoundsException | FileNotFoundException e) {
                        System.out.println("Exception thrown");
                        e.printStackTrace();
                    }
                }
            } else {
                index = -1;
            }

        }

        scanner.close();

    }
}
