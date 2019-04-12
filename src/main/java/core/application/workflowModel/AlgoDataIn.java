package core.application.workflowModel;

import core.application.workflowView.DataDefaultFX;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AlgoDataIn {
    /**
     * every algoDataIn must have it own unique TypeName
     * @return
     */
    String name() default "";

    /**
     * for showing info in tooltip
     * @return
     */
    String description() default "no description";

    /**
     * name of AlgoDataIn
     * if true - on GUI on Node you can see it
     * @return
     */
    boolean showName() default true;

    /**
     * if true - on GUI on Node you can see it
     * @return
     */
    boolean showDataIn() default false;

    /**
     * class for view in JavaFX GUI
     */
    Class dataFXClass() default DataDefaultFX.class;

}
