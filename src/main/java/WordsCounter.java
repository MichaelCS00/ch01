import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

/**
 * @Classname Test
 * @Description 统计全文的词汇量
 * @Date 7/16/2019 3:41 PM
 * @Created by MichaelCS
 */
@Slf4j
public class WordsCounter {
    // 用于记录统计结果
    private Set<String> resultSet = new HashSet<String>();
    public void countWords(File file){
        generateResultSet(file);
        displayResult();
    }
    public void generateResultSet(File file){
        // 一行字符串
        String lineString = null;
        // 创建文件输入流
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 创建bufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try{
            while((lineString = reader.readLine()) != null){
                // 去除串中的空白部分
                lineString = lineString.trim();
                // 用正则匹配划分单词
                String[] words = lineString.split("(\\s+\\W+)|[\\s+\\W+]");
                resultSet.addAll(Arrays.asList(words));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        // 去除空串
        resultSet.remove("");
    }
    public void displayResult(){
        log.info(String.format("本文词汇量: %s",resultSet.size()));
    }

}
