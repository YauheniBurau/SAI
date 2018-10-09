package core.element;

import core.exceptions.InputParamException;

/**
 * Created by anonymous on 21.09.2018.
 */
public class PngFile extends AbstractElement{
    public String urlFile = null;

    public PngFile(String urlFile) {
        int start = urlFile.length()-3;
        if(urlFile.substring(start).equalsIgnoreCase("png")) {
            this.urlFile = urlFile;
        }else{
            throw new InputParamException("String uri contains wrong file type");
        }
    }

}
