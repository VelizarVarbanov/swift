package Task2_FileStructure;

import java.util.regex.Pattern;

public class FileObject extends FileSystemObject {

    public String fileEx;

    public FileObject(String parent, String name, String newExtention) {
        super(parent, name);
        this.setFileEx(newExtention);

    }

    public String getFileEx() {
        return fileEx;
    }

    public void setFileEx(String newExtention) {
        this.fileEx = newExtention;
    }


    @Override
    public void setName(String name) {
        Pattern pattern  =  Pattern.compile("[a-zA-Z+()_!.&]");
        if (pattern.matcher(name).matches() && !name.equals(null) && (!name.startsWith("!") || !name.startsWith("(")
                || !name.startsWith(")") || !name.startsWith("_") || !name.startsWith(".") || !name.startsWith("&"))
                && fileEx.length() <= 6){
            this.name = name;
        } else {
            throw new IllegalArgumentException("“Invalid name specified");
        }

    }


}
