package core.element;

/**
 * Created by anonymous on 06.10.2017.
 */
public interface IMatrix2d<E> {

    public void setValue(int xPos, int yPos, E value);
    public E getValue(int xPos, int yPos);


}
