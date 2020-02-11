import demo.Pro;

import java.lang.reflect.Method;

@Pro(className = "demo.Test", methodName = "show")
public class MainTest {

    public static void main(String[] arg) throws Exception{

        //解析注释，获取该类的字节码文件对象
        Class mainTestClass = MainTest.class;

        //获取注解对象，内存中生成了一个该注解接口的子类实例
        Pro annotation = (Pro) mainTestClass.getAnnotation(Pro.class);

        //调用抽象方法，获取数据
        String s = annotation.className();
        String s1 = annotation.methodName();


        //加载该类进内存
        Class aClass = Class.forName(s);

        //创建对象
        Object o = aClass.newInstance();

        //获取方法对象
        Method method = aClass.getMethod(s1);

        //执行方法
        method.invoke(o);
    }
}
