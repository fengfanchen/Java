package demo;

public @interface AnnoDemo2 {

    int age();
    String name() default "王二麻子";

}
