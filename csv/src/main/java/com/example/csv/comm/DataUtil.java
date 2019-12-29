package com.example.csv.comm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

public abstract class DataUtil {

    public static final Logger logger = LoggerFactory.getLogger(DataUtil.class);

    public static Integer rowCount(String filePath){
        int lines=0;
        File file5=new File(filePath);
        long fileLength = file5.length();
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file5));
            lineNumberReader.skip(fileLength);
            lines=lineNumberReader.getLineNumber();
            lineNumberReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info(String.valueOf(lines));
        return lines;
    }

//    public static boolean createDataFile(List<String[]> dataList, String filePath){
//        return true;
//    }
//    public static List<String[]> readDataFile(String filePath){
//        return null;
//    }
}
