package core.application.view.components.DataViewFX;

import core.application.view.components.WorkFlowFX.AbstractDataFX;
import core.application.workflow.data.*;

/**
 * Created by anonymous on 27.03.2019.
 */
public class DataViewFactory {
    public static AbstractDataFX constructDataFX(IData data){
        if( data.getClass() == DataBufferedImage.class ){ return new DataBufferedImageFX((DataBufferedImage) data); }
        if( data.getClass() == DataFile.class ){ return new DataFileFX((DataFile) data); }
        if( data.getClass() == DataInteger.class ){ return new DataIntegerFX((DataInteger) data); }
        if( data.getClass() == DataString.class ){ return new DataStringFX((DataString) data); }
        // TODO: add here new Data classes

        return null;
    }

}
