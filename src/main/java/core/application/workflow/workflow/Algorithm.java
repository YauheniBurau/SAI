package core.application.workflow.workflow;

import java.lang.annotation.*;

/**
 * Created by anonymous on 28.03.2019.
 */
@Target(value=ElementType.TYPE)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Algorithm {
    String name() default "No name";
    String description() default "No description";
}
