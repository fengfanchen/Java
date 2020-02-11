package demo;

import java.lang.annotation.*;

@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AnnoDemo3 {


}
