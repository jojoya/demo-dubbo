package com.example.csv.comm;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.example.csv.comm.os.OSinfo;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil  extends DataUtil {

    public static char separator = ',';

    /**
     * 读取CSV文件
     * @param filePath:全路径名
     */
    public static List<String[]> readCSV(String filePath) {
        CsvReader reader = null;
        List<String[]> dataList = new ArrayList<String[]>();
        try {
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            switch (OSinfo.getOSname().toString()){
                case "Windows":
                    reader = new CsvReader(filePath, separator, Charset.forName("GBK"));break;
                default:
                    reader = new CsvReader(filePath, separator, Charset.forName("UTF-8"));
            }

            // 读取表头
            reader.readHeaders();
            String[] headArray = reader.getHeaders();//获取标题
            System.out.println(headArray[0] + headArray[1] + headArray[2]);

            // 逐条读取记录，直至读完
            while (reader.readRecord()) {
                // 读一整行
                System.out.println(reader.getRawRecord());
                // 读这行的第一列
                System.out.println(reader.get("学号"));
                // 读这行的第二列
                System.out.println(reader.get(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                reader.close();
            }
        }

        return dataList;
    }


    /**
     * 生成CSV文件
     * @param dataList:数据集
     * @param filePath:全路径名
     */
    public static boolean createCSV(List<String[]> dataList, String filePath) {
        boolean isSuccess = false;
        CsvWriter writer = null;
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath, true);
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            switch (OSinfo.getOSname().toString()){
                case "Windows":
                    writer = new CsvWriter(out, separator, Charset.forName("GBK"));break;
                default:
                    writer = new CsvWriter(out, separator, Charset.forName("UTF-8"));
            }

            for (String[] strs : dataList) {
                writer.writeRecord(strs);
            }
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                writer.close();
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSuccess;
    }


    public static void main(String[] args) throws Exception {
        // 测试导出
        String filePath = "d:/scoreInfo.csv";
        File file = new File(filePath);
        FileUtil.delFile(file);

        file.createNewFile();

        List<String[]> dataList = new ArrayList<String[]>();
        //添加标题
        dataList.add(new String[]{"学号", "姓名", "分数"});
        for (int i = 0; i < 10; i++) {
            dataList.add(new String[]{"2010000" + i, "张三" + i, "8" + i});
        }
        createCSV(dataList, filePath);

        // 读取CSV文件
        rowCount(filePath);
        readCSV(filePath);

    }
}
