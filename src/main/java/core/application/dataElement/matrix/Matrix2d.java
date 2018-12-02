package core.application.dataElement.matrix;

import core.application.dataElement.IDataElement;
import java.lang.reflect.Array;

/**
 * Created by anonymous on 29.10.2018.
 */
public class Matrix2d<T> implements IMatrix, IDataElement {
    private Class<T> elementClass;
    protected T[][] values;
    public int sizeX;
    public int sizeY;

    /**
     * create empty class with values = null
     */
    public Matrix2d(Class<T> clazz) {
        this.sizeX = 1;
        this.sizeY = 1;
        elementClass = clazz;
        this.values = (T[][]) Array.newInstance(clazz, this.sizeY, this.sizeX);
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, null);
            }
        }

    }

    /**
     * create Matrix2d with all values equal null
     * @param clazz
     * @param xSize
     * @param ySize
     */
    public Matrix2d(Class<T> clazz, int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        elementClass = clazz;
        this.values = (T[][]) Array.newInstance(clazz, ySize, xSize);
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, null);
            }
        }
    }

    /**
     * set all elements as single instance of defaultValue
     * @param clazz
     * @param xSize
     * @param ySize
     * @param defaultValue
     */
    public Matrix2d(Class<T> clazz, int xSize, int ySize, T defaultValue) {
        elementClass = clazz;
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.values = (T[][]) Array.newInstance(clazz, ySize, xSize);
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, defaultValue);
            }
        }
    }

    /**
     * setValue into Matrix2d
     * @param xPos
     * @param yPos
     * @param value
     */
    public void setValue(int xPos, int yPos, T value) {
        if (xPos >= 0 && xPos < this.sizeX && yPos >= 0 && yPos < this.sizeY) {
            this.values[yPos][xPos] = value;
        }
    }

    /**
     * getValue from Matrix2d
     * @param xPos
     * @param yPos
     * @return
     */
    public T getValue(int xPos, int yPos) {
        if (xPos >= 0 && xPos < this.sizeX && yPos >= 0 && yPos < this.sizeY) {
            return this.values[yPos][xPos];
        }
        return null;
    }

    /**
     * set new size of Matrix2d, all data will be rewritten with defaultValue
     * @param xSize
     * @param ySize
     * @param defaultValue
     */
    public void setSizeXY(int xSize, int ySize, T defaultValue) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.values = (T[][]) Array.newInstance(this.elementClass, ySize, xSize);
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, defaultValue);
            }
        }
    }

    /**
     * set new size of Matrix2d, all data will be rewritten with "null" value
     * @param xSize
     * @param ySize
     */
    public void setSizeXY(int xSize, int ySize) {
        this.setSizeXY(xSize, ySize, null);
    }

    /**
     * count number of not null elements
     * @return
     */
    public int countNotNullElements(){
        int n = 0;
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                T value = this.getValue(i, j);
                if( value!=null ){
                    n+=1;
                }
            }
        }
        return n;
    }

}
