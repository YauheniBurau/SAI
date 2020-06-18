package core.old.workflowModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AlgoDataOut {
//    /**
//     * every algoDataOut must have it own unique TypeName
//     * @return
//     */
//    String name() default "";
//
//    /**
//     * for showing info in tooltip
//     * @return
//     */
//    String description() default "no description";
//
//    /**
//     * name of AlgoDataOut consists of nameType of DataOut and unique idName
//     * if true - on GUI on Node you can see it
//     * @return
//     */
//    boolean showName() default true;
//
//    /**
//     * if true - on GUI on Node you can see it
//     * @return
//     */
//    boolean showDataOut() default false;
//
//    /**
//     * class for view in JavaFX GUI
//     */
//    Class dataFXClass() default DataDefaultFX.class;
}
