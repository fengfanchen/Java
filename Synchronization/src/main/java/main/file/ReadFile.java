package main.file;

import lombok.Data;
import main.Exception.ReadFileException;
import main.errorEm.ReadFileEm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReadFile {

    @Data
    class SQLTemplateStruct{

        public String index;
        public String data;
    }

    //存sqlCMD文件
    private static Map<String, Map<String, String>> m_sqlTemplateMap = new HashMap<String, Map<String, String>>();
    private static Map<Integer, String> m_sqlMap = new HashMap<Integer, String>();

    public void createCMD() throws IOException {

        /***
         * 读取命令文件
         */
        FileReader reader = new FileReader("E:\\IdeaProject2019\\Synchronization\\src\\main\\resources\\command\\sqlCmd.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String str = null;

        Integer index = 0;
        while ((str = bufferedReader.readLine()) != null){

            if(str.contains("#"))
                continue;;
            m_sqlTemplateMap.put(index.toString(), getSingleMap(str));
            index++;
        }

        bufferedReader.close();
        reader.close();

        System.out.println("sqlCmd文件读取解析结束：" + m_sqlTemplateMap);

        /***
         * 读取模板文件
         */
        createTemplateSqlFile();


        return;

    }

    /**
     * 获取单条数据
     * @param str
     * @return
     */
    protected Map<String, String> getSingleMap(String str){

        Map<String, String> fileMap = new HashMap<String, String>();

        String[] split = str.split(" ");
        fileMap.put("索引", getTemplateIndex(split[0]));
        for(int i = 1; i < split.length; i++){

            SQLTemplateStruct templateString = getTemplateString(split[i]);
            fileMap.put(templateString.getIndex(), templateString.getData());
        }

        return fileMap;
    }

    /***
     * 获取Template前面的索引号
     * @param str
     * @return
     */
    protected String getTemplateIndex(String str){

        String ret = null;

        if(!str.contains("$")){

                throw new ReadFileException(ReadFileEm.SQL_TEMPLATE_INDEX_ERROR);
        }

        ret = str.replace("$","");
        return ret;
    }

    /***
     * 获取里面具体的数据
     * @param str
     * @return
     */
    protected SQLTemplateStruct getTemplateString(String str){

        SQLTemplateStruct struct = new SQLTemplateStruct();

        if(!str.contains("%") && !str.contains(">")){

            throw new ReadFileException(ReadFileEm.SQL_TEMPLATE_STRING_ERROR);
        }

        String[] split = str.split(">");
        if(split.length < 2){

            throw new ReadFileException(ReadFileEm.SQL_LACK_STRING_ERROR);
        }
        struct.setIndex("%" + split[0].substring(1));
        struct.setData(split[1]);

        return struct;
    }

    /***
     * 填充此文件
     * @throws IOException
     */
    protected void createTemplateSqlFile() throws IOException {

        FileReader reader = new FileReader("E:\\IdeaProject2019\\Synchronization\\src\\main\\resources\\command\\sqlTemplate.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String str = null;

        Map<Integer, String> map = new HashMap<Integer, String>();

        while ((str = bufferedReader.readLine()) != null){

            String index = str.substring(0, str.indexOf('@')).replace(" ", "");
            str = str.substring(0, str.indexOf('#')).substring(str.indexOf('@') + 1);
            //System.out.println(index + " " + str);
            map.put(Integer.parseInt(index), str);
        }

        bufferedReader.close();
        reader.close();

        //进行拼接，填充 m_sqlMap
        Set<String> stringSet = m_sqlTemplateMap.keySet();
        Integer index = 0;
        for(String key : stringSet){

            String fStr = map.get(Integer.parseInt(m_sqlTemplateMap.get(key).get("索引")));

            Set<String> stringSet1 = m_sqlTemplateMap.get(key).keySet();
            for(String value : stringSet1){

                fStr = fStr.replace(value, m_sqlTemplateMap.get(key).get(value));
            }
            m_sqlMap.put(index++, fStr);
        }

        System.out.println("sql指令匹配完成，依次如下：" + m_sqlMap);
    }

    public static Map<Integer, String> getSqlMap() {
        
        return m_sqlMap;
    }
}
