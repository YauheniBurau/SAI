package core.application.VertexValue.matrix;

import java.lang.reflect.Array;

/**
 * Created by anonymous on 10.11.2018.
 */
public class Matrix1d <T> implements IMatrix {
    private Class<T> elementClass;
    protected T[] values;
    public int size;

    /**
     * create empty class with values = null
     */
    public Matrix1d() {
        this.size = 0;
        this.values = null;
    }

    /**
     * create Matrix1d with all values equal null
     * @param clazz
     * @param size
     */
    public Matrix1d(Class<T> clazz, int size) {
        this.size = size;
        elementClass = clazz;
        this.values = (T[]) Array.newInstance(clazz, size);
        for (int i = 0; i < this.size; i++) {
            this.setValue(i, null);
        }
    }

    /**
     * set all elements as single instance of defaultValue
     * @param clazz
     * @param size
     * @param defaultValue
     */
    public Matrix1d(Class<T> clazz, int size, T defaultValue) {
        this.size = size;
        elementClass = clazz;
        this.values = (T[]) Array.newInstance(clazz, size);
        for (int i = 0; i < this.size; i++) {
            this.setValue(i, defaultValue);
        }
    }

    /**
     * setValue into Matrix1d
     * @param index
     * @param value
     */
    public void setValue(int index, T value) {
        if (index >= 0 && index < this.size) {
            this.values[index] = value;
        }
    }

    /**
     * getValue from Matrix1d
     * @param index
     * @return
     */
    public T getValue(int index) {
        if (index >= 0 && index < this.size) {
            return this.values[index];
        }
        return null;
    }

    /**
     * set new size of Matrix1d, all data will be rewritten with defaultValue
     * @param size
     * @param defaultValue
     */
    public void setSize(int size, T defaultValue) {
        this.size = size;
        this.values = (T[]) Array.newInstance(this.elementClass, size);
        for (int i = 0; i < this.size; i++) {
            this.setValue(i, defaultValue);
        }
    }

    /**
     * set new size of Matrix1d, all data will be rewritten with "null" value
     * @param size
     */
    public void setSize(int size) {
        this.setSize(size, null);
    }

    /**
     * count number of not null elements
     * @return
     */
    public int countNotNullElements(){
        int n = 0;
        for (int i = 0; i < this.size; i++) {
            T value = this.getValue(i);
            if( value!=null ){ n+=1; }
        }
        return n;
    }

}
