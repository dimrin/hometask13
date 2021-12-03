package com.company.dymrin13;

public class FileData implements Comparable<FileData> {
    private String path;
    private byte size;
    private String name;

    public FileData(String path, byte size, String name) {
        this.path = path;
        this.size = size;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public byte getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(FileData o) {
        return this.size - o.getSize();
    }
}
