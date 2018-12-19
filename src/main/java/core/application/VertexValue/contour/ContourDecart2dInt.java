package core.application.VertexValue.contour;

import core.application.VertexValue.coords.Decart2dInt;

/**
 * Created by anonymous on 15.11.2018.
 */
public class ContourDecart2dInt extends Contour<Decart2dInt> {

    /**
     * Conture -> Conture Center as Decart2dInt
     * @return
     */
    public Decart2dInt countContourCenter(){
        int n = 0;
        double cx = 0;
        double cy = 0;
        for(Decart2dInt p: this.elements) {
            n +=1;
            cx += p.x;
            cy += p.y;
        }
        if(n>0) {
            cx /= n;
            cy /= n;
        }
        return new Decart2dInt((int)cx, (int)cy);
    }




}
