package com.example.csv.comm;

import java.io.File;

public class FileUtil {

    public static boolean delFile(File file) {
        if (!file.exists()) {
            return true;
        }

        if (file.isDirectory()) {
            delDirectory(file);
        }
        return file.delete();
    }

    public static boolean delDirectory(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            delFile(f);
        }
        return file.delete();
    }
}
