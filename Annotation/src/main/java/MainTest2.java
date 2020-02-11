import demo2.Calculator;
import demo2.Check;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;

public class MainTest2 {

    public static void main(String[] arg) throws Exception{

        //创建计算器对象
        Calculator c = new Calculator();

        //获取字节码文件对象
        Class cls = c.getClass();
        //获取所有方法
        Method[] methods = cls.getMethods();

        int number = 0;//出现异常的此数
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        for(Method method : methods){

            //判断方法上是否有Check注解
            if(method.isAnnotationPresent(Check.class)){

                //有就执行
                try{

                    method.invoke(c);
                }
                catch (Exception e){

                    //获取异常，记录到文件
                    number++;

                    bw.write(method.getName() + "方法出现异常");
                    bw.newLine();
                    bw.write("异常名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因：" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("------------------------------");
                }
            }
        }

        bw.newLine();
        bw.write("本次测试一共出现 " + number + " 次异常");
        bw.flush();
        bw.close();

    }
}
