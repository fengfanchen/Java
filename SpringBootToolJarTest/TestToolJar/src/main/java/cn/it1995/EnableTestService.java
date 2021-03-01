package cn.it1995;

import cn.it1995.config.TestServiceAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(TestServiceAutoConfiguration.class)
public @interface EnableTestService {
}
