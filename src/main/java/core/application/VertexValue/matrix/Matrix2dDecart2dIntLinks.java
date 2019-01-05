package core.application.VertexValue.matrix;

import core.application.VertexValue.coords.Decart2dIntLinks;

/**
 * Created by anonymous on 05.01.2019.
 */
public class Matrix2dDecart2dIntLinks extends Matrix2d<Decart2dIntLinks> {

    public Matrix2dDecart2dIntLinks(){
        super(Decart2dIntLinks.class);
    }

    public Matrix2dDecart2dIntLinks(int xSize, int ySize){
        super(Decart2dIntLinks.class, xSize, ySize);
    }

    public Matrix2dDecart2dIntLinks(int xSize, int ySize, Decart2dIntLinks defaultValue){
        super(Decart2dIntLinks.class, xSize, ySize, defaultValue);
    }

}
