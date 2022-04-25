package ua.iihillel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileNavigator {
    public Map<String, List<FileData>> add(FileData file, Map<String, List<FileData>> fileStorage) {
        if (fileStorage.containsKey(file.getPath()) || fileStorage.get(file.getPath()) == null) {
            fileStorage.computeIfAbsent(file.getPath(), k -> new ArrayList<>()).add(file);
        }
        return fileStorage;
    }

    public List<FileData> find(String path, Map<String, List<FileData>> fileStorage) {
        return fileStorage.getOrDefault(path, null);
    }

    public List<FileData> filterBySize(byte sizeOfFile, Map<String, List<FileData>> fileStorage) {
        List<FileData> smallFiles = fileStorage.values().stream()
                .flatMap(List::stream)
                .filter(x -> x.getSize() < sizeOfFile)
                .collect(Collectors.toList());

        return smallFiles;

    }

    public Map<String, List<FileData>> remove(String path, Map<String, List<FileData>> fileStorage) {
        fileStorage.entrySet().removeIf(entry -> entry.getKey().equals(path));
        return fileStorage;
    }

    public List<FileData> sortBySize(Map<String, List<FileData>> fileStorage) {
        List<FileData> sortedFiles = fileStorage.values().stream()
                .flatMap(List::stream)
                .sorted((o1, o2) -> (o1.getSize() - o2.getSize()))
                .collect(Collectors.toList());
        return sortedFiles;
    }

    public Map<String, List<FileData>> addIfPathExists(String path, FileData file) {
        Map<String, List<FileData>> fileStorage = new HashMap<>();
        try {
            checkIsPathValid(path, file, fileStorage);
            fileStorage.computeIfAbsent(file.getPath(), k -> new ArrayList<>()).add(file);
        } catch (InvalidPathToFileExeption e) {
            e.printStackTrace();
        }
        return fileStorage;
    }

    public static void checkIsPathValid(String path, FileData file,
                                        Map<String, List<FileData>> fileStorage) throws InvalidPathToFileExeption {
        if (!path.equals(file.getPath()) || fileStorage.get(file.getPath()) != null) {
            String message = " Path: " + path + "\n" + file;
            throw new InvalidPathToFileExeption(message);
        }
    }
}
