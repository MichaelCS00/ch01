import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.*;

/**
 * @Classname Test
 * @Description 统计每一行的单词情况
 * @Date 7/16/2019 3:41 PM
 * @Created by MichaelCS
 */

@Slf4j
public class LineCounter {
    // 用于记录统计结果
    private Set<String> resultSet = new HashSet<String>();
    // 用于记录行统计结果resultList
    private List<Set> resultList = new ArrayList<Set>();
    public void countLine(File file){
        generateResultList(file);
        displayResult();
    }
    public void generateResultList(File file){
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
                resultList.add(resultSet);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        // 去除空串
        resultSet.remove("");
    }
    public void displayResult(){
        int index = 1;
        for(Set set : resultList){
            Iterator ite = set.iterator();
            log.info(String.format("Sentence: %s",index));
            while(ite.hasNext()) {
                String word = (String) ite.next();
                log.info(String.format("word: %s",word));
            }
            index++;
        }
    }
}
