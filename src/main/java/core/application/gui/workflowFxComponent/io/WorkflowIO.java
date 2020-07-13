package core.application.gui.workflowFxComponent.io;

import core.application.gui.workflowFxComponent.model.WorkflowModel;
import core.application.gui.workflowFxComponent.model.WorkflowVertex;
import core.application.gui.factoryFx.NotificationsFxFactory;

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
     * load file *.wfs and deserialize to workflowModel object
     *
     * @param file
     * @return
     */
    public static WorkflowModel loadWorkflow(File file){
        WorkflowModel workflowModel = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            workflowModel = (WorkflowModel) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            NotificationsFxFactory.showError(
                    "load file *.wfs and deserialize to workflowModel object", e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            NotificationsFxFactory.showError(
                    "load file *.wfs and deserialize to workflowModel object", e.getMessage(), e);
        }
        return workflowModel;
    }

    /**
     * serialize and save workflowModel object to File *.wfs
     * @param workflowModel
     * @param file
     * @return
     */
    public static File saveWorkflow(WorkflowModel workflowModel, File file){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(workflowModel);
            objectOutputStream.close();
        } catch (IOException e) {
            NotificationsFxFactory.showError(
                    "serialize and save workflowModel object to File *.wfs", e.getMessage(), e);
        }
        return file;
    }

    /**
     * load file *.wfv and deserialize to workflowVertex object
     *
     * @param file
     * @return
     */
    public static WorkflowVertex loadWorkflowVertex(File file){
        WorkflowVertex workflowVertex = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            workflowVertex = (WorkflowVertex) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            NotificationsFxFactory.showError(
                    "load file *.wfv and deserialize to workflowVertex object", e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            NotificationsFxFactory.showError(
                    "load file *.wfv and deserialize to workflowVertex object", e.getMessage(), e);
        }
        return workflowVertex;
    }

    /**
     * serialize and save workflowVertex object to File *.wfv
     * @param workflowVertex
     * @param file
     * @return
     */
    public static File saveWorkflowVertex(WorkflowVertex workflowVertex, File file){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(workflowVertex);
            objectOutputStream.close();
        } catch (IOException e) {
            NotificationsFxFactory.showError(
                    "serialize and save workflowVertex object to File *.wfv", e.getMessage(), e);
        }
        return file;
    }

}
