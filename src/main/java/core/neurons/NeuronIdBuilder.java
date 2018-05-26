package core.neurons;

/**
 * Created by anonymous on 09.02.2018.
 */
public class NeuronIdBuilder {

    private static double index = 0;

    public static double getIndex() {
        return index;
    }


    // TODO: make into converting number into [a-b,A-B,0-9]
    public static String generateId(){
        index++;
        String str = Double.toString(NeuronIdBuilder.getIndex());
        return str;
    }

}
