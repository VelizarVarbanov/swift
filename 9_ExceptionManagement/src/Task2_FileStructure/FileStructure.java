package Task2_FileStructure;

import java.util.Scanner;

public class FileStructure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";

        do {
            input = sc.nextLine();
            if (input.equalsIgnoreCase("END")) break;

            try{
                String[] split = input.split(" ");
                String allNames = input.substring(input.lastIndexOf(" ") + 1);
                String fileNameExt = input.substring(input.lastIndexOf("/") + 1);
                String[] folderName = allNames.split("/");
                String[] nameAndExt = fileNameExt.split("\\.");
                String extention = input.substring(input.lastIndexOf(".") + 1);

                if(split[0].equalsIgnoreCase("touch")){
                    FileObject file = new FileObject(folderName[0], nameAndExt[0], extention);
                }

            } catch (Exception ex) {
                System.out.println("Invalid command");
            }

        } while (!input.equalsIgnoreCase("END"));

    }
}
