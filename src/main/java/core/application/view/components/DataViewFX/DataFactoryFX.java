package core.application.view.components.DataViewFX;

import core.application.view.components.WorkFlowFX.AbstractDataFX;
import core.application.workflow.workflow.Data;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by anonymous on 27.03.2019.
 */
public class DataFactoryFX {
    public static AbstractDataFX constructDataFX(Data data){
        if( checkDataType(data, BufferedImage.class) ){ return new DataBufferedImageFX(data); }
        if( checkDataType(data, File.class) ){ return new DataFileFX(data); }
        if( checkDataType(data, Integer.class) ){ return new DataIntegerFX(data); }
        if( checkDataType(data, String.class ) ){ return new DataStringFX(data); }
        // TODO: add here new Data classes
        return null;
    }

    private static boolean checkDataType(Data data, Class clazz){
        boolean result = false;
        if(data.getValue().getClass() == clazz){
            result = true;
        }
        return result;
    }

}
