package Task2_FileStructure;

import java.util.regex.Pattern;

public class FolderObject extends FileSystemObject {
    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    String children;
    public FolderObject(String parent, String name, String children) {
        super(parent, name);
        this.children = children;
    }

    @Override
    public void setName(String name) {
        Pattern pattern  =  Pattern.compile("[a-zA-Z+()_!.&]");
        if (pattern.matcher(name).matches() && !name.equals(null) && (!name.startsWith("!") || !name.startsWith("(")
                || !name.startsWith(")") || !name.startsWith("_") || !name.startsWith(".") || !name.startsWith("&"))){
            this.name = name;
        } else {
            throw new IllegalArgumentException("“Invalid name specified");
        }
    }
}
