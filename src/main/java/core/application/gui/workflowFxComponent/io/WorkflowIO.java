package core.application.gui.workflowFxComponent.io;

import core.application.gui.workflowFxComponent.model.WorkflowModel;

import java.io.*;

public class WorkflowIO {
    private File file;

    public WorkflowIO() {
        this.file = null;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    /**
     * load file and deserialize to workflowModel object
     *
     * @param file
     * @return
     */
    public static WorkflowModel load(File file){
        WorkflowModel workflowModel = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            workflowModel = (WorkflowModel) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return workflowModel;
    }

    /**
     * serialize and save workflowModel object to File
     * @param workflowModel
     * @param file
     * @return
     */
    public static File save(WorkflowModel workflowModel, File file){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(workflowModel);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
