package core.application.VertexValue.file;

import core.application.exceptions.InputParamException;

/**
 * Created by anonymous on 21.09.2018.
 */
public class PngFile implements IFile {
    public String urlFile = null;

    public PngFile() {
    }

    public PngFile(String urlFile) {
        int start = urlFile.length()-3;
        if(urlFile.substring(start).equalsIgnoreCase("png")) {
            this.urlFile = urlFile;
        }else{
            throw new InputParamException("String uri contains wrong file type");
        }
    }

}