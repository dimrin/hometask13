package com.company.dymrin13;

import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> files = new HashMap<>();

    /*
    2 Реализовать метод add в классе FileNavigator.
    Данный метод добавляет файл по указанному пути.
    Если путь уже существует, то новый файл необходимо добавить к списку, уже связанному с соответствующим путем.
    ВАЖНО: Путь - уникальное значение и не должно повторяться.

    7 Реализовать проверку консистентности в методе add в классе FileNavigator.
    Не позволять добавлять значения и сообщить об этом в консоль, при попытке добавить значение FileData значение пути которого не соответствует пути-ключу ведущему к списку файлов.


    */
    public void add(String path, FileData data) {
        if (!path.equals(data.getPath())) {
            throw new IllegalArgumentException(String.format("Target path -> [%s] and file path -> [%s] are not equal", path, data.getPath()));
        }

        if (files.containsKey(path)) {
            files.get(path).add(data);
        } else {
            List<FileData> batchOfFiles = new ArrayList<>();
            batchOfFiles.add(data);
            files.put(path, batchOfFiles);
        }
    }

    /*
    3 Реализовать метод find в классе FileNavigator.
    Метод возвращает список файлов связанных с путем переданным в качестве параметра.


    */
    public List<FileData> find(String path) {
        return files.containsKey(path) ? files.get(path) : Collections.emptyList();
    }

    /*
    4 Реализовать метод filterBySize в классе FileNavigator.
    Метод возвращает список файлов, размер (в байтах) которых не превышает значение переданное в качестве параметра.
    */
    public List<FileData> filterBySize(byte maxSize) {
        List<FileData> filteredFiles = new ArrayList<>();

        for (List<FileData> batchOfFiles : files.values()) {
            for (FileData file : batchOfFiles) {
                if (file.getSize() <= maxSize) {
                    filteredFiles.add(file);
                }
            }

        }
        return filteredFiles;
    }

    /*
    5 Реализовать метод remove в классе FileNavigator.
    Метод удаляет путь и связанные с ним файлы, на основании значения пути, переданного в качестве параметра.
    */

    public void remove(String path) {
        files.remove(path);
    }

    /*
    6 Реализовать метод sortBySize в классе FileNavigator.
    Метод сортирует все имеющиеся файлы по их размеру (по возрастанию), затем возвращает список отсортированных файлов.
    */


    public List<FileData> sortBySize() {
        List<FileData> sortedFiles = new ArrayList<>();
        for (List<FileData> batchOfFiles : files.values()) {
            sortedFiles.addAll(batchOfFiles);
        }
        Collections.sort(sortedFiles, new Comparator<FileData>() {
            @Override
            public int compare(FileData o1, FileData o2) {
                return o1.getSize() - o2.getSize();
            }
        });
        return sortedFiles;
    }
}
