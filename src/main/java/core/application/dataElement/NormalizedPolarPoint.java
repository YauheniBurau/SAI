package core.application.dataElement;

/**
 * Created by anonymous on 26.09.2018.
 */
public class NormalizedPolarPoint extends AbstractElement{
    public byte a; // a
    public byte r; // r - distance from center

    public NormalizedPolarPoint(byte angle, byte r) {
        this.a = angle;
        this.r = r;
    }

    /**
     * rotate normalizedPolarPoint where whole circle is from 0 to 255 angle points
     * @param angle
     * @return
     */
    public NormalizedPolarPoint rotate(int angle){
//        int newAngle = (this.a + 128 + angle) % 256;
//        if(newAngle<0) {
//            newAngle = 256
//        }
        this.a -=angle;
        return this;
    }

}
