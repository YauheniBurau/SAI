package core.neurons;

/**
 * Created by anonymous on 09.02.2018.
 */
public class AksonIdBuilder {
    private static double index = 0;

    public static double getIndex() {
        return AksonIdBuilder.index;
    }

    // TODO: make into converting number into [a-b,A-B,0-9]
    public static String generateId(){
        AksonIdBuilder.index++;
        String str = Double.toString(AksonIdBuilder.getIndex());
        return str;
    }


}
