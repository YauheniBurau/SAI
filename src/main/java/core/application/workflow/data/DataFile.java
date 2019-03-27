package core.application.workflow.data;

import java.io.File;

/**
 * Created by anonymous on 23.03.2019.
 */
public class DataFile extends AbstractData<File>{

    public DataFile(String name, File value) {
        this.setName(name);
        this.setValue(value);
    }

}
