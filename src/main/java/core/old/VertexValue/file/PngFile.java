package core.old.VertexValue.file;

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
            //throw new InputParamException("String uri contains wrong file type");
        }
    }

}
