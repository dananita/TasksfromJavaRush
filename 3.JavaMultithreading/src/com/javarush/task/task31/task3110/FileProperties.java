package com.javarush.task.task31.task3110;

/**
 * @author Daria Zhuravel
 * @date 26.03.18
 **/
public class FileProperties {
    private String name;
    private long size;
    private long compressedSize;
    private int compressionMethod;


    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    public String getName() {
        return name;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public long getCompressionRatio(){
        return (long) 100 - ((compressedSize * 100) / size);
    }

    @Override
    public String toString() {
        String result = name;
        if (size > 0){
            result = String.format("%s %d Kb(%d Kb) сжатие: %d%%", name, size / 1024, compressedSize / 1024, getCompressionRatio());
        }
        return result;
    }
}
