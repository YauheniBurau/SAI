package core.application.gui.workflowFxComponent.param;

import javafx.beans.value.ObservableValue;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.editor.PropertyEditor;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class StaticMethod implements PropertySheet.Item{
    private Method mtd;
    private Class<?> clazz;
    private Collection<Method> staticMethods;
    private String testStr;
    private String category;
    private String name;

    public StaticMethod(Class<?> clazz) {
        this.clazz = clazz;
        this.staticMethods = getClassStaticMethods(clazz);
        this.testStr = "test24332";
        if(this.staticMethods.size()>0){
            this.mtd = this.staticMethods.iterator().next();
        }
    }

    private static Collection<Method> getClassStaticMethods(Class<?> clazz) {
        List<Method> classStaticMethods = new ArrayList<>();
        for (Method method : clazz.getMethods()) {
            if (Modifier.isStatic(method.getModifiers())) {
                classStaticMethods.add(method);
            }
        }
        return classStaticMethods;
    }

    public StaticMethod setClazz(Class<?> clazz) {
        this.clazz = clazz;
        this.setStaticMethods( getClassStaticMethods(this.getClazz()) );
        return this;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setMtd(Method mtd) {
        this.mtd = mtd;
    }

    public Method getMtd() {
        return this.mtd;
    }

    public Collection<Method> getStaticMethods() {
        return staticMethods;
    }

    public void setStaticMethods(Collection<Method> staticMethods) {
        this.staticMethods = staticMethods;
    }

    public StaticMethod setCategory(String category) {
        this.category = category;
        return this;
    }

    public StaticMethod setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Class<?> getType() {
        return this.getClass();
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return clazz.getSimpleName();
    }

    @Override
    public Object getValue() {
        return this;
    }

    @Override
    public void setValue(Object o) {
        StaticMethod val = (StaticMethod)o;
        setClazz(val.getClazz());
        setMtd(val.getMtd());
        setCategory(val.getCategory());
        setName(val.getName());
        setStaticMethods(val.getStaticMethods());
    }

    @Override
    public Optional<ObservableValue<? extends Object>> getObservableValue() {
        return Optional.empty();
    }

    @Override
    public Optional<Class<? extends PropertyEditor<?>>> getPropertyEditorClass() {
        return Optional.of(StaticMethodEditor.class);
    }
}
