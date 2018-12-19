package core.old;

import java.util.LinkedList;

// TODO: remove later
/**
 * Created by anonymous on 23.09.2018.
 */
public class NormalizedPolarConture {
    public LinkedList<NormalizedPolarPoint> points = new LinkedList<NormalizedPolarPoint>();

    /**
     * 0..255 is full circle rotation
     * @param angle
     * @return
     */
    public NormalizedPolarConture rotate(int angle){
        NormalizedPolarConture result = new NormalizedPolarConture();
        for(NormalizedPolarPoint npp: this.points){
            npp.rotate(angle);
        }
        return this;
    }


}
