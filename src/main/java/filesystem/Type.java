package main.java.filesystem;

public enum Type {
    TXT, DIR;
    private static Type[] values = values();

    public Type getValue(int n) {
        return values[n];
    }

}
