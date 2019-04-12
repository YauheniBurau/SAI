package core.application.workflowModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by anonymous on 28.03.2019.
 */
@Target(value=ElementType.TYPE)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Algo {
    String name() default ""; // name of algo type
    String description() default "No description"; // description of algo. show as tooltip
    boolean isShownName() default true; // on GUI on Node : true - show in title, false - no in title
    String shape() default ""; // defines css -fx-shape as swg-contour and apply it to node in GUI. if empty - used default shape
}
