package cn.it1995.demo;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Entitlement ent = (Entitlement)ctx.getBean("entitlement");

        System.out.println(ent.getName());
        System.out.println(ent.getTime());

        System.out.println("-----------------------------------------------------------");

        AppConfig appConfig = ctx.getBean(AppConfig.class);
        Entitlement entitlement = appConfig.entitlement();
        System.out.println(entitlement.getName());
        System.out.println(entitlement.getTime());

    }
}
