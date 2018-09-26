package core.element;

/**
 * Created by anonymous on 21.09.2018.
 */
public class Transformation {
    public double shiftX = 0;
    public double shiftY = 0;
    public double scaling = 0;
    public double rotation = 0;
    public double form = 0;
    public double texture = 0;



    public Transformation(double shiftX, double shiftY, double scaling, double rotation) {
        this.shiftX = shiftX;
        this.shiftY = shiftY;
        this.scaling = scaling;
        this.rotation = rotation;
    }

    public void setShiftX(double shiftX) {
        this.shiftX = shiftX;
    }

    public void setShiftY(double shiftY) {
        this.shiftY = shiftY;
    }

    public String toString(){
        return "Scaling: " + scaling + "%\n" +
               "Rotation: " + rotation + "%\n" +
               "Form: " + form + "%\n" +
               "Texture: " + texture + "%";
    }

}
