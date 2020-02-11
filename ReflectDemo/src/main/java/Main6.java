import Object.Person;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Main6 {

    public static void main(String[] args) throws Exception {


        /***
         * 加载配置文件
         *      创建Properties对象
         *      加载配置文件，转换为集合
         *      获取class目录下的配置文件
         */
        Properties pro = new Properties();
        ClassLoader classLoader = Person.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("application.properties");
        pro.load(resourceAsStream);


        //配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //加载该类到内存
        Class aClass = Class.forName(className);
        Object o = aClass.newInstance();

        //获取方法并执行
        Method method = aClass.getMethod(methodName);
        method.invoke(o);
    }
}
