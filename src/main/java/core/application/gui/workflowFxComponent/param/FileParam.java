package core.application.gui.workflowFxComponent.param;

import javafx.beans.value.ObservableValue;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.editor.PropertyEditor;
import java.io.File;
import java.util.Optional;

/**
 * Created by anonymous on 26.03.2019.
 * start refactor 09.07.2020
 */
public class FileParam implements PropertySheet.Item{
    private File file;
    private String fileChooserTitle;
    private File FileChooserInitialDirectory;
    private String FileChooserComment;
    private String[] extensions;
    private String category, name;
    private ShowDialogEnum showDialogType;
    //private transient FileChooser.ExtensionFilter extensionFilter;

    public FileParam setFileChooserTitle(String fileChooserTitle) {
        this.fileChooserTitle = fileChooserTitle;
        return this;
    }

    public FileParam setFileChooserInitialDirectory(File fileChooserInitialDirectory) {
        FileChooserInitialDirectory = fileChooserInitialDirectory;
        return this;
    }

    public FileParam setFileChooserComment(String fileChooserComment) {
        FileChooserComment = fileChooserComment;
        return this;
    }

    public FileParam setExtensions(String[] extensions) {
        this.extensions = extensions;
        return this;
    }

    public String getFileChooserTitle() {
        return fileChooserTitle;
    }

    public File getFileChooserInitialDirectory() {
        return FileChooserInitialDirectory;
    }

    public String getFileChooserComment() {
        return FileChooserComment;
    }

    public String[] getExtensions() {
        return extensions;
    }

    public File getFile() {
        return file;
    }

    public FileParam setFile(File file) {
        this.file = file;
        return this;
    }

    public String getFileExtension(){
        String fileName;
        String fileExtension = null;
        if(this.file!=null && file.isFile()) {
            fileName = file.getName();
            fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1, file.getName().length());
        }
        return fileExtension;
    }

    public FileParam setCategory(String category) {
        this.category = category;
        return this;
    }

    public FileParam setName(String name) {
        this.name = name;
        return this;
    }

    public ShowDialogEnum getShowDialogType() {
        return showDialogType;
    }

    public FileParam setShowDialogType(ShowDialogEnum showDialogType) {
        this.showDialogType = showDialogType;
        return this;
    }

    @Override
    public Class<?> getType() {
        return this.getClass();
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.FileChooserComment;
    }

    @Override
    public Object getValue() {
        return this;
    }

    @Override
    public void setValue(Object o) {
        FileParam fp = (FileParam)o;
        setFile(fp.getFile());
        setFileChooserTitle(fp.getFileChooserTitle());
        setFileChooserInitialDirectory(fp.getFileChooserInitialDirectory());
        setFileChooserComment(fp.getFileChooserComment());
        setExtensions(fp.getExtensions());
        setCategory(fp.getCategory());
        setName(fp.getName());
    }

    @Override
    public Optional<ObservableValue<? extends Object>> getObservableValue() {
        return Optional.empty();
    }

    @Override
    public Optional<Class<? extends PropertyEditor<?>>> getPropertyEditorClass() {
        return Optional.of(FileParamEditor.class);
    }
}
