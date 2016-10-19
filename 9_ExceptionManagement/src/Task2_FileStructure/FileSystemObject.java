package Task2_FileStructure;


import java.util.regex.Pattern;

public abstract class FileSystemObject {
    private String parent;
    String name;

    public FileSystemObject (String parent, String name) {
        this.setParent(parent);
        this.setName(name);
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
    public String getParent() {
        return this.parent;
    }
    public abstract void setName(String name);
    public String getName() {
        return this.name;
    }
}
