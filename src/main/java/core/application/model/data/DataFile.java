package core.application.model.data;

import java.io.File;

/**
 * Created by anonymous on 23.03.2019.
 */
public class DataFile extends Data<File>{

    public DataFile() {
        super("File", null);
    }

    public DataFile(File data) {
        super("File", data);
    }

}
