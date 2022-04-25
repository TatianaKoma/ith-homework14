package ua.iihillel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<FileData>> files = new HashMap<>();

        FileData file1 = new FileData("files.txt66", (byte) 40, "C:\\Projects\\Homeworks");
        FileData file2 = new FileData("files.txt77", (byte) 75, "C:\\Publications\\Travelblog");
        FileData file3 = new FileData("files.txt88", (byte) 80, "C:\\Projects\\Homeworks");
        FileData file4 = new FileData("files.txt99", (byte) 10, "C:\\Projects\\Homeworks");
        FileNavigator fileNavigator = new FileNavigator();

        System.out.println(fileNavigator.add(file1, files));
        System.out.println(fileNavigator.add(file2, files));
        System.out.println(fileNavigator.add(file3, files));
        System.out.println(fileNavigator.add(file4, files));

        String path = "C:\\Projects\\Homeworks";
        System.out.println(fileNavigator.find(path, files));
        System.out.println(fileNavigator.filterBySize((byte) 80, files));
        System.out.println(fileNavigator.remove("C:\\Publications\\Travelblog", files));
        System.out.println(fileNavigator.sortBySize(files));
        System.out.println(fileNavigator.addIfPathExists("C:\\Projects\\Homeworks", file1));
        System.out.println(fileNavigator.addIfPathExists("C:\\Projects\\Homeworks", file2));
    }
}
