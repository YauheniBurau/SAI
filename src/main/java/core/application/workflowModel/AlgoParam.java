package core.application.workflowModel;

import core.application.workflowView.ParamDefaultFX;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface AlgoParam {
//    /**
//     * every algoParam must have it onw unique TypeName
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
//     * name of param consists nameType of param and unique idName
//     * @return
//     */
//    boolean showName() default true;
//
//    /**
//     * if true - on GUI on Node you can see and edit param
//     * @return
//     */
//    boolean showParam() default false;
//
//    /**
//     * class for view and edit in JavaFX GUI
//     */
//    Class paramFXClass() default ParamDefaultFX.class;
//
}
